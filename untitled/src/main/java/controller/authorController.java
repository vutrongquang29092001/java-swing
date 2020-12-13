package controller;

import dto.bookAuthor;
import entity.author;
import service.serviceAuthor;

import java.util.ArrayList;

public class authorController {
    private static authorController instance;
    serviceAuthor Service = new serviceAuthor();

    public static authorController getInstance() {
        if (instance == null) {
            instance = new authorController();
        }
        return instance;
    }

    private authorController() {

    }

    public ArrayList<author> getAllAuthors() {
        return Service.getAllAuthors();
    }
    public boolean addAuthor(author Author){
        return Service.addAuthor(Author);
    }
    public boolean updateAuthor(author Author){
        return  Service.updateAuthor(Author);
    }
    public boolean deleteAuthor(String id){
        return  Service.deleteAuthor(id);
    }
    public boolean check(String id){
        return  Service.check(id);
    }
}
