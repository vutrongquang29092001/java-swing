/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import DatabaseUtil.DatabaseUtil;

import Model.DTO.DocumentDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vutro
 */
public class DocumentDAO {

    DatabaseUtil dbUtil = new DatabaseUtil();

    public ArrayList<DocumentDTO> getAllDocument() throws SQLException {
        String sql = "SELECT * FROM document WHERE type = 'Document'; ";
        try {
            ArrayList<DocumentDTO> Documentlist = new ArrayList<>();
            ResultSet rs = dbUtil.excuteQuery(sql);
            while (rs.next()) {
                DocumentDTO Document = new DocumentDTO();
                Document.setId(rs.getString("id"));
                Document.setName(rs.getString("name"));
                Document.setAuthor(rs.getString("Author"));
                Document.setProducer(rs.getString("Producer"));
                Document.setType(rs.getString("Type"));
                Document.setPublishing_company(rs.getString("Publishing_company"));
                Document.setIssue_number(rs.getInt("Issue_number"));
                Document.setPrice(rs.getFloat("Price"));
                Documentlist.add(Document);

            }
            return Documentlist;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public DocumentDTO getDocumentByName(String name) {
        String sql = "SELECT * FROM document WHERE type = 'Document' AND name = '" + name + "';";
        try {
            ResultSet rs = dbUtil.excuteQuery(sql);
            if (rs != null) {
                rs.next();
                DocumentDTO Document = new DocumentDTO();
                Document.setId(rs.getString("id"));
                Document.setName(rs.getString("name"));
                Document.setAuthor(rs.getString("Author"));
                Document.setProducer(rs.getString("Producer"));
                Document.setType(rs.getString("Type"));
                Document.setPublishing_company(rs.getString("Publishing_company"));
                Document.setIssue_number(rs.getInt("Issue_number"));
                Document.setPrice(rs.getFloat("Price"));
                if (dbUtil.updateQuery(sql)) {
                    System.out.println("success");
                    return Document;
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

    public boolean addDocument(DocumentDTO document) throws SQLException {
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

    public boolean updateDocument(DocumentDTO document) throws SQLException {
        String sql = "UPDATE document "
                + "SET id = '" + document.getId()
                + "' , price = " + document.getPrice()
                + " , author = '" + document.getAuthor()
                + "' , producer = '" + document.getProducer()
                + "' , publishing_company = '" + document.getPublishing_company()
                + "' , issue_number = " + document.getIssue_number()
                + " WHERE name = '" + document.getName()
                + "' AND  type = '" + document.getType()
                + "';";
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

    public boolean deleteDocument(String name) throws SQLException {
        String sql = "DELETE FROM document "
                + "WHERE name = '" + name + "' AND type = 'Document'" +";";
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
