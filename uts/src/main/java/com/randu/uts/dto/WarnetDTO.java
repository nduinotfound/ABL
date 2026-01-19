package com.randu.uts.dto;

public class WarnetDTO {
    private Long id;
    private String nama;
    private java.sql.Date tanggal;
    private Double durasiMasuk;
    private Double durasiKeluar;
    private String kategori;
    private Double tarifPerJam;
    private Double lama;
    private Double diskon;
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public java.sql.Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(java.sql.Date tanggal) {
        this.tanggal = tanggal;
    }

    public Double getDurasiMasuk() {
        return durasiMasuk;
    }

    public void setDurasiMasuk(Double durasiMasuk) {
        this.durasiMasuk = durasiMasuk;
    }

    public Double getDurasiKeluar() {
        return durasiKeluar;
    }

    public void setDurasiKeluar(Double durasiKeluar) {
        this.durasiKeluar = durasiKeluar;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Double getTarifPerJam() {
        return tarifPerJam;
    }

    public void setTarifPerJam(Double tarifPerJam) {
        this.tarifPerJam = tarifPerJam;
    }

    public Double getLama() {
        return lama;
    }

    public void setLama(Double lama) {
        this.lama = lama;
    }

    public Double getDiskon() {
        return diskon;
    }

    public void setDiskon(Double diskon) {
        this.diskon = diskon;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
