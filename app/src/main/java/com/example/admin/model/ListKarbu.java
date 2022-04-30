package com.example.admin.model;

public class ListKarbu {
    //Variabel dalam json
    private Integer idKarbu;
    private String nama;
    private Integer harga;

    //getter dan setter
    public Integer getIdKarbu() {
        return idKarbu;
    }

    public void setIdbuku(Integer idbuku) {
        this.idKarbu = idbuku;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }
}