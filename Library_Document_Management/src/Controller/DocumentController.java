/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.DAO.DocumentDAO;
import Model.DTO.DocumentDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vutro
 */
public class DocumentController {

    private static final DocumentController INSTANCE
            = new DocumentController();
    DocumentDAO Book = new DocumentDAO();

    public DocumentController() {

    }

    public static DocumentController GetInstance() {
        return INSTANCE;
    }

    public ArrayList<DocumentDTO> getAllDocument() {
        ArrayList<DocumentDTO> ListDocument = new ArrayList<>();
        try {
            ListDocument = Book.getAllDocument();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return ListDocument;
        }
    }

    public DocumentDTO getDocumentByName(String name) {
        try {
            return Book.getDocumentByName(name);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addDocument(DocumentDTO document) {
        try {
            return Book.addDocument(document);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateDocument(DocumentDTO document) {
        try {
            return Book.updateDocument(document);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteDocument(String name) {
        try {
            return Book.deleteDocument(name);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
