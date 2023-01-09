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
public class Kurir implements Serializable{
    private int id_kurir;
    private String username,password;

    public Kurir(int id_kurir, String username, String password) {
        this.id_kurir = id_kurir;
        this.username = username;
        this.password = password;
    }

    public int getId_pengirim() {
        return id_kurir;
    }

    public void setId_pengirim(int id_kurir) {
        this.id_kurir = id_kurir;
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
