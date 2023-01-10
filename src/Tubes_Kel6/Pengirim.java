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
public class Pengirim implements Serializable{
    private int id_pengirim;
    private String username,password;
    private String sum ="";
    ArrayList<Pengirim> dataPengirim = new ArrayList<>();
    private boolean found=false;
    ArrayList<Transaksi> dataTransaksi = new ArrayList<>();
    ArrayList<Barang> dataBarang = new ArrayList<>();
    private String id="";

    public Pengirim(int id_pengirim, String username, String password) {
        this.id_pengirim = id_pengirim;
        this.username = username;
        this.password = password;
    }

    public Pengirim() {
      
    }
    
    public boolean getLoginPengirim(String user, String pass){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from akun_pengirim where username=? and password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
           // id=rs.getString(1);
            Pengirim pengirim = null;
            while(rs.next()){
                pengirim = new Pengirim(rs.getInt("id_pengirim"), rs.getString("username"), rs.getString("password"));
                dataPengirim.add(pengirim);
            }
            if (pengirim==null){
            
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
    
    public void input_transaksi(String pengirim, String penerima, String alamat_tujuan, String jenis_pengiriman, int total_harga, int pembayaran, String status_barang)  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "insert into transaksi(pengirim, penerima, alamat_tujuan,jenis_pengiriman, total_harga, pembayaran, status_barang) "
                    + "values('" + pengirim + "', '" + penerima + "', '" + alamat_tujuan + "', '" + jenis_pengiriman + "', '" + total_harga + "', '" + pembayaran + "', '" + status_barang + "')";
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
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
    
    public String sum_subTotal(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "select sum(sub_total) from keranjang as total";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            sum = rs.getString(1);
            if(sum == null){
                sum="0";
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return sum;
    }
    
    public ArrayList<Barang> dataBarang(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "select * from barang";
            ResultSet rs = st.executeQuery(sql);
            Barang barang;
            while (rs.next()) {
                barang = new Barang(rs.getString("nama_barang"), rs.getString("jenis_barang"), rs.getInt("berat"), rs.getInt("sub_total"));
                dataBarang.add(barang);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return dataBarang;
    }
    
    public String lastInput_barang() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "SELECT * FROM barang ORDER BY id_barang DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            id = rs.getString(1);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }
    
    public String input_keranjang(String nama_barang, int id_barang, String jenis_barang, int berat, int sub_total){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "insert into keranjang(id_barang, nama_barang, jenis_barang, berat, sub_total) values('" + id_barang + "', '" + nama_barang + "', '" + jenis_barang + "', '" + berat + "', '" + sub_total + "')";
            st.executeUpdate(sql);
            return "Insert barang Sukses";
        } catch (Exception e) {
            return (e.toString());
        }
    }
    
    public String input_barang(String nama_barang, String jenis_barang, int berat, int sub_total){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "insert into barang(nama_barang, jenis_barang, berat, sub_total) values('" + nama_barang + "', '" + jenis_barang + "', '" + berat + "', '" + sub_total + "')";
            st.executeUpdate(sql);
            return "Insert barang Sukses";
        } catch (Exception e) {
            return (e.toString());
        }
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
