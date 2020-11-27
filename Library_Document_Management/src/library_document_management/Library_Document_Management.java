/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_document_management;

import View.NewPaperView;
import View.View;
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
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    View view = new View();
                    view.View();
                case "2":
                    NewPaperView newpaperView = new NewPaperView ();
                    newpaperView.View();
            }
        }
    }

}
