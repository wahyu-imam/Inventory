/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import database.crud;
import database.query;
/**
 *
 * @author imam
 */
public class supplier extends crud{
    query db;
    
    public supplier(){
        db = new query();
    }
    
    public String[][] get_all(){
        String sql = db.select("*");
        sql += db.from("supplier");
        sql += db.order_by("nama_supplier", "ASC");
        String[][] data = getAll(sql, 4, "Error get_all supplier");
        return data;
    }
    
    public String[] get_id(String kode_supplier){
        String sql = db.select("*");
        sql += db.from("supplier");
        sql += db.where("kode_supplier", kode_supplier);
        String[] data = getById(sql, 4, "Error get_id supplier");
        return data;
    }
    
    public void save(String[][] data){
        String sql = db.insert("supplier", data);
        simpan(sql);
    }
    
    public void edit(String[][] data, String kode_supplier){
        String sql = db.update("supplier", data);
        sql += db.where("kode_supplier", kode_supplier);
        ubah(sql);
    }
    
    public void delete(String kode_supplier){
        String[] data = {"kode_supplier", kode_supplier};
        String sql = db.delete("supplier", data);
        hapus(sql);
    }
}
