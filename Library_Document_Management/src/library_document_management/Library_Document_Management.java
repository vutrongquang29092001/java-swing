/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_document_management;

import Controller.MagazinesController;
import View.NewPaperView;
import View.BookView;
import View.DocumentView;
import View.MagazinesView;
import java.util.Scanner;

/**
 *
 * @author vutro
 */
public class Library_Document_Management {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1, Book ");
            System.out.println("2, NewPaper");
            System.out.println("3, Document");
            System.out.println("4, Magazines");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    BookView view = new BookView();
                    view.View();
                    break;
                case "2":
                    NewPaperView newpaperView = new NewPaperView ();
                    newpaperView.View();
                    break;
                case "3":
                    DocumentView documentView = new DocumentView();
                    documentView.View();
                    break;
                case "4":
                    MagazinesView magazinesView = new MagazinesView();
                    magazinesView.View();
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
