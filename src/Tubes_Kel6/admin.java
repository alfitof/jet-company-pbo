/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_Kel6;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author paman
 */
public class admin implements Serializable{
    private int id_admin;
    private String username,password;
    ArrayList<admin> dataAdmin=new ArrayList<>();
    private boolean found=false;
    private String id="";
    ArrayList<detailBarang> dataKeranjang = new ArrayList<>();

    public admin(int id_admin, String username, String password) {
        this.id_admin = id_admin;
        this.username = username;
        this.password = password;
    }

    public admin() {
        
    }
    
    public boolean getLogin(String user, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from admin where username=? and password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            admin Admin = null;
            while(rs.next()){
                Admin = new admin(rs.getInt("id_admin"), rs.getString("username"), rs.getString("password"));
                dataAdmin.add(Admin);
            }
            if (Admin==null){
            
                return found=false;
            }else
            {
                return found=true;
            }
        }
        catch(Exception ex){
        
            System.out.println(ex);
        }
        return found;
    }
    
    public void dalete_barang(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            //Statement st = (Statement) con.createStatement();
            //String sql = "delete from barang where nama_barang=?";
            PreparedStatement ps = con.prepareStatement("delete from barang where id_barang=?");
            //st.executeUpdate(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void dalete_keranjang(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            PreparedStatement ps = con.prepareStatement("delete from keranjang where id_barang=?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public String lastInput_transaksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "SELECT * FROM transaksi ORDER BY id_transaksi DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            id = rs.getString(1);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    public void input_detailTransaksi(int id_transaksi, int id_barang, String nama_barang, String jenis_barang, int berat, int sub_total){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "insert into detail_transaksi(id_transaksi, id_barang, nama_barang, jenis_barang, berat, sub_total) "
                    + "values('" + id_transaksi + "', '" + id_barang + "', '" + nama_barang + "', '" + jenis_barang + "', '" + berat + "', '" + sub_total + "')";
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void truncate_keranjang() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            PreparedStatement ps = con.prepareStatement("truncate table keranjang");
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
     public ArrayList<detailBarang> dataKeranjang(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "select * from keranjang";
            ResultSet rs = st.executeQuery(sql);
            detailBarang keranjang;
            while (rs.next()) {
                keranjang = new detailBarang(rs.getString("nama_barang"), rs.getString("jenis_barang"), rs.getInt("berat"), rs.getInt("sub_total"), rs.getInt("id_barang"));
                dataKeranjang.add(keranjang);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return dataKeranjang;
    }
    
    public String input_pelanggan(String nama, String alamat, String no_hp){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "insert into pelanggan(nama_pelanggan, alamat, no_hp) values('" + nama + "', '" + alamat + "', '" + no_hp + "')";
            st.executeUpdate(sql);
            return "Insert Sukses";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
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
