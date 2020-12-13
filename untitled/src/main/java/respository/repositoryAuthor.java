package respository;


import entity.author;
import helper.databaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class repositoryAuthor {
    databaseUtil db = new databaseUtil();
    private String sql = null;
    public ArrayList<author> getAllAuthors  ()throws SQLException {
        // truy van du lieu
        // tao cau query
        //tra ve du lieu
        sql = "SELECT * FROM Author  ; ";
        try {
            ArrayList<author> list = new ArrayList<>();
            ResultSet rs = db.excuteQuery(sql);
            while (rs.next()) {
                author Author = new author();
                Author.setId(rs.getString("id"));
                Author.setName(rs.getString("name"));
                Author.setAge(rs.getString("age"));
                list.add(Author);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public boolean addAuthor(author Author) throws SQLException {

        sql = "INSERT INTO Author VALUES ("
                + "'" + Author.getId()
                + "','" + Author.getName()
                + "','"+ Author.getAge()
                + "') ;";
        try {

            if(db.updateQuery(sql)){
                System.out.println("success");
                return  true;
            }else{
                System.out.println("fail");
                return false;
            }
        } catch (Exception e){
            System.out.println(e);
            return false;
        }

    }
    public boolean check(String id){
        sql = "SELECT Author.id "
                + "FROM Author "
                + "WHERE Author.id = '"
                + id
                +"' ;";

        ResultSet rs = db.excuteQuery(sql);
        if(rs != null){
            return true;
        }else{
            return false;
        }
    }
    public  boolean updateAuthor(author Author){
        String sql = "UPDATE Author "
                + "SET "
                + "name = '" + Author.getName()
                + "' , age = '" + Author.getAge()
                + "' WHERE id = '" + Author.getId()
                + "' ;";
        try{
            db.updateQuery(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
    public  boolean deleteAuthor(String id){
        sql = "DELETE FROM Author"
                + " WHERE id = '" + id + "' ;";
        try{
            db.updateQuery(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
