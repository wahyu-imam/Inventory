/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import transaksi.keluar;
/**
 *
 * @author imam
 */
public class modalTransaksiKeluarHariIni extends javax.swing.JDialog {
    keluar keluar;
    MenuUtama mu;
    
    String[] session;
    
    DefaultTableModel modelTbCabang;
    DefaultTableModel modelTbPengecer;
    /**
     * Creates new form modalTransaksiKeluarHariIni
     */
    public modalTransaksiKeluarHariIni(java.awt.Frame parent, boolean modal, String[] session, MenuUtama mu) {
        super(parent, modal);
        initComponents();
        this.session = session;
        this.mu = mu;
        awal();
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
        jPanel1 = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        panelTrKeluar = new javax.swing.JPanel();
        panelCabang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCabang = new javax.swing.JTable();
        panelPengecer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPengecer = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHeader.setBackground(new java.awt.Color(220, 239, 201));
        panelHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        panelHeader.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 30, 30));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Data Transaksi Keluar Hari Ini");
        panelHeader.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 30));

        jPanel1.add(panelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 30));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jRadioButton1.setText("Cabang");
        jRadioButton1.setContentAreaFilled(false);
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jRadioButton2.setText("Pengecer");
        jRadioButton2.setContentAreaFilled(false);
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        panelTrKeluar.setBackground(new java.awt.Color(255, 255, 255));
        panelTrKeluar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        panelTrKeluar.setLayout(new java.awt.CardLayout());

        panelCabang.setBackground(new java.awt.Color(255, 255, 255));
        panelCabang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCabang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbCabang);

        panelCabang.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 540));

        panelTrKeluar.add(panelCabang, "card2");

        panelPengecer.setBackground(new java.awt.Color(255, 255, 255));
        panelPengecer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPengecer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbPengecer);

        panelPengecer.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 540));

        panelTrKeluar.add(panelPengecer, "card3");

        jPanel1.add(panelTrKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 840, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void awal(){
        keluar = new keluar();
        
        modelTbCabang = new DefaultTableModel(mu.headerTransaksiKeluarCabang, 0){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
            return false;
            }
        };
        tbCabang.setModel(modelTbCabang);
        modelTbPengecer = new DefaultTableModel(mu.headerTbTransaksiKeluarPengecer, 0){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
            return false;
            }
        };
        tbPengecer.setModel(modelTbPengecer);
        buttonGroup1.clearSelection();
        mu.clearTbSementara(modelTbCabang);
        mu.clearTbSementara(modelTbPengecer);
    }
    
    private void showPanel(JPanel panel){
        panelTrKeluar.removeAll();
        panelTrKeluar.add(panel);
        panelTrKeluar.repaint();
        panelTrKeluar.revalidate();
    }
    
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
        showPanel(panelCabang);
        String kode_petugas = session[0];
        String[][] data = keluar.trKeluarPusatKeCabangHariIni(kode_petugas);
        mu.tampil(modelTbCabang, data);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling code here:
        showPanel(panelPengecer);
        String kode_petugas = session[0];
        String[][] data = keluar.trKeluarPusatKePengecerHariIni(kode_petugas);
        mu.tampil(modelTbPengecer, data);
    }//GEN-LAST:event_jRadioButton2MouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(modalTransaksiKeluarHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(modalTransaksiKeluarHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(modalTransaksiKeluarHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(modalTransaksiKeluarHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                modalTransaksiKeluarHariIni dialog = new modalTransaksiKeluarHariIni(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelCabang;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelPengecer;
    private javax.swing.JPanel panelTrKeluar;
    private javax.swing.JTable tbCabang;
    private javax.swing.JTable tbPengecer;
    // End of variables declaration//GEN-END:variables
}
