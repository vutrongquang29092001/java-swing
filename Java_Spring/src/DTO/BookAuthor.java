/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Entity.Book;

/**
 *
 * @author vutro
 */
public class BookAuthor extends Book{
    private String authorName;

    @Override
    public String toString() {
        return "BookAuthor{" + "authorName=" + authorName + super.toString()+'}';
    }

    public BookAuthor() {
    }

    public BookAuthor( String id, String name, String author, String price,String authorName) {
        super(id, name, author, price);
        this.authorName = authorName;
    }

    

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    
    
}
