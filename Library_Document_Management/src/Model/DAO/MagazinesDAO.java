/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import DatabaseUtil.DatabaseUtil;

import Model.DTO.MagazinesDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vutro
 */
public class MagazinesDAO {

    DatabaseUtil dbUtil = new DatabaseUtil();

    public ArrayList<MagazinesDTO> getAllMagazines() throws SQLException {
        String sql = "SELECT * FROM document WHERE type = 'Magazines'; ";
        try {
            ArrayList<MagazinesDTO> Magazineslist = new ArrayList<>();
            ResultSet rs = dbUtil.excuteQuery(sql);
            while (rs.next()) {
                MagazinesDTO Magazines = new MagazinesDTO();
                Magazines.setId(rs.getString("id"));
                Magazines.setName(rs.getString("name"));
                Magazines.setAuthor(rs.getString("Author"));
                Magazines.setProducer(rs.getString("Producer"));
                Magazines.setType(rs.getString("Type"));
                Magazines.setPublishing_company(rs.getString("Publishing_company"));
                Magazines.setIssue_number(rs.getInt("Issue_number"));
                Magazines.setPrice(rs.getFloat("Price"));
                Magazineslist.add(Magazines);

            }
            return Magazineslist;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public MagazinesDTO getMagazinesByName(String name) {
        String sql = "SELECT * FROM document WHERE type = 'Magazines' AND name = '" + name + "' ;";
        try {
            ResultSet rs = dbUtil.excuteQuery(sql);
            if (rs != null) {
                rs.next();
                MagazinesDTO Magazines1 = new MagazinesDTO();
                Magazines1.setId(rs.getString("id"));
                Magazines1.setName(rs.getString("name"));
                Magazines1.setAuthor(rs.getString("Author"));
                Magazines1.setProducer(rs.getString("Producer"));
                Magazines1.setType(rs.getString("Type"));
                Magazines1.setPublishing_company(rs.getString("Publishing_company"));
                Magazines1.setIssue_number(rs.getInt("Issue_number"));
                Magazines1.setPrice(rs.getFloat("Price"));
                if (dbUtil.updateQuery(sql)) {
                    System.out.println("success");
                    return Magazines1;
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

    public boolean addMagazines(MagazinesDTO Magazines) throws SQLException {
        String sql = "INSERT INTO document VALUES ("
                + "'" + Magazines.getId()
                + "','" + Magazines.getName()
                + "','" + Magazines.getAuthor()
                + "','" + Magazines.getProducer()
                + "','" + Magazines.getType()
                + "','" + Magazines.getPublishing_company()
                + "'," + Magazines.getIssue_number()
                + "," + Magazines.getPrice()
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

    public boolean updateMagazines(MagazinesDTO Magazines) throws SQLException {
        String sql = "UPDATE document "
                + "SET id = '" + Magazines.getId()
                + "' , price = " + Magazines.getPrice()
                + " , author = '" + Magazines.getAuthor()
                + "' , producer = '" + Magazines.getProducer()
                + "' , publishing_company = '" + Magazines.getPublishing_company()
                + "' , issue_number = " + Magazines.getIssue_number()
                + " WHERE name = '" + Magazines.getName()
                + "' AND type = '" + Magazines.getType()
                + "' ;";
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

    public boolean deleteMagazines(String name) throws SQLException {
        String sql = "DELETE FROM document "
                + "WHERE name = '" + name + "' AND type = 'Magazines';";
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
