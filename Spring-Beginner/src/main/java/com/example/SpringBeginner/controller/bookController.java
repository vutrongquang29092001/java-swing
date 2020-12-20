package com.example.SpringBeginner.controller;

import com.example.SpringBeginner.dto.bookAuthor;
import com.example.SpringBeginner.service.service;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
@RestController
@RequestMapping("/bookAuthor")
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
@GetMapping("/getAllBook")
    public ArrayList<bookAuthor> getAllBooks() {
        return Service.getAllBooks();
    }

    @PostMapping("/addBook")
    public boolean addBook1(@RequestBody bookAuthor BookAuthor){
        return Service.addBook(BookAuthor);
    }

    public boolean addBook(bookAuthor BookAuthor){
        return Service.addBook(BookAuthor);
    }
    @PutMapping("/updateBook{id}")
    public boolean updateBook1(@PathVariable("id") String id,@RequestBody bookAuthor BookAuthor){
        return  Service.updateBook(BookAuthor);
    }
    public boolean updateBook(bookAuthor BookAuthor){
        return  Service.updateBook(BookAuthor);
    }
    @DeleteMapping("/deleteBook{id}")
    public boolean deleteBook1(@PathVariable("id") String id){
        return  Service.deleteBook(id);
    }

    public boolean deleteBook(String id){
        return  Service.deleteBook(id);
    }
    public boolean check(String id){
        return  Service.check(id);
    }
}
