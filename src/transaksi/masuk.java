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
public class masuk extends crud{
    query db;
    
    public masuk(){
        db = new query();
    }
    
    public String[][] get_all(){
        String sql = db.select("kode_transaksi, "+db.date_format("tgl_transaksi", "%d %M %Y %T")+
                ", nama_supplier, nama_petugas, "+db.format("total", 0));
        sql += db.from("tr_masuk");
        sql += db.join("supplier","supplier.kode_supplier=tr_masuk.kode_supplier");
        sql += db.join("petugas","petugas.kode_petugas=tr_masuk.kode_petugas");
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 5, "Error get_all transaksi masuk");
        return data;
    }
    
    public String[][] getAllRelasiDetail(String kode_petugas){ // pusat
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_masuk.kode_transaksi AS kode_transaksi, "+db.date_format("tgl_transaksi", "%d %M %Y %T")+
                ", nama_supplier, "+
                db.concat(field)+", qty, "+db.format("sub_total", 0)+", nama_petugas");
        sql += db.from("dtl_tr_masuk");
        sql += db.join("tr_masuk", "tr_masuk.kode_transaksi=dtl_tr_masuk.kode_transaksi");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_masuk.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("supplier", "supplier.kode_supplier=tr_masuk.kode_supplier");
        sql += db.join("petugas", "petugas.kode_petugas=tr_masuk.kode_petugas");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 7, "Error getAllRelasiDetail");
        return data;
    }
    
    public String[][] getAllRelasiDetail2(String kode_petugas){ // cabang
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_masuk.kode_transaksi AS kode_transaksi, "+db.date_format("tgl_transaksi", "%d %M %Y %T")+
                ", "+db.concat(field)+", qty, nama_petugas");
        sql += db.from("dtl_tr_masuk");
        sql += db.join("tr_masuk", "tr_masuk.kode_transaksi=dtl_tr_masuk.kode_transaksi");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_masuk.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("petugas", "petugas.kode_petugas=tr_masuk.kode_petugas");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.where_and("total", "0");
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 5, "Error getAllRelasiDetail");
        return data;
    }
    
    public String[][] getAllDownloadPusat(String kode_petugas){ // download excel pusat
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_masuk.kode_transaksi AS kode_transaksi, "+db.date_format("tgl_transaksi", "%d-%m-%Y %T")+
                ", nama_supplier, "+
                db.concat(field)+", qty, "+db.format("sub_total", 0)+", nama_petugas");
        sql += db.from("dtl_tr_masuk");
        sql += db.join("tr_masuk", "tr_masuk.kode_transaksi=dtl_tr_masuk.kode_transaksi");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_masuk.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("supplier", "supplier.kode_supplier=tr_masuk.kode_supplier");
        sql += db.join("petugas", "petugas.kode_petugas=tr_masuk.kode_petugas");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 7, "Error getAllRelasiDetail");
        return data;
    }
    
    public String[][] getAllDownloadCabang(String kode_petugas){ // download excel cabang
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_masuk.kode_transaksi AS kode_transaksi, "+db.date_format("tgl_transaksi", "%d-%m-%Y %T")+
                ", "+db.concat(field)+", qty, nama_petugas");
        sql += db.from("dtl_tr_masuk");
        sql += db.join("tr_masuk", "tr_masuk.kode_transaksi=dtl_tr_masuk.kode_transaksi");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_masuk.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("petugas", "petugas.kode_petugas=tr_masuk.kode_petugas");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.where_and("total", "0");
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 5, "Error getAllRelasiDetail");
        return data;
    }
    
    public String jmlTransaksiMasukHariIni(String kode_petugas){
        String sql = db.query("SELECT COUNT(`kode_transaksi`) AS jumlah\n" +
            "FROM `tr_masuk`\n" +
            "WHERE DATE_FORMAT(`tgl_transaksi`,'%Y-%m-%d') = CURDATE()\n" +
            "AND `kode_petugas` = '"+kode_petugas+"'");
        String data = getJml(sql, "error jmlTransaksiMasukHariIni");
        return data;
    }
    
    public String[][] getAllTrMasukSupplierhariIni(String kode_petugas){
        String sql = db.query("SELECT `tr_masuk`.`kode_transaksi`, \n" +
            "DATE_FORMAT(`tgl_transaksi`, '%d %M %Y %T') AS `tgl_transaksi`,\n" +
            "`nama_supplier`, CONCAT(`nama_barang`,' (',`nama_kategori`,')') AS `nama_barang`,\n" +
            "FORMAT(`qty`, 0) AS `qty`, FORMAT(`sub_total`, 0) AS `sub_total`, `nama_petugas`\n" +
            "FROM `tr_masuk`\n" +
            "JOIN `dtl_tr_masuk` ON `dtl_tr_masuk`.`kode_transaksi`=`tr_masuk`.`kode_transaksi`\n" +
            "JOIN `barang` ON `barang`.`kode_barang`=`dtl_tr_masuk`.`kode_barang`\n" +
            "JOIN `kategori` ON `kategori`.`kode_kategori`=`barang`.`kode_kategori`\n" +
            "JOIN `petugas` ON `petugas`.`kode_petugas`=`tr_masuk`.`kode_petugas`\n" +
            "JOIN `supplier` ON `supplier`.`kode_supplier`=`tr_masuk`.`kode_supplier`\n" +
            "WHERE DATE_FORMAT(`tgl_transaksi`,'%Y-%m-%d') = CURDATE()\n" +
            "AND `petugas`.`kode_petugas`='"+kode_petugas+"'");
        String[][] data = getAll(sql, 7, "error getAllTrMasukSupplierhariIni");
        return data;
    }
    
    public String[][] getAllTrMasukCabangHariIni(String kode_petugas){
        String sql = db.query("SELECT `tr_masuk`.`kode_transaksi`, \n" +
            "DATE_FORMAT(`tgl_transaksi`,'%d %M %Y %T') AS `tgl_transaksi`,\n" +
            "CONCAT(`nama_barang`,' (',`nama_kategori`,')') AS `nama_barang`,\n" +
            "FORMAT(`qty`, 0) AS `qty`, `nama_petugas`\n" +
            "FROM `tr_masuk`\n" +
            "JOIN `dtl_tr_masuk` ON `dtl_tr_masuk`.`kode_transaksi`=`tr_masuk`.`kode_transaksi`\n" +
            "JOIN `barang` ON `barang`.`kode_barang`=`dtl_tr_masuk`.`kode_barang`\n" +
            "JOIN `kategori` ON `kategori`.`kode_kategori`=`barang`.`kode_kategori`\n" +
            "JOIN `petugas` ON `petugas`.`kode_petugas`=`tr_masuk`.`kode_petugas`\n" +
            "WHERE DATE_FORMAT(`tgl_transaksi`,'%Y-%m-%d') = CURDATE()\n" +
            "AND `petugas`.`kode_petugas`='"+kode_petugas+"'");
        String[][] data = getAll(sql, 5, "error getAllTrMasukCabangHariIni");
        return data;
    }
    
    public String[] get_id(String kode_transaksi){
        String sql = db.select("*");
        sql += db.from("tr_masuk");
        sql += db.where("kode_transaksi", kode_transaksi);
        String[] data = getById(sql, 5, "Error get_id transaksi masuk");
        return data;
    }
    
    public void save(String[][] data){
        String sql = db.insert("tr_masuk", data);
        simpan(sql);
    }
    
    public void edit(String[][] data, String kode_transaksi){
        String sql = db.update("tr_masuk", data);
        sql += db.where("kode_transaksi", kode_transaksi);
        ubah(sql);
    }
    
    public void delete(String kode_tranakssi){
        String[] data = {"kode_tranaksi", kode_tranakssi};
        String sql = db.delete("tr_masuk", data);
        hapus(sql);
    }
    
    public void save_detail(String[][] data){
        String sql = db.insert("dtl_tr_masuk", data);
        simpanDtl(sql);
    }
    
    public void delete_detail(String kode_transaksi){
        String[] data = {"kode_transaksi", kode_transaksi};
        String sql = db.delete("dtl_tr_masuk", data);
        hapus(sql);
    }
}
