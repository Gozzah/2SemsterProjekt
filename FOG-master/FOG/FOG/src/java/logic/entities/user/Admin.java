/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entities.user;

/**
 *
 * @author Peter
 */
public class Admin{
   
    private String username;
    private String password;
    private int ID;

    public Admin(String username, String password, int ID) {
        this.username = username;
        this.password = password;
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }
}
