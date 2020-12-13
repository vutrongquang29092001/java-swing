package service;

import dto.bookAuthor;
import respository.repositoryBook;

import java.sql.SQLException;
import java.util.ArrayList;

public class service {
   private repositoryBook rp = new repositoryBook();
    public ArrayList<bookAuthor> getAllBooks(){
        try{
            return rp.getAllBooks();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public  boolean addBook(bookAuthor BookAuthor){
        try{
            return rp.addBook(BookAuthor);
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    public boolean updateBook(bookAuthor Bookauthor){
        try{
            return rp.updateBook(Bookauthor);

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean deleteBook(String id){
        try{
            return rp.deleteBook(id);

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean check(String id){
        try{
            return rp.check(id);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
