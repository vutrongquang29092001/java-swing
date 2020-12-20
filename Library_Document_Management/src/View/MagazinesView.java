/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MagazinesController;
import Model.DTO.MagazinesDTO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vutro
 */
public class MagazinesView {

    MagazinesController Magazines = MagazinesController.GetInstance();
    Scanner sc = new Scanner(System.in);

    public void View() {

        while (true) {
            boolean response;
            System.out.println("1, getAllMagazines");
            System.out.println("2, getMagazinesByName");
            System.out.println("3, addMagazines");
            System.out.println("4, updateMagazines");
            System.out.println("5, deleteMagazines");
            System.out.println("nhap lua chon ");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    ArrayList<MagazinesDTO> getallbook = Magazines.getAllMagazines();
                    for (int i = 0; i < getallbook.size(); i++) {
                        System.out.println(getallbook.get(i).toString());
                    }
                    break;
                case "2":
                    System.out.println("nhap ten ");
                    String name = sc.nextLine();
                    MagazinesDTO magazines1 = new MagazinesDTO();
                    magazines1 = Magazines.getMagazinesByName(name);
                    if (magazines1 != null) {
                        System.out.println(magazines1.toString());
                    }else{
                        System.out.println("ko co sach nay");
                    }

                    break;
                case "3":
                    MagazinesDTO magazines = new MagazinesDTO();
                    System.out.println("nhap id ");
                    magazines.setId(sc.nextLine());
                    System.out.println("nhap ten sach");
                    magazines.setName(sc.nextLine());
                    System.out.println("nhap gia");
                    magazines.setPrice(sc.nextFloat());
                    System.out.println("nhap author");
                    sc.nextLine();
                    magazines.setAuthor(sc.nextLine());
                    System.out.println("nhap Producer");
                    magazines.setProducer(sc.nextLine());
                    System.out.println("nhap Publishing_company");
                    magazines.setPublishing_company(sc.nextLine());
                    System.out.println("nhap Type");
                    magazines.setType(sc.nextLine());
                    System.out.println("nhap Issue_number");
                    magazines.setIssue_number(sc.nextInt());sc.nextLine();
                    response = Magazines.addMagazines(magazines);
                    if (response) {
                        System.out.println("success");
                    } else {
                        System.out.println("fail");
                    }
                    break;
                case "4":
                    MagazinesDTO Magazines1 = new MagazinesDTO();
                    System.out.println("nhap id ");
                    Magazines1.setId(sc.nextLine());
                    System.out.println("nhap ten sach");
                    Magazines1.setName(sc.nextLine());
                    System.out.println("nhap gia");
                    Magazines1.setPrice(sc.nextFloat());
                    System.out.println("nhap author");
                    sc.nextLine();
                    Magazines1.setAuthor(sc.nextLine());
                    System.out.println("nhap Producer");
                    Magazines1.setProducer(sc.nextLine());
                    System.out.println("nhap Publishing_company");
                    Magazines1.setPublishing_company(sc.nextLine());
                    System.out.println("nhap Type");
                    Magazines1.setType(sc.nextLine());
                    System.out.println("nhap Issue_number");
                    Magazines1.setIssue_number(sc.nextInt());sc.nextLine();
                    response = Magazines.updateMagazines(Magazines1);
                    if (response) {
                        System.out.println("success");
                    } else {
                        System.out.println("fail");
                    }
                    break;
                case "5":
                    System.out.println("nhap ten sach muon xoa");
                    String name1 = sc.nextLine();
                    response = Magazines.deleteMagazines(name1);
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
