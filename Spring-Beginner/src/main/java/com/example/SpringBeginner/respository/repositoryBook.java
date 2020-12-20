package com.example.SpringBeginner.respository;

import com.example.SpringBeginner.dto.bookAuthor;
import com.example.SpringBeginner.helper.databaseUtil;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class repositoryBook {
    databaseUtil db = new databaseUtil();
    private String sql = null;
        public  ArrayList<bookAuthor> getAllBooks  ()throws SQLException {
        // truy van du lieu
        // tao cau query
        //tra ve du lieu
         sql = "SELECT Book.id, Book.name, Book.authorId , Book.price , Author.name FROM Book , Author  WHERE Book.authorId = Author.id ; ";
        try {
            ArrayList<bookAuthor> list = new ArrayList<>();
            ResultSet rs = db.excuteQuery(sql);
            while (rs.next()) {
                bookAuthor bookAuthor = new bookAuthor();
                bookAuthor.setId(rs.getString("id"));
                bookAuthor.setName(rs.getString("name"));
                bookAuthor.setAuthorId(rs.getString("authorId"));
                bookAuthor.setPrice(rs.getString("price"));
                bookAuthor.setAuthorName(rs.getString("name"));
                list.add(bookAuthor);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
public boolean addBook(bookAuthor BookAuthor) throws SQLException {

            sql = "INSERT INTO Book VALUES ("
                   + "'" + BookAuthor.getId()
                   + "' ,'" + BookAuthor.getName()
                   + "' ,'"+ BookAuthor.getAuthorId()
                   + "' ,'" + BookAuthor.getPrice()
                   + "');";
           try {

               if(db.updateQuery(sql)){
                   System.out.println("success");
                   return  true;
               }else{
                   System.out.println("fail");
                   return false;
               }
           } catch (Exception e){
               System.out.println(e);
               return false;
           }

}
public boolean check(String id){
             sql = "SELECT Author.id "
                     + "FROM Author "
                     + "WHERE Author.id = '"
                     + id
                     +"' ;";

    ResultSet rs = db.excuteQuery(sql);
    if(rs != null){
        return true;
    }else{
        return false;
    }
}
public  boolean updateBook(bookAuthor BookAuthor){
            String sql = "UPDATE Book "
                    + "SET "
                    + "name = '" + BookAuthor.getName()
                    + "' , authorId = '" + BookAuthor.getAuthorId()
                    + "' , price = '" + BookAuthor.getPrice()
                    + "' ;";
            try{
                db.updateQuery(sql);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }


}
public  boolean deleteBook(String id){
            sql = "DELETE FROM Book"
                    + " WHERE id = '" + id + "' ;";
            try{
                db.updateQuery(sql);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
}

}
