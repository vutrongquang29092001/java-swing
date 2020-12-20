package com.example.SpringBeginner.service;


import com.example.SpringBeginner.entity.author;
import com.example.SpringBeginner.respository.repositoryAuthor;


import java.sql.SQLException;
import java.util.ArrayList;

public class serviceAuthor {
    private repositoryAuthor rp = new repositoryAuthor();
    public ArrayList<author> getAllAuthors(){
        try{
            return rp.getAllAuthors();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public  boolean addAuthor(author Author){
        try{
            return rp.addAuthor(Author);
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    public boolean updateAuthor(author Author){
        try{
            return rp.updateAuthor(Author);

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean deleteAuthor(String id){
        try{
            return rp.deleteAuthor(id);

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
