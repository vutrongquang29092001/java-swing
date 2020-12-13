package dto;

import entity.book;

public class bookAuthor extends book {
    private String authorName;

    @Override
    public String toString() {
        return "BookAuthor{" + "authorName=" + authorName + super.toString()+'}';
    }

    public bookAuthor() {
    }

    public bookAuthor( String id, String name, String author, String price,String authorName) {
        super(id, name, author, price);
        this.authorName = authorName;
    }



    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
