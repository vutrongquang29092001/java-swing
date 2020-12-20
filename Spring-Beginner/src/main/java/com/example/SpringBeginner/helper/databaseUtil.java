package com.example.SpringBeginner.helper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class databaseUtil {
    private Connection connection = null;
    private Statement stmt = null ;
    private ResultSet rs = null ;
public databaseUtil()  {
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }catch (ClassNotFoundException e) {
        System.out.println(e);
        return ;
    }
       try {
           connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_spring", "root", "vutrongquang29092001");
           System.out.println("Connection!");
       } catch (SQLException ex) {
           System.out.println(ex);
           return ;
       }

}
public ResultSet excuteQuery(String sql){
    try {
         stmt = connection.createStatement();
        System.out.println("query: "+ sql);
         rs = stmt.executeQuery(sql);
        return rs ;
    } catch (SQLException ex) {
        System.out.println(ex);
        return null;
    }

}
public boolean updateQuery(String sql) throws SQLException {
    try {
        stmt = connection.createStatement();
        System.out.println("query: "+ sql);
         stmt.execute(sql);
         return  true;
    } catch (SQLException ex) {
        Logger.getLogger(databaseUtil.class.getName()).log(Level.SEVERE,null,ex);

        return false;
    }
}
public boolean closeConnection(){
    try{
        if (rs != null) {
            rs.close();
        }

        if (stmt!= null) {
            stmt.close();
        }

        if (connection != null) {
            connection.close();
        }
        return true;
    } catch (SQLException throwables) {
        throwables.printStackTrace();
        return false;
    }
}
}
