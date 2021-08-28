package com.example.reza.pbobeta;

class ListBarang {
    private String id_barang;
    private String nama_barang;
    private String stok;


    public ListBarang(String id_barang, String nama_barang, String stok) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.stok = stok;

    }


    public String getId_barang() {
        return id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public String getStok() {
        return stok;
    }



}
