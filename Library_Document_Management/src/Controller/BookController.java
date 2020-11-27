/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.BookDAO;
import Model.DTO.BookDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vutro
 */
public class BookController {
    private static final BookController INSTANCE
                 = new BookController();
    BookDAO Book = new BookDAO();
    private BookController(){
        
        
    }
    public static BookController GetInstance(){
        return INSTANCE ;
    }
    public ArrayList<BookDTO> getAllBook(){
        ArrayList<BookDTO> ListBook = new ArrayList<>();
        try {
            ListBook = Book.getAllBook();
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            return ListBook;
        }
    }
    public BookDTO getBookByName(String name) {
        try {
           return Book.getBookByName(name) ;
        } catch (Exception e) {
            return null;
        }
    }
    public boolean addBook(BookDTO document){
        try {
            return Book.addBook(document);
        } catch (SQLException e) {
            System.out.println(e);
            return false ;
        }
    }
    public boolean updateBook(BookDTO document){
        try {
            return Book.updateBook(document);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean deleteBook(String name){
        try {
            return Book.deleteBook(name);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
