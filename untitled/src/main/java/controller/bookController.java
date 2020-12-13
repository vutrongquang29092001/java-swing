package controller;

import dto.bookAuthor;
import service.service;

import java.util.ArrayList;

public class bookController {
    private static bookController instance;
    service Service = new service();

    public static bookController getInstance() {
        if (instance == null) {
            instance = new bookController();
        }
        return instance;
    }

    private bookController() {

    }

    public ArrayList<bookAuthor> getAllBooks() {
        return Service.getAllBooks();
    }
    public boolean addBook(bookAuthor BookAuthor){
        return Service.addBook(BookAuthor);
    }
    public boolean updateBook(bookAuthor BookAuthor){
        return  Service.updateBook(BookAuthor);
    }
    public boolean deleteBook(String id){
        return  Service.deleteBook(id);
    }
    public boolean check(String id){
        return  Service.check(id);
    }
}
