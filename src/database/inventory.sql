/*
SQLyog Ultimate v12.5.1 (32 bit)
MySQL - 10.1.16-MariaDB : Database - inventory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`inventory` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `inventory`;

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `kode_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(50) DEFAULT NULL,
  `kode_kategori` varchar(20) DEFAULT NULL,
  `satuan` varchar(10) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`kode_barang`),
  KEY `kode_kategori` (`kode_kategori`),
  CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`kode_kategori`) REFERENCES `kategori` (`kode_kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `barang` */

insert  into `barang`(`kode_barang`,`nama_barang`,`kode_kategori`,`satuan`,`harga`) values 
('20935308032299341291','C4 A','51424559809150355317','KG',50000),
('54398048266521485142','C4 C','28489413312654730664','KG',30000),
('59969663839471875702','C4 B','50720249544560854830','KG',40000);

/*Table structure for table `dtl_tr_keluar` */

DROP TABLE IF EXISTS `dtl_tr_keluar`;

CREATE TABLE `dtl_tr_keluar` (
  `kode_detail` varchar(20) NOT NULL,
  `kode_transaksi` varchar(20) DEFAULT NULL,
  `kode_barang` varchar(20) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `sub_total` int(11) DEFAULT NULL,
  PRIMARY KEY (`kode_detail`),
  KEY `kode_transaksi` (`kode_transaksi`),
  KEY `kode_barang` (`kode_barang`),
  CONSTRAINT `dtl_tr_keluar_ibfk_1` FOREIGN KEY (`kode_transaksi`) REFERENCES `tr_keluar` (`kode_transaksi`),
  CONSTRAINT `dtl_tr_keluar_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dtl_tr_keluar` */

/*Table structure for table `dtl_tr_masuk` */

DROP TABLE IF EXISTS `dtl_tr_masuk`;

CREATE TABLE `dtl_tr_masuk` (
  `kode_detail` varchar(20) NOT NULL,
  `kode_transaksi` varchar(20) DEFAULT NULL,
  `kode_barang` varchar(20) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `sub_total` int(11) DEFAULT NULL,
  PRIMARY KEY (`kode_detail`),
  KEY `kode_transaksi` (`kode_transaksi`),
  KEY `kode_barang` (`kode_barang`),
  CONSTRAINT `dtl_tr_masuk_ibfk_1` FOREIGN KEY (`kode_transaksi`) REFERENCES `tr_masuk` (`kode_transaksi`),
  CONSTRAINT `dtl_tr_masuk_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dtl_tr_masuk` */

insert  into `dtl_tr_masuk`(`kode_detail`,`kode_transaksi`,`kode_barang`,`qty`,`sub_total`) values 
('05903595125233159843','59435256845186430310','54398048266521485142',5,45000),
('05948396939579707792','17189504768921240681','20935308032299341291',10,10000),
('21148272672142821774','30901585711854517698','59969663839471875702',4,30000),
('22656687608773792514','30901585711854517698','20935308032299341291',30,50000),
('56678429704165068381','30901585711854517698','54398048266521485142',20,15000),
('65872275431842968368','56251652736490832580','20935308032299341291',1,11000),
('84298651505847984399','67653781164096124273','20935308032299341291',5,6000),
('88875559021880504329','76157702296738538830','54398048266521485142',5,45000),
('89465553865655610359','76157702296738538830','59969663839471875702',3,17000);

/*Table structure for table `gudang` */

DROP TABLE IF EXISTS `gudang`;

CREATE TABLE `gudang` (
  `kode_gudang` varchar(20) NOT NULL,
  `nama_gudang` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `status_gudang` enum('Pusat','Cabang') DEFAULT NULL,
  PRIMARY KEY (`kode_gudang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `gudang` */

insert  into `gudang`(`kode_gudang`,`nama_gudang`,`alamat`,`status_gudang`) values 
('36234178017395334392','Gudang Pusat','Jl. Jendral Suderman No.6','Pusat'),
('69790932283384114363','Gudang Cabang 2','Jl. Mataram No. 5','Cabang'),
('74529641852025298164','Gudang Cabang 1','Jl. Pangeran Diponegoro No.10','Cabang');

/*Table structure for table `kategori` */

DROP TABLE IF EXISTS `kategori`;

CREATE TABLE `kategori` (
  `kode_kategori` varchar(20) NOT NULL,
  `nama_kategori` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`kode_kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kategori` */

insert  into `kategori`(`kode_kategori`,`nama_kategori`) values 
('28489413312654730664','Beras Biasa'),
('50720249544560854830','Beras Baik'),
('51424559809150355317','Beras Super');

/*Table structure for table `petugas` */

DROP TABLE IF EXISTS `petugas`;

CREATE TABLE `petugas` (
  `kode_petugas` varchar(20) NOT NULL,
  `nama_petugas` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `status` enum('Aktif','Tidak Aktif') DEFAULT NULL,
  `kode_gudang` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`kode_petugas`),
  KEY `kode_cabang` (`kode_gudang`),
  CONSTRAINT `petugas_ibfk_1` FOREIGN KEY (`kode_gudang`) REFERENCES `gudang` (`kode_gudang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `petugas` */

insert  into `petugas`(`kode_petugas`,`nama_petugas`,`username`,`pass`,`status`,`kode_gudang`) values 
('28620277852814518796','wahyu Imam','wahyu','32c9e71e866ecdbc93e497482aa6779f','Aktif','74529641852025298164'),
('29453971405961733060','Imam','admin','21232f297a57a5a743894a0e4a801fc3','Aktif','36234178017395334392');

/*Table structure for table `stok` */

DROP TABLE IF EXISTS `stok`;

CREATE TABLE `stok` (
  `kode_stok` varchar(20) NOT NULL,
  `kode_barang` varchar(20) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `kode_gudang` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`kode_stok`),
  KEY `kode_barang` (`kode_barang`),
  KEY `kode_cabang` (`kode_gudang`),
  CONSTRAINT `stok_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`),
  CONSTRAINT `stok_ibfk_2` FOREIGN KEY (`kode_gudang`) REFERENCES `gudang` (`kode_gudang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stok` */

insert  into `stok`(`kode_stok`,`kode_barang`,`stok`,`kode_gudang`) values 
('01185829144099387690','54398048266521485142',30,'36234178017395334392'),
('65648553786301999086','59969663839471875702',7,'36234178017395334392'),
('76974193785065021239','20935308032299341291',46,'36234178017395334392');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `kode_supplier` varchar(20) NOT NULL,
  `nama_supplier` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_tlp` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`kode_supplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `supplier` */

insert  into `supplier`(`kode_supplier`,`nama_supplier`,`alamat`,`no_tlp`) values 
('08842408396861923135','Yadi','Tayu','08738394'),
('12519134345968295116','Takim','Bangsri','088980006642'),
('93754520764104973656','Suwono','Bulungan','08945334');

/*Table structure for table `tr_keluar` */

DROP TABLE IF EXISTS `tr_keluar`;

CREATE TABLE `tr_keluar` (
  `kode_transaksi` varchar(20) NOT NULL,
  `tgl_transaksi` datetime DEFAULT NULL,
  `kode_gudang` varchar(20) DEFAULT NULL,
  `kode_petugas` varchar(20) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`kode_transaksi`),
  KEY `kode_cabang` (`kode_gudang`),
  KEY `kode_petugas` (`kode_petugas`),
  CONSTRAINT `tr_keluar_ibfk_2` FOREIGN KEY (`kode_gudang`) REFERENCES `gudang` (`kode_gudang`),
  CONSTRAINT `tr_keluar_ibfk_3` FOREIGN KEY (`kode_petugas`) REFERENCES `petugas` (`kode_petugas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tr_keluar` */

/*Table structure for table `tr_masuk` */

DROP TABLE IF EXISTS `tr_masuk`;

CREATE TABLE `tr_masuk` (
  `kode_transaksi` varchar(20) NOT NULL,
  `tgl_transaksi` datetime DEFAULT NULL,
  `kode_supplier` varchar(20) DEFAULT NULL,
  `kode_petugas` varchar(20) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`kode_transaksi`),
  KEY `kode_supplier` (`kode_supplier`),
  KEY `kode_petugas` (`kode_petugas`),
  CONSTRAINT `tr_masuk_ibfk_1` FOREIGN KEY (`kode_supplier`) REFERENCES `supplier` (`kode_supplier`),
  CONSTRAINT `tr_masuk_ibfk_2` FOREIGN KEY (`kode_petugas`) REFERENCES `petugas` (`kode_petugas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tr_masuk` */

insert  into `tr_masuk`(`kode_transaksi`,`tgl_transaksi`,`kode_supplier`,`kode_petugas`,`total`) values 
('17189504768921240681','2021-03-27 02:55:02','93754520764104973656','29453971405961733060',10000),
('30901585711854517698','2021-03-27 02:58:44','08842408396861923135','29453971405961733060',95000),
('56251652736490832580','2021-03-27 03:36:11','12519134345968295116','29453971405961733060',11000),
('59435256845186430310','2021-03-27 03:34:45','93754520764104973656','29453971405961733060',45000),
('67653781164096124273','2021-03-27 02:57:00','12519134345968295116','29453971405961733060',6000),
('76157702296738538830','2021-03-27 03:01:19','93754520764104973656','29453971405961733060',62000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
