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
public class keluar extends crud{
    query db;
    
    public keluar(){
        db = new query();
    }
    
    public String[][] getAllTrKeluarPengecer(){
        String sql = db.select("kode_transaksi, "+db.date_format("tgl_transaksi", "%d %M %Y %T")+
                "nama_petugas, "+db.format("total", 0));
        sql += db.from("tr_keluar");
        sql += db.join("petugas", "petugas.kode_petugas=tr_keluar.kode_petugas");
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 4, "Error getAllTransaksiKeluarPengecer");
        return data;
    }
    
    public String[][] getAllTrKeluarPengecerRelasiDetail(String kode_petugas){ // pusat pengecer
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_keluar.kode_transaksi, "+db.date_format("tgl_transaksi", "%d %M %Y %T")+", "+
                db.concat(field)+", qty, "+db.format("sub_total", 0)+", nama_petugas");
        sql += db.from("tr_keluar");
        sql += db.join("dtl_tr_keluar", "dtl_tr_keluar.kode_transaksi=tr_keluar.kode_transaksi");
        sql += db.join("petugas", "petugas.kode_petugas=tr_keluar.kode_petugas");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_keluar.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.where_not("total", "null");
        sql += db.where_and("petugas.kode_petugas", kode_petugas);
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 6, "Error getAllTrKeluarPengecerRelasiDetail keluar");
        return data;
    }
    
    public String[][] getAllTrKeluarCabang(){
        String sql = db.select("kode_transaksi, "+db.date_format("tgl_transaksi", "%d %M %Y %T")+
                "nama_gudang, nama_petugas");
        sql += db.from("tr_keluar");
        sql += db.join("petugas", "petugas.kode_petugas=tr_keluar.kode_petugas");
        sql += db.join("gudang", "gudang.kode_gudang=tr_keluar.kode_gudang");
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 4, "Error getAllTrKeluarCabang");
        return data;
    }
    
    public String[][] getAllTrKeluarCabangRelasiDetail(String kode_petugas){ // pusat cabang
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_keluar.kode_transaksi, "+db.date_format("tgl_transaksi", "%d %M %Y %T")+", "+
                db.concat(field)+", qty, nama_gudang, nama_petugas, konfirmasi_cabang");
        sql += db.from("tr_keluar");
        sql += db.join("dtl_tr_keluar", "dtl_tr_keluar.kode_transaksi=tr_keluar.kode_transaksi");
        sql += db.join("petugas", "petugas.kode_petugas=tr_keluar.kode_petugas");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_keluar.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("gudang", "gudang.kode_gudang=tr_keluar.kode_gudang");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 7, "Error getAllTrKeluarPengecerRelasiDetail keluar");
        return data;
    }
    
    public String[][] getAllTrKeluarCabangRelasiDetail2(String kode_petugas){
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_keluar.kode_transaksi, "+db.date_format("tgl_transaksi", "%d %M %Y %T")+", "+
                db.concat(field)+", qty, nama_gudang, nama_petugas, konfirmasi_cabang");
        sql += db.from("tr_keluar");
        sql += db.join("dtl_tr_keluar", "dtl_tr_keluar.kode_transaksi=tr_keluar.kode_transaksi");
        sql += db.join("petugas", "petugas.kode_petugas=tr_keluar.kode_petugas");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_keluar.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("gudang", "gudang.kode_gudang=tr_keluar.kode_gudang");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.where_and("konfirmasi_cabang", "Belum");
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 7, "Error getAllTrKeluarPengecerRelasiDetail keluar");
        return data;
    }
    
    public String[][] getAllToDoListCabang(String kode_gudang){
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_keluar.kode_transaksi, "+db.date_format("tgl_transaksi", "%d %M %Y %T")+", "+
                db.concat(field)+", qty, nama_gudang, nama_petugas, konfirmasi_cabang");
        sql += db.from("tr_keluar");
        sql += db.join("dtl_tr_keluar", "dtl_tr_keluar.kode_transaksi=tr_keluar.kode_transaksi");
        sql += db.join("petugas", "petugas.kode_petugas=tr_keluar.kode_petugas");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_keluar.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("gudang", "gudang.kode_gudang=tr_keluar.kode_gudang");
        sql += db.where("gudang.kode_gudang", kode_gudang);
        sql += db.where_and("konfirmasi_cabang", "Belum");
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 7, "Error getAllToDoListCabang keluar");
        return data;
    }
    
    public String[][] getAllToDoListCabang2(String kode_transaksi){
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("barang.kode_barang, "+db.concat(field)+", qty, tr_keluar.kode_transaksi");
        sql += db.from("tr_keluar");
        sql += db.join("dtl_tr_keluar", "dtl_tr_keluar.kode_transaksi=tr_keluar.kode_transaksi");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_keluar.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.where("tr_keluar.kode_transaksi", kode_transaksi);
        String[][] data = getAll(sql, 4, "Error getAllToDoListCabang2 keluar");
        return data;
    }
    
    public String[][] getAllTrKeluarPengecerDownload(String kode_petugas){ // pusat download excel pengecer
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_keluar.kode_transaksi, "+db.date_format("tgl_transaksi", "%d-%m-%Y %T")+", "+
                db.concat(field)+", qty, "+db.format("sub_total", 0)+", nama_petugas");
        sql += db.from("tr_keluar");
        sql += db.join("dtl_tr_keluar", "dtl_tr_keluar.kode_transaksi=tr_keluar.kode_transaksi");
        sql += db.join("petugas", "petugas.kode_petugas=tr_keluar.kode_petugas");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_keluar.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.where_not("total", "null");
        sql += db.where_and("petugas.kode_petugas", kode_petugas);
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 6, "Error getAllTrKeluarPengecerRelasiDetail keluar");
        return data;
    }
    
    public String[][] getAllTrKeluarCabangDownload(String kode_petugas){ // pusat download excel cabang
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select("tr_keluar.kode_transaksi, "+db.date_format("tgl_transaksi", "%d-%m-%Y %T")+", "+
                db.concat(field)+", qty, nama_gudang, nama_petugas, konfirmasi_cabang");
        sql += db.from("tr_keluar");
        sql += db.join("dtl_tr_keluar", "dtl_tr_keluar.kode_transaksi=tr_keluar.kode_transaksi");
        sql += db.join("petugas", "petugas.kode_petugas=tr_keluar.kode_petugas");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_keluar.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.join("gudang", "gudang.kode_gudang=tr_keluar.kode_gudang");
        sql += db.where("petugas.kode_petugas", kode_petugas);
        sql += db.order_by("tgl_transaksi", "DESC");
        String[][] data = getAll(sql, 7, "Error getAllTrKeluarPengecerRelasiDetail keluar");
        return data;
    }
    
    public String[][] bestSeller(){
        String[] field = {"nama_barang"," ' ('","nama_kategori","')'"};
        String sql = db.select(db.concat(field)+", "+db.sum("qty"));
        sql += db.from("tr_keluar");
        sql += db.join("dtl_tr_keluar", "dtl_tr_keluar.kode_transaksi=tr_keluar.kode_transaksi");
        sql += db.join("barang", "barang.kode_barang=dtl_tr_keluar.kode_barang");
        sql += db.join("kategori", "kategori.kode_kategori=barang.kode_kategori");
        sql += db.where_not("total", "null");
        sql += db.group_by("barang.kode_barang");
        sql += db.order_by("jum", "DESC");
        String[][] data = getAll(sql, 2, "error bestSeller");
        return data;
    }
    
    public String jmlTrKeluarHariIni(String kode_petugas){
        String sql = db.query("SELECT COUNT(`kode_transaksi`) AS jumlah\n" +
            "FROM `tr_keluar`\n" +
            "WHERE DATE_FORMAT(`tgl_transaksi`, '%Y-%m-%d') = CURDATE()\n" +
            "AND kode_petugas = '"+kode_petugas+"'");
        String data = getJml(sql, "error jmlTrKeluarHariIni");
        return data;
    }
    
    public String[][] trKeluarPusatKeCabangHariIni(String kode_petugas){ // pusat cabang hari ini
        String sql = db.query("SELECT `tr_keluar`.`kode_transaksi`, \n" +
            "DATE_FORMAT(`tgl_transaksi`, '%d %M %Y %T') AS `tgl_transaksi`,\n" +
            "CONCAT(`nama_barang`,' (',`nama_kategori`,')') AS `nama_barang`, \n" +
            "FORMAT(qty, 0) AS qty, nama_gudang, nama_petugas, `konfirmasi_cabang`\n" +
            "FROM `tr_keluar`\n" +
            "JOIN `dtl_tr_keluar` ON `dtl_tr_keluar`.`kode_transaksi`=`tr_keluar`.`kode_transaksi`\n" +
            "JOIN `barang` ON `barang`.`kode_barang`=`dtl_tr_keluar`.`kode_barang`\n" +
            "JOIN `kategori` ON `kategori`.`kode_kategori`=`barang`.`kode_kategori`\n" +
            "JOIN `petugas` ON `petugas`.`kode_petugas`=`tr_keluar`.`kode_petugas`\n" +
            "JOIN `gudang` ON `gudang`.`kode_gudang`=`petugas`.`kode_gudang`\n" +
            "WHERE `konfirmasi_cabang` != 'null'\n" +
            "AND `petugas`.`kode_petugas`='"+kode_petugas+"'\n" +
            "AND DATE_FORMAT(`tgl_transaksi`,'%Y-%m-%d') = CURDATE()\n" +
            "ORDER BY `tgl_transaksi` DESC");
        String[][] data = getAll(sql, 7, "Error trKeluarPusatKeCabangHariIni");
        return data;
    }
    
    public String[][] trKeluarPusatKePengecerHariIni(String kode_petugas){
        String sql = db.query("SELECT `tr_keluar`.`kode_transaksi`, \n" +
            "DATE_FORMAT(`tgl_transaksi`,'%d %M %Y %T') AS `tgl_transaksi`,\n" +
            "CONCAT(`nama_barang`,' (',`nama_kategori`,')') AS `nama_barang`, \n" +
            "FORMAT(qty, 0) AS `qty`, `sub_total`, `nama_petugas`\n" +
            "FROM `tr_keluar`\n" +
            "JOIN `dtl_tr_keluar` ON `dtl_tr_keluar`.`kode_transaksi`=`tr_keluar`.`kode_transaksi`\n" +
            "JOIN `barang` ON `barang`.`kode_barang`=`dtl_tr_keluar`.`kode_barang`\n" +
            "JOIN `kategori` ON `kategori`.`kode_kategori`=`barang`.`kode_kategori`\n" +
            "JOIN `petugas` ON `petugas`.`kode_petugas`=`tr_keluar`.`kode_petugas`\n" +
            "WHERE `sub_total` != 'null'\n" +
            "AND `petugas`.`kode_petugas`='"+kode_petugas+"'\n" +
            "AND DATE_FORMAT(`tgl_transaksi`,'%Y-%m-%d') = CURDATE()\n" +
            "ORDER BY `tgl_transaksi` DESC");
        String[][] data = getAll(sql, 6, "Error trKeluarPusatKePengecerHariIni");
        return data;
    }
    
    public void save(String[][] data){
        String sql = db.insert("tr_keluar", data);
        simpan(sql);
    }
    
    public void save_detail(String[][] data){
        String sql = db.insert("dtl_tr_keluar", data);
        simpanDtl(sql);
    }
    
    public void edit(String[][] data, String kode_transaksi){
        String sql = db.update("tr_keluar", data);
        sql += db.where("kode_transaksi", kode_transaksi);
        ubahDtl(sql);
    }
}
