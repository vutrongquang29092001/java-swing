package com.example.SpringBeginner.view;

import com.example.SpringBeginner.controller.authorController;
import com.example.SpringBeginner.controller.bookController;
import com.example.SpringBeginner.dto.bookAuthor;
import com.example.SpringBeginner.entity.author;

import java.util.ArrayList;
import java.util.Scanner;


public class view {
    Scanner sc = new Scanner(System.in);

    public void ViewMain() {
        bookController bc = bookController.getInstance();
        authorController ac = authorController.getInstance();
        while (true) {
            System.out.println("1, getAllBookAuthor");
            System.out.println("2, addBook");
            System.out.println("3, updateBook");
            System.out.println("4, delete");
            System.out.println("5, addAuthor");

            String input = sc.nextLine();

            switch (input) {
                case "1":
ArrayList<bookAuthor> getAllBook = bc.getAllBooks();

                        for (int i = 0; i < getAllBook.size(); i++) {
                            System.out.println(getAllBook.get(i).toString());

                    }
                    break;
                case "2":
                    bookAuthor book = new bookAuthor();
                    System.out.println("nhap id");
                    book.setId(sc.nextLine());
                    System.out.println("nhap name");
                    book.setName(sc.nextLine());
                    System.out.println("nhap authorId");
                    book.setAuthorId(sc.nextLine());
                    System.out.println("nhap price");
                    book.setPrice(sc.nextLine());
                    boolean i = bc.addBook(book);
                    if(i == true){
                        System.out.println("success");
                    }else{
                        System.out.println("fail");
                    }
                    break;
                case "3":
                    bookAuthor book1 = new bookAuthor();
                    System.out.println("nhap id");
                    book1.setId(sc.nextLine());
                    System.out.println("nhap name");
                    book1.setName(sc.nextLine());
                    System.out.println("nhap authorId");
                    book1.setAuthorId(sc.nextLine());
                    System.out.println("nhap price");
                    book1.setPrice(sc.nextLine());
                    if(bc.check(book1.getId())==true){
                        if(bc.updateBook(book1)== true){
                            System.out.println("success");
                        }else{
                            System.out.println("fail");
                        }
                    }
                case "4":
                    System.out.println("nhap id");
                    String id = sc.nextLine();
                    boolean rs =  bc.deleteBook(id);
                    if(rs == true){
                        System.out.println("success!");
                    }else{
                        System.out.println("fail!");
                    }
                    break;
                case "5":
                    author Author = new author();
                    System.out.println("nhap id");
                    Author.setId(sc.nextLine());
                    System.out.println("nhap name");
                    Author.setName(sc.nextLine());
                    System.out.println("nhap age");
                    Author.setAge(sc.nextLine());
                    if(ac.addAuthor(Author) == true){
                        System.out.println("success");
                    }else{
                        System.out.println("fail");
                    }
                    break;
                default:
                    System.out.println(" chan roi a ");
                    System.out.println("Y/N");
                    String St = sc.nextLine();
                    if (St.equals("Y")) {
                        return;
                    } else {
                        break;
                    }
            }
        }

    }
}
