/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import DatabaseUtil.DatabaseUtil;

import Model.DTO.NewPaperDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vutro
 */
public class NewPaperDAO {

    DatabaseUtil dbUtil = new DatabaseUtil();

    public ArrayList<NewPaperDTO> getAllNewPaper() throws SQLException {
        String sql = "SELECT * FROM document WHERE type = 'NewPaper'; ";
        try {
            ArrayList<NewPaperDTO> NewPaperlist = new ArrayList<>();
            ResultSet rs = dbUtil.excuteQuery(sql);
            while (rs.next()) {
                NewPaperDTO NewPaper = new NewPaperDTO();
                NewPaper.setId(rs.getString("id"));
                NewPaper.setName(rs.getString("name"));
                NewPaper.setAuthor(rs.getString("Author"));
                NewPaper.setProducer(rs.getString("Producer"));
                NewPaper.setType(rs.getString("Type"));
                NewPaper.setPublishing_company(rs.getString("Publishing_company"));
                NewPaper.setIssue_number(rs.getInt("Issue_number"));
                NewPaper.setPrice(rs.getFloat("Price"));
                NewPaperlist.add(NewPaper);

            }
            return NewPaperlist;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public NewPaperDTO getNewPaperByName(String name) {
        String sql = "SELECT * FROM document WHERE type = 'NewPaper' AND name = '" + name + "' ;";
        try {
            ResultSet rs = dbUtil.excuteQuery(sql);
            if (rs != null) {
                rs.next();
                NewPaperDTO NewPaper = new NewPaperDTO();
                NewPaper.setId(rs.getString("id"));
                NewPaper.setName(rs.getString("name"));
                NewPaper.setAuthor(rs.getString("Author"));
                NewPaper.setProducer(rs.getString("Producer"));
                NewPaper.setType(rs.getString("Type"));
                NewPaper.setPublishing_company(rs.getString("Publishing_company"));
                NewPaper.setIssue_number(rs.getInt("Issue_number"));
                NewPaper.setPrice(rs.getFloat("Price"));
                if (dbUtil.updateQuery(sql)) {
                    System.out.println("success");
                    return NewPaper;
                } else {
                    System.out.println("fail");
                    return null;
                }
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public boolean addNewPaper(NewPaperDTO document) throws SQLException {
        String sql = "INSERT INTO document VALUES ("
                + "'" + document.getId()
                + "','" + document.getName()
                + "','" + document.getAuthor()
                + "','" + document.getProducer()
                + "','" + document.getType()
                + "','" + document.getPublishing_company()
                + "'," + document.getIssue_number()
                + "," + document.getPrice()
                + ") ;";
        System.out.println(sql);
        try {
            if (dbUtil.updateQuery(sql)) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean updateNewPaper(NewPaperDTO document) throws SQLException {
        String sql = "UPDATE document "
                + "SET id = '" + document.getId()
                + "' , price = " + document.getPrice()
                + " , author = '" + document.getAuthor()
                + "' , producer '" + document.getProducer()
                + "' , publishing_company '" + document.getPublishing_company()
                + "' , issue_number = " + document.getIssue_number()
                + " WHERE name = '" + document.getName()
                + "' AND type = '" + document.getType()
                + "' ;";
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

    public boolean deleteNewPaper(String name) throws SQLException {
        String sql = "DELETE FROM document "
                + "WHERE name = '" + name + "' AND type = 'NewPaper';";
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
