/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author imam
 */
public class kon {
    public static Connection con;
    public Connection getKoneksi(){
        try {
            String url ="jdbc:mysql://192.168.43.4/inventory";
            String user="coba";
            String pass="123";
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,user,pass);
            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            System.err.println("koneksi gagal " +e.getMessage());
        }
        return con;
    }
    
    public static void main(String[] args) {
        kon k = new kon();
        k.getKoneksi();
    }
}
