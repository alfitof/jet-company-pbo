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
public class Kurir implements Serializable{
    private int id_kurir;
    private String username,password;
    String data="";
    private boolean found=false;
    ArrayList<Kurir> dataKurir=new ArrayList<>();
    ArrayList<Transaksi> dataTransaksi = new ArrayList<>();


    public Kurir(int id_kurir, String username, String password) {
        this.id_kurir = id_kurir;
        this.username = username;
        this.password = password;
    }
    
    public Kurir(){
    }
    
    public boolean getLoginKurir(String user, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
          //  Statement st = (Statement) con.createStatement();
            PreparedStatement ps = con.prepareStatement("select * from akun_kurir where username=? and password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
           // id=rs.getString(1);
            Kurir kurir = null;
            while(rs.next()){
                kurir = new Kurir(rs.getInt("id_kurir"), rs.getString("username"), rs.getString("password"));
                dataKurir.add(kurir);
            }
            if (kurir==null){
            
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
    
    public void updateStatus(String id, String status)  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            PreparedStatement ps = con.prepareStatement("update transaksi set status_barang=? where id_transaksi=?");
            ps.setString(1, status);
            ps.setString(2, id);
            ps.executeUpdate();
            System.out.println("Update Status Sukses");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public ArrayList<Transaksi> operator_tracking(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");//  Statement st = (Statement) con.createStatement();
            PreparedStatement ps = con.prepareStatement("select * from transaksi where id_transaksi=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            Transaksi transaksi;
            while (rs.next()) {
                transaksi = new Transaksi(rs.getInt("id_transaksi"), rs.getInt("total_harga"), rs.getInt("pembayaran"), rs.getString("pengirim"), rs.getString("penerima"), rs.getString("alamat_tujuan"), rs.getString("jenis_pengiriman"), rs.getString("tanggal_transaksi"), rs.getString("status_barang"));
                dataTransaksi.add(transaksi);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dataTransaksi;
    }
    
    public ArrayList<Transaksi> dataTransaksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "select * from transaksi";
            ResultSet rs = st.executeQuery(sql);
            Transaksi transaksi;
            while (rs.next()) {
                transaksi = new Transaksi(rs.getInt("id_transaksi"), rs.getInt("total_harga"), rs.getInt("pembayaran"), rs.getString("pengirim"), rs.getString("penerima"), rs.getString("alamat_tujuan"), rs.getString("jenis_pengiriman"), rs.getString("tanggal_transaksi"), rs.getString("status_barang"));
                dataTransaksi.add(transaksi);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return dataTransaksi;
    }

    public String update_table(String table){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "select * from "+table;
            ResultSet rs = st.executeQuery(sql);
            data = rs.toString();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return data;
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
