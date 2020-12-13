/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DTO.BookAuthor;
import Entity.Book;
import Helper.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vutro
 */
public class RepositoryBook {

    DatabaseUtil db = new DatabaseUtil();

//    public  ArrayList<BookAuthor> getAllBooks  ()throws SQLException{
//        // truy van du lieu 
//        // tao cau query
//        //tra ve du lieu
//        String sql = "SELECT Book.id, Book.name, Book.author,Book.price , Author.name FROM Book , Author  WHERE Book.author = Author.id  ";
//        try {
//            ArrayList<BookAuthor> list = new ArrayList<>();
//            ResultSet rs = db.excuteQuery(sql);
//            while (rs.next()) {                
//                BookAuthor bookAuthor = new BookAuthor();
//                bookAuthor.setId(rs.getString("id"));
//                bookAuthor.setName(rs.getString("name"));
//                bookAuthor.setAuthor(rs.getString("author"));
//                bookAuthor.setPrice(rs.getString("price"));
//                bookAuthor.setAuthorName(rs.getString("authorName"));
//                list.add(bookAuthor);
//            }
//            return list;
//        } catch (Exception e) {
//            System.out.println("ex");
//        }
//        return null;
//    } 
//   
    ArrayList<BookAuthor> listBooks = new ArrayList<>();

    public RepositoryBook() {

        BookAuthor book1 = new BookAuthor("0", "sach1", "1", "100", "quang");
//     

        BookAuthor book2 = new BookAuthor("1", "sach1", "2", "100", "quang");
        listBooks.add(book1);
        listBooks.add(book2);
    }

    public ArrayList<BookAuthor> getAllBooks() {

        return listBooks;
    }

    public boolean delete(int i) {
        listBooks.remove(i);
        return true;
    }
    public boolean  add(BookAuthor bookAuthor){
       for(int i = 0; i<listBooks.size();i++){
           if(bookAuthor.getAuthor().equals(listBooks.get(i).getAuthor())){
               listBooks.add(bookAuthor);
               return true;
           }else{
               return false;
           }
       }
        return false;
       
    }
    public boolean update(BookAuthor bookAuthor){
        for(int i = 0; i < listBooks.size(); i++){
            if(listBooks.get(i).getAuthor().equals(bookAuthor.getAuthor())){
                listBooks.get(i).setName(bookAuthor.getName());
                listBooks.get(i).setPrice(bookAuthor.getPrice());
                return  true;
            }else{
                return false;
            }
        }
        return  false;
    }
    
}
