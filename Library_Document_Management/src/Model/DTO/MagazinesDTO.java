/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DTO;

/**
 *
 * @author vutro
 */
public class MagazinesDTO extends DocumentDTO{
    public MagazinesDTO(){
        
    }

    public MagazinesDTO(String id, String name, String author, String producer, String Type, String publishing_company, int issue_number, float price) {
        super(id, name, author, producer, Type, publishing_company, issue_number, price);
    }
    
}
