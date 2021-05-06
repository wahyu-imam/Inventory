/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import database.query;
import database.crud;
/**
 *
 * @author imam
 */
public class barang extends crud{
    query db;
    
    public barang(){
        db = new query();
    }
    
    public String[][] get_all(){
        String sql = db.select("*");
        sql+= db.from("barang");
        sql += db.order_by("nama_barang", "ASC");
        String[][] data = getAll(sql, 5, "Error get_all barang");
        return data;
    }
    
    public String[][] getAllRelasiKategori(){
        String sql = db.select("kode_barang, nama_barang, nama_kategori, satuan, "+db.format("harga", 0));
        sql += db.from("barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.order_by("nama_barang", "ASC");
        String[][] data = getAll(sql, 5, "Error getAllRelasiKategori barang");
        return data;
    }
    
    public String[][] getAllRelasiStok(String kode_gudang){
        String sql = db.select("barang.kode_barang, nama_barang, nama_kategori, satuan, "+db.format("harga", 0));
        sql += db.from("barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("stok", "stok.kode_barang=barang.kode_barang");
        sql += db.where("kode_gudang", kode_gudang);
        sql += db.order_by("nama_barang", "ASC");
        String[][] data = getAll(sql, 5, "Error getAllRelasiStok barang");
        return data;
    }
    
    public String[] get_id(String kode_barang){
        String sql = db.select("*");
        sql += db.from("barang");
        sql += db.where("kode_barang", kode_barang);
        String[] data = getById(sql, 5, "Error get_id barang");
        return data;
    }
    
    public void save(String[][] data){
        String sql = db.insert("barang", data);
        simpan(sql);
    }
    
    public void edit(String[][] data, String kode_barang){
        String sql = db.update("barang", data);
        sql += db.where("kode_barang", kode_barang);
        ubah(sql);
    }
    
    public void delete(String kode_barang){
        String[] data = {"kode_barang", kode_barang};
        String sql = db.delete("barang", data);
        hapus(sql);
    }
}
