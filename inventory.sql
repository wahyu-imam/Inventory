-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 19 Apr 2021 pada 14.56
-- Versi Server: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(50) DEFAULT NULL,
  `kode_kategori` varchar(20) DEFAULT NULL,
  `satuan` varchar(10) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama_barang`, `kode_kategori`, `satuan`, `harga`) VALUES
('B849201MMM40KKK', 'C4 A', 'I8649210LK662KL', 'KG', 15000),
('FKL8699890LMKL0', 'C4 C', 'G01KK866L04460M', 'KG', 10000),
('H6M28L626M96969', 'C4 B', 'IK49LL8006M0KMK', 'KG', 13000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `dtl_return`
--

CREATE TABLE `dtl_return` (
  `kode_detail` varchar(20) NOT NULL,
  `kode_return` varchar(20) DEFAULT NULL,
  `kode_barang` varchar(20) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dtl_return`
--

INSERT INTO `dtl_return` (`kode_detail`, `kode_return`, `kode_barang`, `qty`) VALUES
('BKMK812L10M4699', 'C4699K4L220LM19', 'H6M28L626M96969', 10),
('J9281024842LKK4', 'C4699K4L220LM19', 'B849201MMM40KKK', 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `dtl_tr_keluar`
--

CREATE TABLE `dtl_tr_keluar` (
  `kode_detail` varchar(20) NOT NULL,
  `kode_transaksi` varchar(20) DEFAULT NULL,
  `kode_barang` varchar(20) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `sub_total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dtl_tr_keluar`
--

INSERT INTO `dtl_tr_keluar` (`kode_detail`, `kode_transaksi`, `kode_barang`, `qty`, `sub_total`) VALUES
('AMK008L6M814LL2', 'J0KLL21261M04M8', 'FKL8699890LMKL0', 4, 40000),
('DL68K42M9422962', 'HM6K9L8990L499L', 'B849201MMM40KKK', 20, NULL),
('E2M9M4149920249', 'B2492L46100M0K4', 'B849201MMM40KKK', 5, 75000),
('E8L18426806018K', 'H2KL1KL22LM21KL', 'B849201MMM40KKK', 3, 45000),
('F1064216K9MKMM0', 'B2804806M4L9014', 'B849201MMM40KKK', 1, 15000),
('G098K8984L6142K', 'H61KKM9LM08K689', 'H6M28L626M96969', 2, 26000),
('G88949M9996K0K6', 'BL0M6911006L6KL', 'H6M28L626M96969', 1, 13000),
('GL94LKK8200408M', 'DM4M10L94L8M66L', 'H6M28L626M96969', 2, 26000),
('H89L9L064K41M90', 'JL0MM12089LLM14', 'FKL8699890LMKL0', 3, 30000),
('I111824M8942M6K', 'H8499M1088L92L8', 'B849201MMM40KKK', 4, 60000),
('I60816M8K08K610', 'H2KL1KL22LM21KL', 'FKL8699890LMKL0', 3, 30000),
('IM99L0KM981840M', 'AK86L8K9080KKM4', 'B849201MMM40KKK', 1, 15000),
('JK0964066K022M6', 'HM6K9L8990L499L', 'H6M28L626M96969', 20, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `dtl_tr_masuk`
--

CREATE TABLE `dtl_tr_masuk` (
  `kode_detail` varchar(20) NOT NULL,
  `kode_transaksi` varchar(20) DEFAULT NULL,
  `kode_barang` varchar(20) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `sub_total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dtl_tr_masuk`
--

INSERT INTO `dtl_tr_masuk` (`kode_detail`, `kode_transaksi`, `kode_barang`, `qty`, `sub_total`) VALUES
('B89M8L9LK0448LL', 'I1M0K02L9MK861K', 'H6M28L626M96969', 20, NULL),
('E8KL04920L60429', 'JK1912662994481', 'H6M28L626M96969', 100, 1000000),
('FM62M00862MML09', 'JK1912662994481', 'B849201MMM40KKK', 100, 1300000),
('GK9K28221M61680', 'FMK29K01119M616', 'B849201MMM40KKK', 50, 700000),
('H6106216L2M2K9M', 'JK1912662994481', 'FKL8699890LMKL0', 100, 700000),
('H89K2924M1K8429', 'I1M0K02L9MK861K', 'B849201MMM40KKK', 20, NULL),
('IL662ML8069L281', 'I1K8K0200L10K8L', 'B849201MMM40KKK', 10, NULL),
('IM424482692K06M', 'I1K8K0200L10K8L', 'H6M28L626M96969', 10, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `gudang`
--

CREATE TABLE `gudang` (
  `kode_gudang` varchar(20) NOT NULL,
  `nama_gudang` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `status_gudang` enum('Pusat','Cabang') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gudang`
--

INSERT INTO `gudang` (`kode_gudang`, `nama_gudang`, `alamat`, `status_gudang`) VALUES
('A94424LKL2L8120', 'Gudang Cabang 1', 'Jl. Magelang', 'Cabang'),
('E9MK88L48L0LK19', 'Gudang Pusat', 'Jl. Pamotan rembang', 'Pusat');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `kode_kategori` varchar(20) NOT NULL,
  `nama_kategori` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`kode_kategori`, `nama_kategori`) VALUES
('G01KK866L04460M', 'Beras Biasa'),
('I8649210LK662KL', 'Beras Super'),
('IK49LL8006M0KMK', 'Beras Baik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `kode_petugas` varchar(20) NOT NULL,
  `nama_petugas` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `status` enum('Aktif','Tidak Aktif') DEFAULT NULL,
  `kode_gudang` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`kode_petugas`, `nama_petugas`, `username`, `pass`, `status`, `kode_gudang`) VALUES
('A1K00M408488K4L', 'udin', 'udin', '6bec9c852847242e384a4d5ac0962ba0', 'Aktif', 'A94424LKL2L8120'),
('B826LL9690M489L', 'imam', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Aktif', 'E9MK88L48L0LK19');

-- --------------------------------------------------------

--
-- Struktur dari tabel `return`
--

CREATE TABLE `return` (
  `kode_return` varchar(20) NOT NULL,
  `tgl_return` datetime DEFAULT NULL,
  `kode_petugas` varchar(20) DEFAULT NULL,
  `konfirmasi_pusat` enum('Belum','Sudah') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `return`
--

INSERT INTO `return` (`kode_return`, `tgl_return`, `kode_petugas`, `konfirmasi_pusat`) VALUES
('C4699K4L220LM19', '2021-04-17 04:35:56', 'A1K00M408488K4L', 'Sudah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `stok`
--

CREATE TABLE `stok` (
  `kode_stok` varchar(20) NOT NULL,
  `kode_barang` varchar(20) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `kode_gudang` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `stok`
--

INSERT INTO `stok` (`kode_stok`, `kode_barang`, `stok`, `kode_gudang`) VALUES
('B66220L661LMM11', 'B849201MMM40KKK', 4, 'A94424LKL2L8120'),
('BK14K2M1669K098', 'FKL8699890LMKL0', 90, 'E9MK88L48L0LK19'),
('BK4M1084L1M1169', 'H6M28L626M96969', 5, 'A94424LKL2L8120'),
('BMK2289L8K6K818', 'B849201MMM40KKK', 132, 'E9MK88L48L0LK19'),
('J092L00101460M6', 'H6M28L626M96969', 90, 'E9MK88L48L0LK19');

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `kode_supplier` varchar(20) NOT NULL,
  `nama_supplier` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_tlp` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`kode_supplier`, `nama_supplier`, `alamat`, `no_tlp`) VALUES
('DK16L81L9M12M11', 'Titin', 'Jl. Monjali', '089765473643');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tr_keluar`
--

CREATE TABLE `tr_keluar` (
  `kode_transaksi` varchar(20) NOT NULL,
  `tgl_transaksi` datetime DEFAULT NULL,
  `kode_gudang` varchar(20) DEFAULT NULL,
  `kode_petugas` varchar(20) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `bayar` int(11) DEFAULT NULL,
  `konfirmasi_cabang` enum('Belum','Sudah') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tr_keluar`
--

INSERT INTO `tr_keluar` (`kode_transaksi`, `tgl_transaksi`, `kode_gudang`, `kode_petugas`, `total`, `bayar`, `konfirmasi_cabang`) VALUES
('AK86L8K9080KKM4', '2021-04-19 07:53:43', NULL, 'B826LL9690M489L', 15000, 15000, NULL),
('B2492L46100M0K4', '2021-04-17 05:05:16', NULL, 'A1K00M408488K4L', 75000, 100000, NULL),
('B2804806M4L9014', '2021-04-19 07:25:55', NULL, 'A1K00M408488K4L', 15000, 15000, NULL),
('BL0M6911006L6KL', '2021-04-19 07:24:34', NULL, 'A1K00M408488K4L', 13000, 15000, NULL),
('DM4M10L94L8M66L', '2021-04-19 07:22:10', NULL, 'A1K00M408488K4L', 26000, 30000, NULL),
('H2KL1KL22LM21KL', '2021-04-19 07:49:37', NULL, 'B826LL9690M489L', 75000, 100000, NULL),
('H61KKM9LM08K689', '2021-04-19 07:27:56', NULL, 'A1K00M408488K4L', 26000, 30000, NULL),
('H8499M1088L92L8', '2021-04-17 06:28:21', NULL, 'B826LL9690M489L', 60000, 100000, NULL),
('HM6K9L8990L499L', '2021-04-17 03:55:30', 'A94424LKL2L8120', 'B826LL9690M489L', NULL, NULL, 'Sudah'),
('J0KLL21261M04M8', '2021-04-19 07:51:17', NULL, 'B826LL9690M489L', 40000, 50000, NULL),
('JL0MM12089LLM14', '2021-04-17 03:57:03', NULL, 'B826LL9690M489L', 30000, 30000, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tr_masuk`
--

CREATE TABLE `tr_masuk` (
  `kode_transaksi` varchar(20) NOT NULL,
  `tgl_transaksi` datetime DEFAULT NULL,
  `kode_supplier` varchar(20) DEFAULT NULL,
  `kode_petugas` varchar(20) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tr_masuk`
--

INSERT INTO `tr_masuk` (`kode_transaksi`, `tgl_transaksi`, `kode_supplier`, `kode_petugas`, `total`) VALUES
('FMK29K01119M616', '2021-04-17 01:14:03', 'DK16L81L9M12M11', 'B826LL9690M489L', 700000),
('I1K8K0200L10K8L', '2021-04-17 04:59:22', NULL, 'B826LL9690M489L', 0),
('I1M0K02L9MK861K', '2021-04-17 04:01:22', NULL, 'A1K00M408488K4L', 0),
('JK1912662994481', '2021-04-17 01:10:08', 'DK16L81L9M12M11', 'B826LL9690M489L', 3000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`),
  ADD KEY `kode_kategori` (`kode_kategori`);

--
-- Indexes for table `dtl_return`
--
ALTER TABLE `dtl_return`
  ADD PRIMARY KEY (`kode_detail`),
  ADD KEY `kode_return` (`kode_return`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indexes for table `dtl_tr_keluar`
--
ALTER TABLE `dtl_tr_keluar`
  ADD PRIMARY KEY (`kode_detail`),
  ADD KEY `kode_transaksi` (`kode_transaksi`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indexes for table `dtl_tr_masuk`
--
ALTER TABLE `dtl_tr_masuk`
  ADD PRIMARY KEY (`kode_detail`),
  ADD KEY `kode_transaksi` (`kode_transaksi`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indexes for table `gudang`
--
ALTER TABLE `gudang`
  ADD PRIMARY KEY (`kode_gudang`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`kode_kategori`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`kode_petugas`),
  ADD KEY `kode_cabang` (`kode_gudang`);

--
-- Indexes for table `return`
--
ALTER TABLE `return`
  ADD PRIMARY KEY (`kode_return`),
  ADD KEY `kode_petugas` (`kode_petugas`);

--
-- Indexes for table `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`kode_stok`),
  ADD KEY `kode_barang` (`kode_barang`),
  ADD KEY `kode_cabang` (`kode_gudang`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kode_supplier`);

--
-- Indexes for table `tr_keluar`
--
ALTER TABLE `tr_keluar`
  ADD PRIMARY KEY (`kode_transaksi`),
  ADD KEY `kode_cabang` (`kode_gudang`),
  ADD KEY `kode_petugas` (`kode_petugas`);

--
-- Indexes for table `tr_masuk`
--
ALTER TABLE `tr_masuk`
  ADD PRIMARY KEY (`kode_transaksi`),
  ADD KEY `kode_supplier` (`kode_supplier`),
  ADD KEY `kode_petugas` (`kode_petugas`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`kode_kategori`) REFERENCES `kategori` (`kode_kategori`);

--
-- Ketidakleluasaan untuk tabel `dtl_return`
--
ALTER TABLE `dtl_return`
  ADD CONSTRAINT `dtl_return_ibfk_1` FOREIGN KEY (`kode_return`) REFERENCES `return` (`kode_return`),
  ADD CONSTRAINT `dtl_return_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`);

--
-- Ketidakleluasaan untuk tabel `dtl_tr_keluar`
--
ALTER TABLE `dtl_tr_keluar`
  ADD CONSTRAINT `dtl_tr_keluar_ibfk_1` FOREIGN KEY (`kode_transaksi`) REFERENCES `tr_keluar` (`kode_transaksi`),
  ADD CONSTRAINT `dtl_tr_keluar_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`);

--
-- Ketidakleluasaan untuk tabel `dtl_tr_masuk`
--
ALTER TABLE `dtl_tr_masuk`
  ADD CONSTRAINT `dtl_tr_masuk_ibfk_1` FOREIGN KEY (`kode_transaksi`) REFERENCES `tr_masuk` (`kode_transaksi`),
  ADD CONSTRAINT `dtl_tr_masuk_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`);

--
-- Ketidakleluasaan untuk tabel `petugas`
--
ALTER TABLE `petugas`
  ADD CONSTRAINT `petugas_ibfk_1` FOREIGN KEY (`kode_gudang`) REFERENCES `gudang` (`kode_gudang`);

--
-- Ketidakleluasaan untuk tabel `return`
--
ALTER TABLE `return`
  ADD CONSTRAINT `return_ibfk_1` FOREIGN KEY (`kode_petugas`) REFERENCES `petugas` (`kode_petugas`);

--
-- Ketidakleluasaan untuk tabel `stok`
--
ALTER TABLE `stok`
  ADD CONSTRAINT `stok_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`),
  ADD CONSTRAINT `stok_ibfk_2` FOREIGN KEY (`kode_gudang`) REFERENCES `gudang` (`kode_gudang`);

--
-- Ketidakleluasaan untuk tabel `tr_keluar`
--
ALTER TABLE `tr_keluar`
  ADD CONSTRAINT `tr_keluar_ibfk_2` FOREIGN KEY (`kode_gudang`) REFERENCES `gudang` (`kode_gudang`),
  ADD CONSTRAINT `tr_keluar_ibfk_3` FOREIGN KEY (`kode_petugas`) REFERENCES `petugas` (`kode_petugas`);

--
-- Ketidakleluasaan untuk tabel `tr_masuk`
--
ALTER TABLE `tr_masuk`
  ADD CONSTRAINT `tr_masuk_ibfk_1` FOREIGN KEY (`kode_supplier`) REFERENCES `supplier` (`kode_supplier`),
  ADD CONSTRAINT `tr_masuk_ibfk_2` FOREIGN KEY (`kode_petugas`) REFERENCES `petugas` (`kode_petugas`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
