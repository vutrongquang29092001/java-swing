/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import DatabaseUtil.DatabaseUtil;
import Model.DTO.BookDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vutro
 */
public class BookDAO {

    DatabaseUtil dbUtil = new DatabaseUtil();

    public ArrayList<BookDTO> getAllBook() throws SQLException {
        String sql = "SELECT * FROM document WHERE type = 'Book'; ";
        try {
            ArrayList<BookDTO> Booklist = new ArrayList<>();
            ResultSet rs = dbUtil.excuteQuery(sql);
            while (rs.next()) {
                BookDTO Book = new BookDTO();
                Book.setId(rs.getString("id"));
                Book.setName(rs.getString("name"));
                Book.setAuthor(rs.getString("Author"));
                Book.setProducer(rs.getString("Producer"));
                Book.setType(rs.getString("Type"));
                Book.setPublishing_company(rs.getString("Publishing_company"));
                Book.setIssue_number(rs.getInt("Issue_number"));
                Book.setPrice(rs.getFloat("Price"));
                Booklist.add(Book);

            }
            return Booklist;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public BookDTO getBookByName(String name) {
        String sql = "SELECT * FROM document WHERE type = 'Book' AND name = " + name + ";";
        try {
            ResultSet rs = dbUtil.excuteQuery(sql);
            BookDTO Book = new BookDTO();
            Book.setId(rs.getString("id"));
            Book.setName(rs.getString("name"));
            Book.setAuthor(rs.getString("Author"));
            Book.setProducer(rs.getString("Producer"));
            Book.setType(rs.getString("Type"));
            Book.setPublishing_company(rs.getString("Publishing_company"));
            Book.setIssue_number(rs.getInt("Issue_number"));
            Book.setPrice(rs.getFloat("Price"));
            if (dbUtil.updateQuery(sql)) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
            return Book;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public boolean addBook(BookDTO document) throws SQLException {
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

    public boolean updateBook(BookDTO document) throws SQLException {
        String sql = "UPDATE docment"
                + "SETid = " + document.getId()
                + " , price = " + document.getPrice()
                + ", author = " + document.getAuthor()
                + ", producer " + document.getProducer()
                + ", publishing_company " + document.getPublishing_company()
                + ", issue_number = " + document.getIssue_number()
                + ", type = " + document.getType()
                + "WHERE name = " + document.getName()
                + ";";
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

    public boolean deleteBook(String name) throws SQLException {
        String sql = "DELETE FROM document "
                + "WHERE name = " + name + ";";
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
