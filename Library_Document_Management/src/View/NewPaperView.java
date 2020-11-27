/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.NewPaperController;

import Model.DTO.NewPaperDTO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vutro
 */
public class NewPaperView {

    NewPaperController NewPaper = NewPaperController.GetInstance();
    Scanner sc = new Scanner(System.in);

    public void View() {

        while (true) {
            boolean response;
            System.out.println("1, getAllNewPaper");
            System.out.println("2, getNewPaperByName");
            System.out.println("3, addNewPaper");
            System.out.println("4, updateNewPaper");
            System.out.println("5, deleteNewPaper");
            System.out.println("nhap lua chon ");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    ArrayList<NewPaperDTO> getallNewPaper = NewPaper.getAllNewPaper();
                    for (int i = 0; i < getallNewPaper.size(); i++) {
                        System.out.println(getallNewPaper.get(i).toString());
                    }
                    break;
                case "2":
                    System.out.println("nhap ten ");
                    String name = sc.nextLine();
                    System.out.println(NewPaper.getNewPaperByName(name).toString());
                    break;
                case "3":
                    NewPaperDTO newPaper = new NewPaperDTO();
                    System.out.println("nhap id ");
                    newPaper.setId(sc.nextLine());
                    System.out.println("nhap ten sach");
                    newPaper.setName(sc.nextLine());
                    System.out.println("nhap gia");
                    newPaper.setPrice(sc.nextFloat());
                    System.out.println("nhap author");
                    sc.nextLine();
                    newPaper.setAuthor(sc.nextLine());
                    System.out.println("nhap Producer");
                    newPaper.setProducer(sc.nextLine());
                    System.out.println("nhap Publishing_company");
                    newPaper.setPublishing_company(sc.nextLine());
                    System.out.println("nhap Type");
                    newPaper.setType(sc.nextLine());
                    System.out.println("nhap Issue_number");
                    newPaper.setIssue_number(sc.nextInt());
                    response = NewPaper.addNewPaper(newPaper);
                    if (response) {
                        System.out.println("success");
                    } else {
                        System.out.println("fail");
                    }
                    break;
                case "4":
                    NewPaperDTO NewPaper1 = new NewPaperDTO();
                    System.out.println("nhap id ");
                    NewPaper1.setId(sc.nextLine());
                    System.out.println("nhap ten sach");
                    NewPaper1.setName(sc.nextLine());
                    System.out.println("nhap gia");
                    NewPaper1.setPrice(sc.nextFloat());
                    System.out.println("nhap author");
                    sc.nextLine();
                    NewPaper1.setAuthor(sc.nextLine());
                    System.out.println("nhap Producer");
                    NewPaper1.setProducer(sc.nextLine());
                    System.out.println("nhap Publishing_company");
                    NewPaper1.setPublishing_company(sc.nextLine());
                    System.out.println("nhap Type");
                    NewPaper1.setType(sc.nextLine());
                    System.out.println("nhap Issue_number");
                    NewPaper1.setIssue_number(sc.nextInt());
                    response = NewPaper.updateNewPaper(NewPaper1);
                    if (response) {
                        System.out.println("success");
                    } else {
                        System.out.println("fail");
                    }
                    break;
                case "5":
                    System.out.println("nhap ten sach muon xoa");
                    String name1 = sc.nextLine();
                    response = NewPaper.deleteNewPaper(name1);
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
