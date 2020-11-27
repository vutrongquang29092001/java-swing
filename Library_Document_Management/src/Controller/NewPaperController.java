/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.BookDAO;
import Model.DAO.NewPaperDAO;
import Model.DTO.BookDTO;
import Model.DTO.NewPaperDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vutro
 */
public class NewPaperController {
      private static final NewPaperController INSTANCE
                 = new NewPaperController();
    NewPaperDAO NewPaper = new NewPaperDAO();
    private NewPaperController(){
        
        
    }
    public static NewPaperController GetInstance(){
        return INSTANCE ;
    }
    public ArrayList<NewPaperDTO> getAllNewPaper(){
        ArrayList<NewPaperDTO> ListNewPaper = new ArrayList<>();
        try {
            ListNewPaper = NewPaper.getAllNewPaper();
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            return ListNewPaper;
        }
    }
    public NewPaperDTO getNewPaperByName(String name) {
        try {
           return NewPaper.getNewPaperByName(name) ;
        } catch (Exception e) {
            return null;
        }
    }
    public boolean addNewPaper(NewPaperDTO document){
        try {
            return NewPaper.addNewPaper(document);
        } catch (SQLException e) {
            System.out.println(e);
            return false ;
        }
    }
    public boolean updateNewPaper(NewPaperDTO document){
        try {
            return NewPaper.updateNewPaper(document);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean deleteNewPaper(String name){
        try {
            return NewPaper.deleteNewPaper(name);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
