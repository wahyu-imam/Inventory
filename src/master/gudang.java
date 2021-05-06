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
public class gudang extends crud{
    query db;
    
    public gudang(){
        db = new query();
    }
    
    public String[][] get_all(){
        String sql = db.select("*");
        sql += db.from("gudang");
        sql += db.order_by("nama_gudang", "ASC");
        String[][] data = getAll(sql, 4, "Error get_all gudang");
        return data;
    }
    
    public String[] get_id(String kode_gudang){
        String sql = db.select("*");
        sql += db.from("gudang");
        sql += db.where("kode_gudang", kode_gudang);
        String[] data = getById(sql, 4, "Error get_id gudang");
        return data;
    }
    
    public String[][] getAllKecualiLogin(String kode_gudang){
        String[] value = {kode_gudang};
        String sql = db.select("*");
        sql += db.from("gudang");
        sql += db.where_not_in("kode_gudang", value);
        sql += db.order_by("nama_gudang", "ASC");
        String[][] data = getAll(sql, 4, "Error getAllKecualiLogin gudang");
        return data;
    }
    
    public String[] get_nama(String nama_gudang){
        String sql = db.select("*");
        sql += db.from("gudang");
        sql += db.where("nama_gudang", nama_gudang);
        String[] data = getById(sql, 4, "Error get_nama gudang");
        return data;
    }
    
    public void save(String[][] data){
        String sql = db.insert("gudang", data);
        simpan(sql);
    }
    
    public void edit(String[][] data, String kode_gudang){
        String sql = db.update("gudang", data);
        sql += db.where("kode_gudang", kode_gudang);
        ubah(sql);
    }
    
    public void delete(String kode_gudang){
        String[] data = {"kode_gudang", kode_gudang};
        String sql = db.delete("gudang", data);
        hapus(sql);
    }
}
