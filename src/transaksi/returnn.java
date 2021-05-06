/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaksi;

import database.crud;
import database.query;
/**
 *
 * @author imam
 */
public class returnn extends crud{
    query db;
    
    public returnn(){
        db = new query();
    }
    
    public String[][] getAllDetail(String kode_petugas){ // return cabang
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("`return`.kode_return, "+db.date_format("tgl_return", "%d %M %Y %T")+
                ", "+db.concat(field)+", qty, nama_petugas, konfirmasi_pusat");
        sql += db.from("`return`");
        sql += db.join("dtl_return", "dtl_return.kode_return=`return`.kode_return");
        sql += db.join("barang", "barang.kode_barang=dtl_return.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("petugas", "petugas.kode_petugas=return.kode_petugas");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.order_by("tgl_return", "DESC");
        String[][] data = getAll(sql, 6, "error getAllDetail return");
        return data;
    }
    
    public String[][] getAllToDoList(String kode_petugas){
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("`return`.kode_return, "+db.date_format("tgl_return", "%d %M %Y %T")+
                ", "+db.concat(field)+", qty, nama_petugas, konfirmasi_pusat");
        sql += db.from("`return`");
        sql += db.join("dtl_return", "dtl_return.kode_return=`return`.kode_return");
        sql += db.join("barang", "barang.kode_barang=dtl_return.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("petugas", "petugas.kode_petugas=return.kode_petugas");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.where_and("konfirmasi_pusat", "Belum");
        sql += db.order_by("tgl_return", "DESC");
        String[][] data = getAll(sql, 6, "error getAllDetail return");
        return data;
    }
    
    public String[][] getAllToDoListPusatReturnBelum(){
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String[] field2 = {"nama_petugas","' ('","nama_gudang","')'"};
        String sql = db.select("`return`.kode_return, "+db.date_format("tgl_return", "%d %M %Y %T")+
                ", "+db.concat(field)+", qty, "+db.concat(field2)+", konfirmasi_pusat");
        sql += db.from("`return`");
        sql += db.join("dtl_return", "dtl_return.kode_return=`return`.kode_return");
        sql += db.join("barang", "barang.kode_barang=dtl_return.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("petugas", "petugas.kode_petugas=return.kode_petugas");
        sql += db.join("gudang", "gudang.kode_gudang=petugas.kode_gudang");
        sql += db.where("konfirmasi_pusat", "Belum");
        sql += db.order_by("tgl_return", "DESC");
        String[][] data = getAll(sql, 6, "error getAllDetail return");
        return data;
    }
    
    public String[][] getAllToDoListPusatReturnSudah(){ // return pusat
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String[] field2 = {"nama_petugas","' ('","nama_gudang","')'"};
        String sql = db.select("`return`.kode_return, "+db.date_format("tgl_return", "%d %M %Y %T")+
                ", "+db.concat(field)+", qty, "+db.concat(field2)+", konfirmasi_pusat");
        sql += db.from("`return`");
        sql += db.join("dtl_return", "dtl_return.kode_return=`return`.kode_return");
        sql += db.join("barang", "barang.kode_barang=dtl_return.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("petugas", "petugas.kode_petugas=return.kode_petugas");
        sql += db.join("gudang", "gudang.kode_gudang=petugas.kode_gudang");
        sql += db.where("konfirmasi_pusat", "Sudah");
        sql += db.order_by("tgl_return", "DESC");
        String[][] data = getAll(sql, 6, "error getAllDetail return");
        return data;
    }
    
    public String[][] getAllToDoListPusatReturn(String kode_return){
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("barang.kode_barang, "+db.concat(field)+", qty, `return`.kode_return");
        sql += db.from("`return`");
        sql += db.join("dtl_return", "dtl_return.kode_return=`return`.kode_return");
        sql += db.join("barang", "barang.kode_barang=dtl_return.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.where("`return`.kode_return", kode_return);
        String[][] data = getAll(sql, 4, "Error getAllToDoListPusatReturn return");
        return data;
    }
    
    public String[][] getAllDownloadCabang(String kode_petugas){ // return download cabang
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("`return`.kode_return, "+db.date_format("tgl_return", "%d-%m-%Y %T")+
                ", "+db.concat(field)+", qty, nama_petugas, konfirmasi_pusat");
        sql += db.from("`return`");
        sql += db.join("dtl_return", "dtl_return.kode_return=`return`.kode_return");
        sql += db.join("barang", "barang.kode_barang=dtl_return.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("petugas", "petugas.kode_petugas=return.kode_petugas");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.order_by("tgl_return", "DESC");
        String[][] data = getAll(sql, 6, "error getAllDetail return");
        return data;
    }
    
    public String[][] getAllToDoListPusatReturnSudahDownload(){ // return donwload pusat
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String[] field2 = {"nama_petugas","' ('","nama_gudang","')'"};
        String sql = db.select("`return`.kode_return, "+db.date_format("tgl_return", "%d-%m-%Y %T")+
                ", "+db.concat(field)+", qty, "+db.concat(field2)+", konfirmasi_pusat");
        sql += db.from("`return`");
        sql += db.join("dtl_return", "dtl_return.kode_return=`return`.kode_return");
        sql += db.join("barang", "barang.kode_barang=dtl_return.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("petugas", "petugas.kode_petugas=return.kode_petugas");
        sql += db.join("gudang", "gudang.kode_gudang=petugas.kode_gudang");
        sql += db.where("konfirmasi_pusat", "Sudah");
        sql += db.order_by("tgl_return", "DESC");
        String[][] data = getAll(sql, 6, "error getAllDetail return");
        return data;
    }
    
    public String[][] getAllPusatReturnHariIni(){
        String sql = db.query("SELECT `return`.`kode_return`, \n" +
            "DATE_FORMAT(`tgl_return`,'%d %M %Y %T') AS `tgl_return`,\n" +
            "CONCAT(`nama_barang`,' (',`nama_kategori`,')') AS `nama_barang`,\n" +
            "FORMAT(`qty`, 0) AS `qty`, `nama_petugas`, `konfirmasi_pusat`\n" +
            "FROM `return`\n" +
            "JOIN `dtl_return` ON `dtl_return`.`kode_return`=`return`.`kode_return`\n" +
            "JOIN `barang` ON `barang`.`kode_barang`=`dtl_return`.`kode_barang`\n" +
            "JOIN `kategori` ON `kategori`.`kode_kategori`=`barang`.`kode_kategori`\n" +
            "JOIN `petugas` ON `petugas`.`kode_petugas`=`return`.`kode_petugas`\n" +
            "WHERE DATE_FORMAT(`tgl_return`, '%Y-%m-%d') = CURDATE()\n" +
            "AND `konfirmasi_pusat` = 'Sudah'");
        String[][] data = getAll(sql, 6, "error getAllPusatReturnHariIni");
        return data;
    }
    
    public void save(String[][] data){
        String sql = db.insert("`return`", data);
        simpan(sql);
    }
    
    public void save_detail(String[][] data){
        String sql = db.insert("dtl_return", data);
        simpanDtl(sql);
    }
    
    public void edit(String[][] data, String kode_return){
        String sql = db.update("`return`", data);
        sql += db.where("kode_return", kode_return);
        simpanDtl(sql);
    }
}
