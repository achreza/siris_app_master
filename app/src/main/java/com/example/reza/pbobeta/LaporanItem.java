package com.example.reza.pbobeta;

public class LaporanItem {
    private final long idBarang;
    private final String namaLama;
    private final String namaBaru;
    private final String jumlahLama;
    private final int jumlahBaru;
    private final String hargaLama;
    private final String hargaBaru;

    public LaporanItem(long idBarang,String nama_lama,String nama_baru,String jumlah_lama,int jumlah_baru,String harga_lama,String harga_baru) {
        this.idBarang = idBarang;
        this.namaLama = nama_lama;
        this.namaBaru = nama_baru;
        this.jumlahLama = jumlah_lama;
        this.jumlahBaru = jumlah_baru;
        this.hargaLama = harga_lama;
        this.hargaBaru  = harga_baru;
    }


    public long getIdBarang(){
        return idBarang;
    }
    public String getNamaLama(){
        return namaLama;
    }
    public String getNamaBaru(){
        return namaBaru;
    }
    public String getJumlahLama(){
        return jumlahLama;
    }
    public int getJumlahBaru(){
        return jumlahBaru;
    }
    public String getHargaLama(){
        return hargaLama;
    }
    public String getHargaBaru(){
        return hargaBaru;
    }

//    @Override
//    public String toString() {
//        return "LaporanItem{" +
//                "idBarang='" + idBarang + '\'' +
//                ",namaLama='" + price + '\'' +
//                ",jumlahBaru="++
//                '}';
//    }
}
