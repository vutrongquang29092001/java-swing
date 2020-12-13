package entity;

public class book {

    private String id;
    private String name;
    private String authorId;
    private String price;
    public book(){

    }
    public book(String id, String name , String authorId , String price){
        this.id = id;
        this.name = name;
        this.authorId = authorId;
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String author) {
        this.authorId = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " " + "id=" + id + ", name=" + name + ", author=" + authorId + ", price=" + price + '}';
    }
}