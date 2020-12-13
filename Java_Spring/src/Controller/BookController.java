/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.BookAuthor;

import Service.Service;
import java.util.ArrayList;

/**
 *
 * @author vutro
 */
public class BookController {

    private static BookController instance;
    Service service = new Service();

    public static BookController getInstance() {
        if (instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    public BookController() {

    }

    public ArrayList<BookAuthor> getAllBooks() {
        // goij toi service 
        return service.getAllBooks();
    }

    public boolean delete(String id) {
      return  service.deleteBook(id);
      
    }
    public boolean add(BookAuthor bookAuthor){
      return  service.add(bookAuthor);
        
    }
    public  boolean  update(BookAuthor bookAuthor){
        return service.update(bookAuthor);
    }
}
