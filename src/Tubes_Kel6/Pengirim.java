/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_Kel6;

import java.io.Serializable;

/**
 *
 * @author paman
 */
public class Pengirim implements Serializable{
    private int id_pengirim;
    private String username,password;

    public Pengirim(int id_pengirim, String username, String password) {
        this.id_pengirim = id_pengirim;
        this.username = username;
        this.password = password;
    }

    public int getId_pengirim() {
        return id_pengirim;
    }

    public void setId_pengirim(int id_pengirim) {
        this.id_pengirim = id_pengirim;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
