/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BookController;
import Model.DTO.BookDTO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vutro
 */
public class View {

    BookController Book = BookController.GetInstance();
    Scanner sc = new Scanner(System.in);

    public void View() {

        while (true) {
            boolean response;
            System.out.println("1, getAllBook");
            System.out.println("2, getBookByName");
            System.out.println("3, addBook");
            System.out.println("4, updateBook");
            System.out.println("5, deleteBook");
            System.out.println("nhap lua chon ");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    ArrayList<BookDTO> getallbook = Book.getAllBook();
                    for (int i = 0; i < getallbook.size(); i++) {
                        System.out.println(getallbook.get(i).toString());
                    }
                    break;
                case "2":
                    System.out.println("nhap ten ");
                    String name = sc.nextLine();
                    System.out.println(Book.getBookByName(name).toString());
                    break;
                case "3":
                    BookDTO book = new BookDTO();
                    System.out.println("nhap id ");
                    book.setId(sc.nextLine());
                    System.out.println("nhap ten sach");
                    book.setName(sc.nextLine());
                    System.out.println("nhap gia");
                    book.setPrice(sc.nextFloat());
                    System.out.println("nhap author");
                    sc.nextLine();
                    book.setAuthor(sc.nextLine());
                    System.out.println("nhap Producer");
                    book.setProducer(sc.nextLine());
                    System.out.println("nhap Publishing_company");
                    book.setPublishing_company(sc.nextLine());
                    System.out.println("nhap Type");
                    book.setType(sc.nextLine());
                    System.out.println("nhap Issue_number");
                    book.setIssue_number(sc.nextInt());
                    response = Book.addBook(book);
                    if (response) {
                        System.out.println("success");
                    } else {
                        System.out.println("fail");
                    }
                    break;
                case "4":
                   BookDTO book1 = new BookDTO();
                    System.out.println("nhap id ");
                    book1.setId(sc.nextLine());
                    System.out.println("nhap ten sach");
                    book1.setName(sc.nextLine());
                    System.out.println("nhap gia");
                    book1.setPrice(sc.nextFloat());
                    System.out.println("nhap author");
                    sc.nextLine();
                    book1.setAuthor(sc.nextLine());
                    System.out.println("nhap Producer");
                    book1.setProducer(sc.nextLine());
                    System.out.println("nhap Publishing_company");
                    book1.setPublishing_company(sc.nextLine());
                    System.out.println("nhap Type");
                    book1.setType(sc.nextLine());
                    System.out.println("nhap Issue_number");
                    book1.setIssue_number(sc.nextInt());
                    response = Book.updateBook(book1);
                    if (response) {
                        System.out.println("success");
                    } else {
                        System.out.println("fail");
                    }
                    break;
                case "5":
                    System.out.println("nhap ten sach muon xoa");
                    String name1 = sc.nextLine();
                    response = Book.deleteBook(name1);
                    if (response) {
                        System.out.println("success");
                    } else {
                        System.out.println("fail");
                    }
                    break;
                default: System.out.println(" chan roi a ");
                    System.out.println("Y/N");
                    String St = sc.nextLine();
                    if(St.equals("Y")){
                        return ;
                    }else{
                        
                    }
            }
        }

    }
}
