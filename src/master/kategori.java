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
public class kategori extends crud{
    query db;
    
    public kategori(){
        db = new query();
    }
    
    public String[][] get_all(){
        String sql = db.select("*");
        sql += db.from("kategori");
        sql += db.order_by("nama_kategori", "ASC");
        String[][] data = getAll(sql, 2, "Error get_all kategori");
        return data;
    }
    
    public String[] get_id(String kode_kategori){
        String sql = db.select("*");
        sql += db.from("kategori");
        sql += db.where("kode_kategori", kode_kategori);
        String[] data = getById(sql, 2, "Error get_id kategori");
        return data;
    }
    
    public String[] get_nama(String nama_kategori){
        String sql = db.select("*");
        sql += db.from("kategori");
        sql += db.where("nama_kategori", nama_kategori);
        String[] data = getById(sql, 2, "Error get_nama kategori");
        return data;
    }
    
    public void save(String[][] data){
        String sql = db.insert("kategori", data);
        simpan(sql);
    }
    
    public void edit(String[][] data, String kode_kategori){
        String sql = db.update("kategori", data);
        sql += db.where("kode_kategori", kode_kategori);
        ubah(sql);
    }
    
    public void delete(String kode_kategori){
        String[] data = {"kode_kategori",kode_kategori};
        String sql = db.delete("kategori", data);
        hapus(sql);
    }
}
