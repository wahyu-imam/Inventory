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
public class petugas extends crud{
    query db;
    
    public petugas(){
        db = new query();
    }
    
    public String[][] get_all(){
        String sql = db.select("*");
        sql += db.from("petugas");
        sql += db.order_by("nama_petugas", "ASC");
        String[][] data = getAll(sql, 6, "Error get_all petugas");
        return data;
    }
    
    public String[][] getAllRelasiGudang(){
        String sql = db.select("kode_petugas, nama_petugas, username, pass, status, nama_gudang");
        sql += db.from("petugas");
        sql += db.join("gudang", "gudang.kode_gudang=petugas.kode_gudang");
        sql += db.order_by("nama_petugas", "ASC");
        String[][] data = getAll(sql, 6, "Error getAllRelasiGudang");
        return data;
    }
    
    public String[][] getAllKecualiLogin(String[] value){
        String sql = db.select("kode_petugas, nama_petugas, username, pass, status, nama_gudang");
        sql += db.from("petugas");
        sql += db.join("gudang", "gudang.kode_gudang=petugas.kode_gudang");
        sql += db.where_not_in("kode_petugas", value);
        sql += db.order_by("nama_petugas", "ASC");
        String[][] data = getAll(sql, 6, "Error getAllKecualiLogin petugas");
        return data;
    }
    
    public String[] get_id(String kode_petugas){
        String sql = db.select("*");
        sql += db.from("petugas");
        sql += db.where("kode_petugas", kode_petugas);
        String[] data = getById(sql, 6, "Error get_id petugas");
        return data;
    }
    
    public void save(String[][] data){
        String sql = db.insert("petugas", data);
        simpan(sql);
    }
    
    public void edit(String[][] data, String kode_petugas){
        String sql = db.update("petugas", data);
        sql += db.where("kode_petugas", kode_petugas);
        ubah(sql);
    }
    
    public void delete(String kode_petugas){
        String[] data = {"kode_petugas", kode_petugas};
        String sql = db.delete("petugas", data);
        hapus(sql);
    }
}
