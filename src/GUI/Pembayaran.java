/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Tubes_Kel6.detailBarang;
import Tubes_Kel6.Pengirim;
import Tubes_Kel6.admin;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author paman
 */
public class Pembayaran extends javax.swing.JFrame {

    /**
     * Creates new form MetodePembayaran
     */ 
    public Pembayaran() {
        initComponents();
        viewKeranjang();
        TotalOngkir();
//        view_transaksi();
//        tracking_cbUbahStatus.setVisible(false);
//        tracking_btnSubmit.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pembayaran_penerima = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pembayaran_tblKeranjang = new javax.swing.JTable();
        pembayaran_pengirim = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        pembayaran_alamatTujuan = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        pembayaran_totalHarga = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pembayaran_pembayaran = new javax.swing.JTextField();
        layananStandard = new javax.swing.JRadioButton();
        pembayaran_btnBayar = new javax.swing.JButton();
        layananOneDay = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnback = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pembayaran");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("Penerima         :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, -1));

        jLabel15.setText("Pengirim          :");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(66, 58, 97));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PEMBAYARAN");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 260, -1));
        getContentPane().add(pembayaran_penerima, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 231, -1));

        pembayaran_tblKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Ukuran Barang", "Berat Barang", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(pembayaran_tblKeranjang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 743, 96));
        getContentPane().add(pembayaran_pengirim, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 231, -1));

        pembayaran_alamatTujuan.setColumns(20);
        pembayaran_alamatTujuan.setRows(5);
        jScrollPane4.setViewportView(pembayaran_alamatTujuan);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 231, -1));

        jLabel12.setText("Total Harga     :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 79, -1));

        pembayaran_totalHarga.setEditable(false);
        getContentPane().add(pembayaran_totalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 230, -1));

        jLabel13.setText("Pembayaran    : ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel16.setText("Jenis Pengiriman:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));
        getContentPane().add(pembayaran_pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 230, -1));

        buttonGroup2.add(layananStandard);
        layananStandard.setText("Standard");
        layananStandard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layananStandardActionPerformed(evt);
            }
        });
        getContentPane().add(layananStandard, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        pembayaran_btnBayar.setText("Bayar");
        pembayaran_btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pembayaran_btnBayarActionPerformed(evt);
            }
        });
        getContentPane().add(pembayaran_btnBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, -1, -1));

        buttonGroup2.add(layananOneDay);
        layananOneDay.setText("One Day");
        layananOneDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layananOneDayActionPerformed(evt);
            }
        });
        getContentPane().add(layananOneDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, -1, -1));

        jLabel9.setText("Alamat Tujuan :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 58, 97), 2));
        jPanel2.setOpaque(false);

        btnback.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnback.setForeground(new java.awt.Color(66, 58, 97));
        btnback.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnback.setText("< Back");
        btnback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnback, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnback, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 550));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 800, 10));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void layananStandardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layananStandardActionPerformed
        TotalOngkir();
    }//GEN-LAST:event_layananStandardActionPerformed

    private void pembayaran_btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pembayaran_btnBayarActionPerformed
        try {
            int countkeranjang = (int) pembayaran_tblKeranjang.getRowCount();
            String nama_pengirim = pembayaran_pengirim.getText();
            String nama_penerima = pembayaran_penerima.getText();
            String alamat = pembayaran_alamatTujuan.getText();
            String jenis_pengiriman = "";
            if (layananStandard.isSelected()) {
                jenis_pengiriman = "Standard";
            } else if (layananOneDay.isSelected()) {
                jenis_pengiriman = "One Day";
            }
            int total_harga = Integer.parseInt(pembayaran_totalHarga.getText());
            int Pembayaran = Integer.parseInt(pembayaran_pembayaran.getText());
            String status_barang = "Diproses";

            if (nama_pengirim.isEmpty() || nama_penerima.isEmpty() || alamat.isEmpty() || jenis_pengiriman.isEmpty() || Pembayaran == 0) {
                JOptionPane.showMessageDialog(null, "Harap isi semua data", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (countkeranjang < 1) {
                JOptionPane.showMessageDialog(null, "Anda belum memiliki barang untuk dikirim", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (Pembayaran < total_harga) {
                JOptionPane.showMessageDialog(null, "Uang yang anda miliki tidak mencukupi untuk melakukan transaksi", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {

                new Pengirim().input_transaksi(nama_pengirim, nama_penerima, alamat, jenis_pengiriman, total_harga, Pembayaran, status_barang);

                input_detail();

                new admin().truncate_keranjang();

                DefaultTableModel model = (DefaultTableModel) pembayaran_tblKeranjang.getModel();
                model.setRowCount(0);
                viewKeranjang();
                TotalOngkir();

                pembayaran_pengirim.setText("");
                pembayaran_penerima.setText("");
                pembayaran_alamatTujuan.setText("");
                pembayaran_pembayaran.setText("");

                JOptionPane.showMessageDialog(null, "Transaksi sukses", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pembayaran_btnBayarActionPerformed

    private void layananOneDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layananOneDayActionPerformed
        TotalOngkir();
    }//GEN-LAST:event_layananOneDayActionPerformed

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_btnbackMouseClicked
    
    public void viewKeranjang() {
        try {
            ArrayList<detailBarang> list = new admin().dataKeranjang();
            DefaultTableModel model = (DefaultTableModel) pembayaran_tblKeranjang.getModel();
            Object[] row = new Object[5];
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId_barang();
                row[1] = list.get(i).getNama_barang();
                row[2] = list.get(i).getJenis_barang();
                row[3] = list.get(i).getBerat() + " Kg";
                row[4] = "Rp. " + list.get(i).getSub_total();
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnback;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton layananOneDay;
    private javax.swing.JRadioButton layananStandard;
    private javax.swing.JTextArea pembayaran_alamatTujuan;
    private javax.swing.JButton pembayaran_btnBayar;
    private javax.swing.JTextField pembayaran_pembayaran;
    private javax.swing.JTextField pembayaran_penerima;
    private javax.swing.JTextField pembayaran_pengirim;
    private javax.swing.JTable pembayaran_tblKeranjang;
    private javax.swing.JTextField pembayaran_totalHarga;
    // End of variables declaration//GEN-END:variables
    public void input_detail() {
        try {
            admin Admin = new admin();
            ArrayList<detailBarang> list = Admin.dataKeranjang();
            int last_id = Integer.parseInt(Admin.lastInput_transaksi());
            Object[] row = new Object[5];
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId_barang();
                row[1] = list.get(i).getNama_barang();
                row[2] = list.get(i).getJenis_barang();
                row[3] = list.get(i).getBerat();
                row[4] = list.get(i).getSub_total();
                int id_barang = Integer.parseInt(row[0].toString());
                String nama_barang = row[1].toString();
                String jenis_barang = row[2].toString();
                int berat = Integer.parseInt(row[3].toString());
                int sub_total = Integer.parseInt(row[4].toString());
                Admin.input_detailTransaksi(last_id, id_barang, nama_barang, jenis_barang, berat, sub_total);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    

    public void TotalOngkir() {
        try {
            Pengirim pengirim = new Pengirim();
            Integer total = Integer.parseInt(pengirim.sum_subTotal());
            //System.out.println("GUI.User.sum() = "+total);
            if (total == 0) {
                pembayaran_totalHarga.setText("0");
            } else {
                if (layananStandard.isSelected()) {
                    total = total + 8000;
                } else if (layananOneDay.isSelected()) {
                    total = total + 15000;
                }
                String totali = total.toString();
                pembayaran_totalHarga.setText(totali);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
