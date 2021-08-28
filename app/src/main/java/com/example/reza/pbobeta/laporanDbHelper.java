package com.example.reza.pbobeta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;
import android.text.format.DateFormat;

import java.util.Date;

public class laporanDbHelper extends SQLiteOpenHelper {
    public final static String DB_NAME = "inventory.db";
    public final static int DB_VERSION = 1;
    public final static String LOG_TAG = laporanDbHelper.class.getCanonicalName();

    public laporanDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StockContract.StockEntry.CREATE_TABLE_STOCK);
        db.execSQL(TabelLaporan.EntryLaporan.CREATE_TABLE_LAPORAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertItem(StockItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StockContract.StockEntry.COLUMN_NAME, item.getProductName());
        values.put(StockContract.StockEntry.COLUMN_PRICE, item.getPrice());
        values.put(StockContract.StockEntry.COLUMN_QUANTITY, item.getQuantity());
        values.put(StockContract.StockEntry.COLUMN_IMAGE, item.getImage());
        long id = db.insert(StockContract.StockEntry.TABLE_NAME, null, values);
    }

    public Cursor readStock() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                StockContract.StockEntry._ID,
                StockContract.StockEntry.COLUMN_NAME,
                StockContract.StockEntry.COLUMN_PRICE,
                StockContract.StockEntry.COLUMN_QUANTITY,
                StockContract.StockEntry.COLUMN_IMAGE
        };
        Cursor cursor = db.query(
                StockContract.StockEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
    public Cursor readLaporan() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TabelLaporan.EntryLaporan._ID,
                TabelLaporan.EntryLaporan.COLUMN_NEWNAME,
                TabelLaporan.EntryLaporan.COLUMN_OLDNAME,
                TabelLaporan.EntryLaporan.COLUMN_DATE,
                TabelLaporan.EntryLaporan.COLUMN_STOKBARU,
                TabelLaporan.EntryLaporan.COLUMN_STOKLAMA,
                TabelLaporan.EntryLaporan.COLUMN_IDBARANG
        };
        Cursor cursor = db.query(
                TabelLaporan.EntryLaporan.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
    public Cursor readItem(long itemId) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                StockContract.StockEntry._ID,
                StockContract.StockEntry.COLUMN_NAME,
                StockContract.StockEntry.COLUMN_PRICE,
                StockContract.StockEntry.COLUMN_QUANTITY,
                StockContract.StockEntry.COLUMN_IMAGE
        };
        String selection = StockContract.StockEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };

        Cursor cursor = db.query(
                StockContract.StockEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }

    public Cursor readLaporan1(long itemId) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TabelLaporan.EntryLaporan._ID,
                TabelLaporan.EntryLaporan.COLUMN_NEWNAME,
                TabelLaporan.EntryLaporan.COLUMN_OLDNAME,
                TabelLaporan.EntryLaporan.COLUMN_DATE,
                TabelLaporan.EntryLaporan.COLUMN_STOKBARU,
                TabelLaporan.EntryLaporan.COLUMN_STOKLAMA,
                TabelLaporan.EntryLaporan.COLUMN_IDBARANG
        };
        String selection = TabelLaporan.EntryLaporan._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };

        Cursor cursor = db.query(
                StockContract.StockEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }
    public Cursor readLaporanByTanggal(String date1,String date2) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TabelLaporan.EntryLaporan._ID,
                TabelLaporan.EntryLaporan.COLUMN_NEWNAME,
                TabelLaporan.EntryLaporan.COLUMN_OLDNAME,
                TabelLaporan.EntryLaporan.COLUMN_DATE,
                TabelLaporan.EntryLaporan.COLUMN_STOKBARU,
                TabelLaporan.EntryLaporan.COLUMN_STOKLAMA,
                TabelLaporan.EntryLaporan.COLUMN_IDBARANG
        };
        String selection = TabelLaporan.EntryLaporan.COLUMN_DATE + ">" + TabelLaporan.EntryLaporan.COLUMN_DATE + " < ?";
        String[] selectionArgs = new String[] { String.valueOf(date1),String.valueOf(date2) };

        Cursor cursor = db.query(
                StockContract.StockEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
//        String query = "SELECT * FROM "+ TabelLaporan.EntryLaporan.TABLE_NAME+" WHERE "+TabelLaporan.EntryLaporan.COLUMN_DATE
//                +" BETWEEN '"+date1+"' AND '"+date2+"'";
//        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public void updateItem(long currentItemId, int quantity,String name,String harga) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StockContract.StockEntry.COLUMN_QUANTITY, quantity);
        values.put(StockContract.StockEntry.COLUMN_NAME,name);
        values.put(StockContract.StockEntry.COLUMN_PRICE, harga);
        String selection = StockContract.StockEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(currentItemId) };
        db.update(StockContract.StockEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }

    public void sellOneItem(long itemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        int newQuantity = 0;
        if (quantity > 0) {
            newQuantity = quantity -1;
        }
        ContentValues values = new ContentValues();
        values.put(StockContract.StockEntry.COLUMN_QUANTITY, newQuantity);
        String selection = StockContract.StockEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };
        db.update(StockContract.StockEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }

    public void insertLaporan(LaporanItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Date d = new Date();
        CharSequence s  = DateFormat.format("Y-m-d", d.getTime());
        values.put(TabelLaporan.EntryLaporan.COLUMN_IDBARANG, item.getIdBarang());
        values.put(TabelLaporan.EntryLaporan.COLUMN_OLDNAME, item.getNamaLama());
        values.put(TabelLaporan.EntryLaporan.COLUMN_NEWNAME, item.getNamaBaru());
        values.put(TabelLaporan.EntryLaporan.COLUMN_DATE, (String) s);
        values.put(TabelLaporan.EntryLaporan.COLUMN_STOKLAMA, item.getJumlahLama());
        values.put(TabelLaporan.EntryLaporan.COLUMN_STOKBARU, item.getJumlahBaru());
        long id = db.insert(TabelLaporan.EntryLaporan.TABLE_NAME, null, values);
    }
}
