package com.bengkel_seni.invoice.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String penyewa;
    private String namaUkm;
    private String prodi;
    private String noHp;
    private String barang;
    private Double totalHarga;
    private Double dp;
    private String status;
    private String metodePembayaran;
    private String tanggalWaktu;

    // Konstruktor otomatis isi tanggal
    public Invoice() {
        this.tanggalWaktu = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    // Fungsi hitung sisa untuk warna Merah/Hijau di HTML
    public Double getSisa() {
        return (totalHarga != null ? totalHarga : 0) - (dp != null ? dp : 0);
    }

    // GETTER & SETTER (Pastikan semua field di atas punya getter & setter)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPenyewa() { return penyewa; }
    public void setPenyewa(String penyewa) { this.penyewa = penyewa; }
    public String getNamaUkm() { return namaUkm; }
    public void setNamaUkm(String namaUkm) { this.namaUkm = namaUkm; }
    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }
    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
    public String getBarang() { return barang; }
    public void setBarang(String barang) { this.barang = barang; }
    public Double getTotalHarga() { return totalHarga; }
    public void setTotalHarga(Double totalHarga) { this.totalHarga = totalHarga; }
    public Double getDp() { return dp; }
    public void setDp(Double dp) { this.dp = dp; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMetodePembayaran() { return metodePembayaran; }
    public void setMetodePembayaran(String metodePembayaran) { this.metodePembayaran = metodePembayaran; }
    public String getTanggalWaktu() { return tanggalWaktu; }
}