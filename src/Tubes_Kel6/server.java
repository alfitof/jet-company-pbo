/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_Kel6;

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
public class server{

    public static void main(String[] args){
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

    public ArrayList<Barang> dataBarang(){
        ArrayList<Barang> dataBarang = new ArrayList<>();
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

    public String update_table(String table){
        String data="";
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

    public String sum_subTotal(){
        String sum ="";
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
    
    //SELECT * FROM tb_siswa ORDER BY id_siswa DESC LIMIT 1

    public ArrayList<Keranjang> dataKeranjang(){
        ArrayList<Keranjang> dataKeranjang = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            String sql = "select * from keranjang";
            ResultSet rs = st.executeQuery(sql);
            Keranjang keranjang;
            while (rs.next()) {
                keranjang = new Keranjang(rs.getString("nama_barang"), rs.getString("jenis_barang"), rs.getInt("berat"), rs.getInt("sub_total"), rs.getInt("id_barang"));
                dataKeranjang.add(keranjang);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return dataKeranjang;
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

    public String lastInput_barang() {
        String id="";
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

    public String lastInput_transaksi(){
        String id="";
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

    public ArrayList<Transaksi> dataTransaksi(){
        ArrayList<Transaksi> dataTransaksi = new ArrayList<>();
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

    public ArrayList<DetailTransaksi> dataDetailTransaksi(String id){
        ArrayList<DetailTransaksi> dataDetailTransaksi = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jasa_pengiriman2", "root", "");
            Statement st = (Statement) con.createStatement();
            PreparedStatement ps = con.prepareStatement("select * from detail_transaksi where id_transaksi=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            DetailTransaksi detailtransaksi;
            while (rs.next()) {
                detailtransaksi = new DetailTransaksi(rs.getInt("id_transaksi"), rs.getInt("id_barang"), rs.getString("nama_barang"), rs.getString("jenis_barang"), rs.getInt("berat"), rs.getInt("sub_total"));
                dataDetailTransaksi.add(detailtransaksi);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return dataDetailTransaksi;
    }

    public ArrayList<Transaksi> operator_tracking(String id){
        ArrayList<Transaksi> dataTransaksi = new ArrayList<>();
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

    public boolean getLogin(String user, String pass){
        ArrayList<admin> dataAdmin=new ArrayList<>();
        boolean found=false;
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
    
    public boolean getLoginPengirim(String user, String pass){
        ArrayList<Pengirim> dataPengirim = new ArrayList<>();
        boolean found=false;
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
    
    public boolean getLoginKurir(String user, String pass){
        ArrayList<Kurir> dataKurir=new ArrayList<>();
        boolean found=false;
        String id="";
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
    

}
