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
public class stok extends crud{
    query db;
    
    public stok(){
        db = new query();
    }
    
    public String[][] get_all(){
        String[] field = {"nama_barang","' ('","nama_kategori","')'"};
        String sql = db.select("kode_stok, "+db.concat(field)+", stok, nama_gudang");
        sql += db.from("stok");
        sql += db.join("barang", "barang.kode_barang=stok.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("gudang", "gudang.kode_gudang=stok.kode_gudang");
        sql += db.order_by("nama_gudang", "ASC");
        String[][] data = getAll(sql, 4, "Error get_all stok");
        return data;
    }
    
    public String[] get_id(String kode_stok){
        String sql = db.select("*");
        sql += db.from("stok");
        sql += db.where("kode_stok", kode_stok);
        String[] data = getById(sql, 4, "Error get_id stok");
        return data;
    }
    
    public String[][] getByGudang(String kode_gudang){
        String[] field = {"nama_barang","' ('","nama_kategori","')'"};
        String sql = db.select("kode_stok, "+db.concat(field)+", stok");
        sql += db.from("stok");
        sql += db.join("barang", "barang.kode_barang=stok.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("gudang", "gudang.kode_gudang=stok.kode_gudang");
        sql += db.where("gudang.kode_gudang", kode_gudang);
        sql += db.order_by("nama_gudang", "ASC");
        String[][] data = getAll(sql, 3, "Error getByGudang stok");
        return data;
    }
    
    public String[] getStok(String kode_barang, String kode_gudang){
        String sql = db.select("*");
        sql += db.from("stok");
        sql += db.where("kode_barang", kode_barang);
        sql += db.where_and("kode_gudang", kode_gudang);
        String[] data = getById(sql, 4, "Error getStok stok");
        return data;
    }
    
    public void save(String[][] data){
        String sql = db.insert("stok", data);
        simpanDtl(sql);
    }
    
    public void edit(String[][] data, String kode_stok){
        String sql = db.update("stok", data);
        sql += db.where("kode_stok", kode_stok);
        ubahDtl(sql);
    }
    
    public void delete(String kode_stok){
        String[] data = {"kode_stok", kode_stok};
        String sql = db.delete("stok", data);
        hapus(sql);
    }
}
