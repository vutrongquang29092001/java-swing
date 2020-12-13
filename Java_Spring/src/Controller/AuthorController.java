/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author vutro
 */
public class AuthorController {
   private static BookController instance;

    public static BookController getInstance() {
        if(instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    private AuthorController() {

    }
}
