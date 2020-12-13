/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.BookAuthor;
import Repository.RepositoryBook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vutro
 */
public class Service {
//    public  List<BookAuthor> getAllBooks (){
//        // xu li nghiep vu 
//    } 

    RepositoryBook bookRepository = new RepositoryBook();

    public ArrayList<BookAuthor> getAllBooks() {
        // xu ly nghiep vu
        // call repository
        try {
            return bookRepository.getAllBooks();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteBook(String bookId) {
        // goi toi 1 ham gi do => check xem book co ton tai khong
        try {
             boolean isBookExist = false;
     int a = bookRepository.getAllBooks().size();
        for (int i = 0; i < a; i++) {
            if (bookRepository.getAllBooks().get(i).getId().equals(bookId)) {
                  isBookExist = bookRepository.delete(i);
                
            }
        }
        return isBookExist;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    

      
    
    }
    public  boolean  add(BookAuthor bookAuthor){
        try {
          return  bookRepository.add(bookAuthor);
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean update(BookAuthor bookAuthor){
        try {
          return  bookRepository.update(bookAuthor);
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
