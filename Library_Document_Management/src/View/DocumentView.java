/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DocumentController;
import Model.DTO.BookDTO;
import Model.DTO.DocumentDTO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vutro
 */
public class DocumentView {

    Scanner sc = new Scanner(System.in);
    DocumentController Document = DocumentController.GetInstance();

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
                    ArrayList< DocumentDTO> getallDocument = Document.getAllDocument();
                    for (int i = 0; i < getallDocument.size(); i++) {
                        System.out.println(getallDocument.get(i).toString());
                    }
                    break;
                case "2":
                    System.out.println("nhap ten ");
                    String name = sc.nextLine();
                    System.out.println(Document.getDocumentByName(name).toString());
                    break;
                case "3":
                    DocumentDTO document = new DocumentDTO();
                    System.out.println("nhap id ");
                    document.setId(sc.nextLine());
                    System.out.println("nhap ten sach");
                    document.setName(sc.nextLine());
                    System.out.println("nhap gia");
                    document.setPrice(sc.nextFloat());
                    System.out.println("nhap author");
                    sc.nextLine();
                    document.setAuthor(sc.nextLine());
                    System.out.println("nhap Producer");
                    document.setProducer(sc.nextLine());
                    System.out.println("nhap Publishing_company");
                    document.setPublishing_company(sc.nextLine());
                    System.out.println("nhap Type");
                    document.setType(sc.nextLine());
                    System.out.println("nhap Issue_number");
                    document.setIssue_number(sc.nextInt());
                    sc.nextLine();
                    response = Document.addDocument(document);
                    if (response) {
                        System.out.println("success");
                    } else {
                        System.out.println("fail");
                    }
                    break;
                case "4":
                    DocumentDTO document1 = new BookDTO();
                    System.out.println("nhap id ");
                    document1.setId(sc.nextLine());
                    System.out.println("nhap ten sach");
                    document1.setName(sc.nextLine());
                    System.out.println("nhap gia");
                    document1.setPrice(sc.nextFloat());
                    System.out.println("nhap author");
                    sc.nextLine();
                    document1.setAuthor(sc.nextLine());
                    System.out.println("nhap Producer");
                    document1.setProducer(sc.nextLine());
                    System.out.println("nhap Publishing_company");
                    document1.setPublishing_company(sc.nextLine());
                    System.out.println("nhap Type");
                    document1.setType(sc.nextLine());
                    System.out.println("nhap Issue_number");
                    document1.setIssue_number(sc.nextInt());
                    sc.nextLine();
                    response = Document.updateDocument(document1);
                    if (response) {
                        System.out.println("success");
                    } else {
                        System.out.println("fail");
                    }
                    break;
                case "5":
                    System.out.println("nhap ten sach muon xoa");
                    String name1 = sc.nextLine();
                    response = Document.deleteDocument(name1);
                    if (response) {
                        System.out.println("success");
                    } else {
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

                    }
            }
        }

    }
}
