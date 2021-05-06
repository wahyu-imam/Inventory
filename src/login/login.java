/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import database.koneksi;
import database.query;
import database.crud;
import view.MenuUtama;
import view.v_login;
/**
 *
 * @author imam
 */
public class login extends crud{
    Connection con;
    Statement stm;
    ResultSet rs;
    koneksi koneksi;
    query db;
    
    public login(){
        koneksi = new koneksi();
        db = new query();
    }
    
    public String[] aksi_login(String username, String pass){
        String sql = db.select("*");
        sql += db.from("petugas");
        sql += db.where("username", username);
        sql += db.where_and("pass", pass);
        sql += db.where_and("status", "aktif");
        String[] data = getById(sql, 6, "Error aksi_login login");
        return data;
    }
    
    public void aksi_logout(MenuUtama mu){
        mu.setVisible(false);
        v_login login = new v_login();
        login.setVisible(true);
    }
}
