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
public abstract class DocumentDTO {

    private String id;
    private String name;
    private String author;
    private String producer;
    private String type ;
    private String publishing_company;
    private int issue_number;
    private float price;

    public DocumentDTO() {
    }

    public DocumentDTO(String id, String name, String author, String producer,String Type, String publishing_company, int issue_number, float price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.producer = producer;
        this.type = Type ;
        this.publishing_company = publishing_company;
        this.issue_number = issue_number;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublishing_company() {
        return publishing_company;
    }

    public void setPublishing_company(String publishing_company) {
        this.publishing_company = publishing_company;
    }

    public int getIssue_number() {
        return issue_number;
    }

    public void setIssue_number(int issue_number) {
        this.issue_number = issue_number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DocumentDTO{" + "id=" + id + ", name=" + name + ", author=" + author + ", producer=" + producer + ", type=" + type + ", publishing_company=" + publishing_company + ", issue_number=" + issue_number + ", price=" + price + '}';
    }

   
    

}
