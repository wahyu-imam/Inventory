/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import transaksi.masuk;
import master.gudang;
import transaksi.returnn;
/**
 *
 * @author imam
 */
public class modalTransaksiMasukHariIni extends javax.swing.JDialog {
    MenuUtama mu;
    masuk masuk;
    gudang gudang;
    returnn returnn;
    
    String[] session;
    
    DefaultTableModel modelSupplier;
    DefaultTableModel modelReturn;
    /**
     * Creates new form modalTransaksiMasukHariIni
     */
    public modalTransaksiMasukHariIni(java.awt.Frame parent, boolean modal, String[] session, MenuUtama mu) {
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
        rbSupplier = new javax.swing.JRadioButton();
        rbReturn = new javax.swing.JRadioButton();
        panelTrMasuk = new javax.swing.JPanel();
        panelSupplier = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSupplier = new javax.swing.JTable();
        panelReturn = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbReturn = new javax.swing.JTable();

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
        jLabel2.setText("Data Transaksi Masuk Hari Ini");
        panelHeader.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 30));

        jPanel1.add(panelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 30));

        rbSupplier.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbSupplier);
        rbSupplier.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        rbSupplier.setText("Supplier");
        rbSupplier.setContentAreaFilled(false);
        rbSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbSupplierMouseClicked(evt);
            }
        });
        jPanel1.add(rbSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        rbReturn.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbReturn);
        rbReturn.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        rbReturn.setText("Return");
        rbReturn.setContentAreaFilled(false);
        rbReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbReturnMouseClicked(evt);
            }
        });
        jPanel1.add(rbReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        panelTrMasuk.setBackground(new java.awt.Color(255, 255, 255));
        panelTrMasuk.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        panelTrMasuk.setLayout(new java.awt.CardLayout());

        panelSupplier.setBackground(new java.awt.Color(255, 255, 255));
        panelSupplier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbSupplier);

        panelSupplier.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 540));

        panelTrMasuk.add(panelSupplier, "card2");

        panelReturn.setBackground(new java.awt.Color(255, 255, 255));
        panelReturn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbReturn.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbReturn);

        panelReturn.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 540));

        panelTrMasuk.add(panelReturn, "card3");

        jPanel1.add(panelTrMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 840, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void awal(){
        masuk = new masuk();
        gudang = new gudang();
        returnn = new returnn();
        
        String kode_petugas = session[0];
        String kode_gudang = session[5];
        String[] dataGudang = gudang.get_id(kode_gudang);
        String statusGudang = dataGudang[3];
        
        if (statusGudang.equals("Pusat")) {
            modelSupplier = new DefaultTableModel(mu.headerTbTransaksiMasuk, 0){
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
                }
            };
        }else{
            modelSupplier = new DefaultTableModel(mu.headerTbTransaksiMasukCabang, 0){
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
                }
            };
        }
        tbSupplier.setModel(modelSupplier);
        modelReturn = new DefaultTableModel(mu.headerTbReturn, 0){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
            return false;
            }
        };
        tbReturn.setModel(modelReturn);
        
        buttonGroup1.clearSelection();
        mu.clearTbSementara(modelReturn);
        mu.clearTbSementara(modelSupplier);
        if (!statusGudang.equals("Pusat")) {
            rbReturn.setVisible(false);
            rbSupplier.setVisible(false);
            showPanel(panelSupplier);
            String[][] data = masuk.getAllTrMasukCabangHariIni(kode_petugas);
            mu.tampil(modelSupplier, data);
        }
    }
    
    private void showPanel(JPanel panel){
        panelTrMasuk.removeAll();
        panelTrMasuk.add(panel);
        panelTrMasuk.repaint();
        panelTrMasuk.revalidate();
    }
    
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void rbSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbSupplierMouseClicked
        // TODO add your handling code here:
        showPanel(panelSupplier);
        String kode_petugas = session[0];
        String[][] data = masuk.getAllTrMasukSupplierhariIni(kode_petugas);
        mu.tampil(modelSupplier, data);
    }//GEN-LAST:event_rbSupplierMouseClicked

    private void rbReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbReturnMouseClicked
        // TODO add your handling code here:
        showPanel(panelReturn);
        String[][] data = returnn.getAllPusatReturnHariIni();
        mu.tampil(modelReturn, data);
    }//GEN-LAST:event_rbReturnMouseClicked

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
//            java.util.logging.Logger.getLogger(modalTransaksiMasukHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(modalTransaksiMasukHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(modalTransaksiMasukHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(modalTransaksiMasukHariIni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                modalTransaksiMasukHariIni dialog = new modalTransaksiMasukHariIni(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelReturn;
    private javax.swing.JPanel panelSupplier;
    private javax.swing.JPanel panelTrMasuk;
    private javax.swing.JRadioButton rbReturn;
    private javax.swing.JRadioButton rbSupplier;
    private javax.swing.JTable tbReturn;
    private javax.swing.JTable tbSupplier;
    // End of variables declaration//GEN-END:variables
}
