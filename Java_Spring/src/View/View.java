/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BookController;
import DTO.BookAuthor;
import java.util.Scanner;

/**
 *
 * @author vutro
 */
public class View {

    Scanner sc = new Scanner(System.in);
    BookController bc = BookController.getInstance();

    public void ViewMain() {
        while (true) {
            System.out.println("1, getAllBookAuthor");
            System.out.println("2, delete");
            System.out.println("3, add");
            System.out.println("4, update");
            String input = sc.nextLine();
            int a = bc.getAllBooks().size();
            switch (input) {
                case "1":
                    System.out.println(a);
                    for (int i = 0; i < a; i++) {
                        System.out.println(bc.getAllBooks().get(i).toString());
                    }
                    break;
                case "2":
                    System.out.println("nhap id");
                    String id = sc.nextLine();
                   boolean rs =  bc.delete(id);
                   if(rs == true){
                       System.out.println("success!");
                   }else{
                       System.out.println("fail!");
                   }
                    break;
                case "3":
                    BookAuthor bookAuthor = new BookAuthor();
                     System.out.println("nhap id");
                     bookAuthor.setId(sc.nextLine());
                     System.out.println("nhap name");
                     bookAuthor.setName(sc.nextLine());
                     System.out.println("nhap author");
                     bookAuthor.setAuthor(sc.nextLine());
                     System.out.println("nhap authorName");
                     bookAuthor.setAuthorName(sc.nextLine());
                     System.out.println("nhap price");
                     bookAuthor.setPrice(sc.nextLine());
                      boolean r =  bc.add(bookAuthor);
                   if(r == true){
                       System.out.println("success!");
                   }else{
                       System.out.println("fail!");
                   }
                    break;
                case "4":
                     BookAuthor bookAuthor1 = new BookAuthor();
                     System.out.println("nhap id");
                     bookAuthor1.setId(sc.nextLine());
                     System.out.println("nhap name");
                     bookAuthor1.setName(sc.nextLine());
                     System.out.println("nhap author");
                     bookAuthor1.setAuthor(sc.nextLine());
                     System.out.println("nhap authorName");
                     bookAuthor1.setAuthorName(sc.nextLine());
                     System.out.println("nhap price");
                     bookAuthor1.setPrice(sc.nextLine());
                      boolean i =  bc.update(bookAuthor1);
                   if(i == true){
                       System.out.println("success!");
                   }else{
                       System.out.println("fail!");
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
