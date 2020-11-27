/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseUtil;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author vutro
 */
public class DatabaseUtil {
    Connection connection = null;
    
    public DatabaseUtil(){
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
         
             return  ;
        }
        try {
            connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library_document_management","root","vutrongquang29092001");
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println(e);
            return ;
        }
       
    }
    public ResultSet  excuteQuery(String query){
        try {
            Statement stmt =  connection.createStatement();
            System.out.println("Excuting query: "+ query);
            ResultSet rs = stmt.executeQuery(query);
            return rs ;
        } catch (SQLException ex) {
             Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE,null,ex);
            return null ;
        }
    }
    public boolean updateQuery(String query){
        try {
            Statement stmt = connection.createStatement();
            System.out.println("Excuting query: " + query);
            stmt.execute(query);
            return true;
        } catch (SQLException e) {
           return false ;
        }
    }
    public boolean closeConnection(){
        try {
            connection.close();
            return  true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
}
