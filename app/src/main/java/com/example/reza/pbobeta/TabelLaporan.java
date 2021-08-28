package com.example.reza.pbobeta;

import android.provider.BaseColumns;
public class TabelLaporan {
    public static final class EntryLaporan implements BaseColumns {
        public static final String TABLE_NAME = "laporan";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_IDBARANG = "ID_BARANG";
        public static final String COLUMN_OLDNAME = "NAMA_BARANG_LAMA";
        public static final String COLUMN_NEWNAME = "NAMA_BARANG_BARU";
        public static final String COLUMN_DATE = "TANGGAL";
        public static final String COLUMN_STOKLAMA = "STOK_LAMA";
        public static final String COLUMN_STOKBARU = "STOK_BARU";
        public static final String COLUMN_HARGALAMA = "HARGA_LAMA";
        public static final String COLUMN_HARGABARU = "HARGA_BARU";

        public static final String CREATE_TABLE_LAPORAN = "CREATE TABLE " +
                TabelLaporan.EntryLaporan.TABLE_NAME + "(" +
                TabelLaporan.EntryLaporan._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TabelLaporan.EntryLaporan.COLUMN_IDBARANG + " TEXT," +
                TabelLaporan.EntryLaporan.COLUMN_OLDNAME + " TEXT," +
                TabelLaporan.EntryLaporan.COLUMN_NEWNAME + " TEXT," +
                TabelLaporan.EntryLaporan.COLUMN_DATE + " DATE," +
                TabelLaporan.EntryLaporan.COLUMN_STOKLAMA + " INTEGER," +
                TabelLaporan.EntryLaporan.COLUMN_STOKBARU + " INTEGER," +
                TabelLaporan.EntryLaporan.COLUMN_HARGALAMA + " TEXT," +
                TabelLaporan.EntryLaporan.COLUMN_HARGABARU + " TEXT" + ");";
    }
}
