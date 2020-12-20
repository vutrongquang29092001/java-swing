/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.MagazinesDAO;
import Model.DTO.DocumentDTO;
import Model.DTO.MagazinesDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vutro
 */
public class MagazinesController {
      private static final MagazinesController INSTANCE
            = new MagazinesController();
    MagazinesDAO Book = new MagazinesDAO();

    public MagazinesController() {

    }

    public static MagazinesController GetInstance() {
        return INSTANCE;
    }

    public ArrayList<MagazinesDTO> getAllMagazines() {
        ArrayList<MagazinesDTO> ListMagazines = new ArrayList<>();
        try {
            ListMagazines = Book.getAllMagazines();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return ListMagazines;
        }
    }

    public MagazinesDTO getMagazinesByName(String name) {
        try {
            return Book.getMagazinesByName(name);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addMagazines(MagazinesDTO document) {
        try {
            return Book.addMagazines(document);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateMagazines(MagazinesDTO document) {
        try {
            return Book.updateMagazines(document);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteMagazines(String name) {
        try {
            return Book.deleteMagazines(name);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
