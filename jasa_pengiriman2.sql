-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Jan 2023 pada 13.07
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jasa_pengiriman2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
(1, 'admin', '123'),
(2, 'username', 'password'),
(3, 'nunuy', 'nunuycantik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun_kurir`
--

CREATE TABLE `akun_kurir` (
  `id_kurir` int(11) DEFAULT NULL,
  `username` varchar(99) NOT NULL,
  `password` varchar(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun_pengirim`
--

CREATE TABLE `akun_pengirim` (
  `id_pengirim` int(11) NOT NULL,
  `username` varchar(99) NOT NULL,
  `password` varchar(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `akun_pengirim`
--

INSERT INTO `akun_pengirim` (`id_pengirim`, `username`, `password`) VALUES
(1, 'al', 'al');

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(10) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `jenis_barang` varchar(25) NOT NULL,
  `berat` int(5) NOT NULL,
  `sub_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `jenis_barang`, `berat`, `sub_total`) VALUES
(1, 'Vivo Y51', 'Elektronik', 1, 3000),
(2, 'Jam Tangan', 'Pakaian', 1, 3000),
(3, 'Kipas Angin', 'Elektronik', 2, 6000),
(10, 'Tv', 'Elektronik', 5, 15000),
(11, 'Blender', 'Elektronik', 1, 3000),
(12, 'Kipas Angin', 'Elektronik', 4, 12000),
(13, 'Buah Apel', 'Makanan dan Minuman', 7, 21000),
(14, 'Buah Mangga', 'Makanan dan Minuman', 9, 27000),
(17, 'Skincare', 'Kosmetik', 1, 3000),
(18, 'Obat Diare', 'Farmasi', 1, 3000),
(19, 'Ramen', 'Makanan dan Minuman', 1, 3000),
(22, 'q', 'Elektronik', 1, 3000),
(23, 'asam', 'Makanan dan Minuman', 1, 3000),
(25, 'laptop', 'Elektronik', 1, 3000),
(26, 'Ganja bubuk', 'Farmasi', 2, 6000),
(27, 'Shabu', 'Makanan', 3, 9000),
(28, 'Marijuana', 'Farmasi', 3, 9000),
(30, 'HP', 'Lainnya', 2, 6000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detailTransaksi` int(10) NOT NULL,
  `id_transaksi` int(10) NOT NULL,
  `id_barang` int(10) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `jenis_barang` varchar(25) NOT NULL,
  `berat` int(5) NOT NULL,
  `sub_total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_detailTransaksi`, `id_transaksi`, `id_barang`, `nama_barang`, `jenis_barang`, `berat`, `sub_total`) VALUES
(1, 5, 8, 'Deodorant', 'Deodorant', 5, 15000),
(2, 5, 9, 'Mouse', 'Mouse', 1, 3000),
(3, 6, 10, 'Tv', 'Tv', 5, 15000),
(4, 7, 11, 'Blender', 'Blender', 1, 3000),
(5, 7, 12, 'Kipas Angin', 'Kipas Angin', 4, 12000),
(6, 8, 13, 'Buah Apel', 'Buah Apel', 7, 21000),
(7, 8, 14, 'Buah Mangga', 'Buah Mangga', 9, 27000),
(8, 9, 17, 'Skincare', 'Kosmetik', 1, 3000),
(9, 9, 18, 'Obat Diare', 'Farmasi', 1, 3000),
(10, 10, 19, 'Ramen', 'Makanan dan Minuman', 1, 3000),
(11, 11, 22, 'q', 'Elektronik', 1, 3000),
(12, 12, 23, 'asam', 'Makanan dan Minuman', 1, 3000),
(13, 13, 25, 'laptop', 'Elektronik', 1, 3000),
(14, 14, 26, 'Ganja bubuk', 'Farmasi', 2, 6000),
(15, 14, 27, 'Shabu', 'Makanan', 3, 9000),
(16, 14, 28, 'Marijuana', 'Farmasi', 3, 9000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `keranjang`
--

CREATE TABLE `keranjang` (
  `id_keranjang` int(10) NOT NULL,
  `id_barang` int(10) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `jenis_barang` varchar(25) NOT NULL,
  `berat` int(5) NOT NULL,
  `sub_total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `keranjang`
--

INSERT INTO `keranjang` (`id_keranjang`, `id_barang`, `nama_barang`, `jenis_barang`, `berat`, `sub_total`) VALUES
(1, 30, 'HP', 'Lainnya', 2, 6000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int(10) NOT NULL,
  `nama_pelanggan` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `no_hp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `alamat`, `no_hp`) VALUES
(1, 'Paulus', 'Jl. Brawijaya. no.6 \nRt 06\nRw 01\nDesa Dampit, Kecamatan Ampelgading, Kabupaten Pemalang\n\n', '087738393981'),
(2, 'paul', 'pemalang', '98798798798'),
(3, 'Jono', 'Jakarta Utara', '092384738434'),
(4, 'Loki', 'Brebes', '0982878334'),
(5, 'Paijo', 'Semarang, Ungaran', '092834989384'),
(6, 'Dany', 'Sumatra Utara', '0298349834'),
(7, 'Alaka', 'Sumatra Utara', '0928398443'),
(8, 'Aldi', 'Semarang', '092839484'),
(9, 'adinata', 'pekalongan', '09898273443'),
(10, 'Srtiawan', 'Rembang', '098238743434'),
(11, 'Susanto', 'Semarang', '982738743834'),
(12, 'Ahsia', 'Bandung', '09823209384'),
(13, 'Anton', 'Kudus', '0928349834'),
(14, 'Anton', 'Jogja', '09283487343'),
(15, 'Ardi', 'Malang', '0293748734'),
(16, 'Nia', 'Salatiga', '9287348734'),
(17, 'ara', 'Japan', '0928394834'),
(18, 'qwe', 'asd', '123123123'),
(19, 'nama', 'namaa', '123456'),
(20, 'nama', 'alamatt', '123456');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(10) NOT NULL,
  `pengirim` varchar(30) NOT NULL,
  `penerima` varchar(30) NOT NULL,
  `alamat_tujuan` text NOT NULL,
  `jenis_pengiriman` varchar(15) NOT NULL,
  `total_harga` int(10) NOT NULL,
  `pembayaran` int(10) NOT NULL,
  `tanggal_transaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status_barang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `pengirim`, `penerima`, `alamat_tujuan`, `jenis_pengiriman`, `total_harga`, `pembayaran`, `tanggal_transaksi`, `status_barang`) VALUES
(1, 'Alaka', 'Sudani', 'Bandung', 'Reguler', 48000, 50000, '2021-03-23 17:16:51', 'Di proses'),
(2, 'Aldi', 'Toni', 'Jakarta', 'Reguler', 42000, 50000, '2021-03-24 00:52:16', 'Di proses'),
(3, 'adinata', 'Sri', 'Jakpus', 'Reguler', 57000, 60000, '2021-03-27 16:26:17', 'Di proses'),
(4, 'Srtiawan', 'Santo', 'Cilacap', 'Express', 58000, 60000, '2021-03-27 16:30:29', 'Di proses'),
(5, 'Susanto', 'Susanti', 'Bogor', 'Reguler', 45000, 50000, '2021-03-27 16:34:16', 'Di proses'),
(6, 'Ahsia', 'Damang', 'cirebon', 'Reguler', 42000, 45000, '2021-03-27 17:23:13', 'Di proses'),
(7, 'Anton', 'Muriyadi', 'Banten', 'Reguler', 57000, 60000, '2021-03-28 08:26:24', 'Di proses'),
(8, 'Anton', 'Koddar', 'Balikpapan', 'Reguler', 105000, 90000, '2021-03-28 10:21:15', 'Di proses'),
(9, 'Nia', 'Lika', 'Kalbar', 'Reguler', 21000, 21000, '2021-03-28 12:31:40', 'Di proses'),
(10, 'ara', 'kore', 'Nipon', 'Reguler', 18000, 18000, '2021-03-28 13:26:49', 'Di proses'),
(11, 'asd', 'asd', 'asd', 'Reguler', 18000, 20000, '2021-03-28 13:45:57', 'Di proses'),
(12, 'asd', 'qqwe', 'sdfdf', 'Reguler', 18000, 20000, '2021-03-28 13:49:47', 'Di proses'),
(13, 'nama', 'aman', 'talama', 'Reguler', 18000, 20000, '2021-03-29 16:22:55', 'Di proses'),
(14, 'Alfito', 'Nunuy', 'Jln Babakan Jati', 'Standard', 39000, 40000, '2023-01-08 08:02:31', 'Diterima');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `akun_pengirim`
--
ALTER TABLE `akun_pengirim`
  ADD PRIMARY KEY (`id_pengirim`);

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detailTransaksi`);

--
-- Indeks untuk tabel `keranjang`
--
ALTER TABLE `keranjang`
  ADD PRIMARY KEY (`id_keranjang`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `akun_pengirim`
--
ALTER TABLE `akun_pengirim`
  MODIFY `id_pengirim` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id_detailTransaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT untuk tabel `keranjang`
--
ALTER TABLE `keranjang`
  MODIFY `id_keranjang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
