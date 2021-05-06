/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author imam
 */
public class koneksi {
    public static Connection con;
    
    private String ip(){
        String path = Paths.get("").toAbsolutePath().toString();
        String fileName = path+"/src/database/ip.txt" ; 
        String data = null;
        try {
            // membaca file
            File myFile = new File(fileName);
            Scanner fileReader = new Scanner(myFile);
            
            // cetak isi file
            while(fileReader.hasNextLine()){
                data = fileReader.nextLine();
            }
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : "+e.getMessage());
            e.printStackTrace();
        }
        return data;
    }
    
    public Connection getKoneksi(){
        String ip = ip();
        try {
            String url ="jdbc:mysql://"+ip+"/inventory";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,user,pass);
//            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            System.err.println("koneksi gagal " +e.getMessage());
        }
        return con;
    }
    
    public void invoice(String kode_transaksi){
        try {
            String path = Paths.get("").toAbsolutePath().toString();
            path += "/src/report/invoice.jasper";
            HashMap parameter = new HashMap();
            File file = new File(path);
            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
            parameter.put("kode_transaksi", kode_transaksi);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, getKoneksi());
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void main(String[] args) {
        koneksi kon = new koneksi();
        kon.getKoneksi();
//        kon.invoice("B2804806M4L9014");
        String path = Paths.get("").toAbsolutePath().toString();
        System.out.println(path);
    }
}
