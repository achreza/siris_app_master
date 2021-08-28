package com.example.reza.pbobeta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.support.design.widget.TabLayout;
import android.text.format.DateFormat;

import java.util.Date;

public class InventoryDbHelper extends SQLiteOpenHelper {
    public final static String DB_NAME = "inventory.db";
    public final static int DB_VERSION = 1;
    public final static String LOG_TAG = InventoryDbHelper.class.getCanonicalName();

    public InventoryDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StockContract.StockEntry.CREATE_TABLE_STOCK);
        db.execSQL(TabelLaporan.EntryLaporan.CREATE_TABLE_LAPORAN);
        db.execSQL(TableUser.EntryUser.CREATE_TABLE_USER);
        db.execSQL("INSERT INTO user VALUES (null,'admin','admin')");
//        insertUser();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//    public void insertUser() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(TableUser.EntryUser.COLUMN_USERNAME,"admin");
//        values.put(TableUser.EntryUser.COLUMN_PASSWORD,"admin");
//        long id = db.insert(TableUser.EntryUser.TABLE_NAME, null, values);
//    }
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
                TabelLaporan.EntryLaporan.COLUMN_IDBARANG,
                TabelLaporan.EntryLaporan.COLUMN_NEWNAME,
                TabelLaporan.EntryLaporan.COLUMN_STOKBARU,
                TabelLaporan.EntryLaporan.COLUMN_OLDNAME,
                TabelLaporan.EntryLaporan.COLUMN_STOKLAMA,
                TabelLaporan.EntryLaporan.COLUMN_HARGALAMA,
                TabelLaporan.EntryLaporan.COLUMN_HARGABARU,
                TabelLaporan.EntryLaporan.COLUMN_DATE
        };
        Cursor cursor;
        cursor = db.query(
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
    public Cursor getUser() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TableUser.EntryUser._ID,
                TableUser.EntryUser.COLUMN_USERNAME,
                TableUser.EntryUser.COLUMN_PASSWORD
        };
//        String selection = TableUser.EntryUser.COLUMN_USERNAME + "=? AND "+TableUser.EntryUser.COLUMN_PASSWORD+" = ?";
//        String[] selectionArgs = new String[] { username,password };
        Cursor cursor = db.query(
                TableUser.EntryUser.TABLE_NAME,
                projection,
                null,
               null,
                null,
                null,
                null
        );
      return cursor;
    }
    public Cursor doLogin(String username,String password) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TableUser.EntryUser._ID,
                TableUser.EntryUser.COLUMN_USERNAME,
                TableUser.EntryUser.COLUMN_PASSWORD
        };
        String selection = TableUser.EntryUser.COLUMN_USERNAME + "=? AND "
                +TableUser.EntryUser.COLUMN_PASSWORD+" = ? AND "+TableUser.EntryUser._ID+"='1'";
        String[] selectionArgs = new String[] { username,password };
        Cursor cursor = db.query(
                TableUser.EntryUser.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }
    public Cursor cekPasswordLama(String pwlama) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                TableUser.EntryUser._ID,
                TableUser.EntryUser.COLUMN_USERNAME,
                TableUser.EntryUser.COLUMN_PASSWORD
        };
        String selection = TableUser.EntryUser.COLUMN_PASSWORD+" = ? AND "+TableUser.EntryUser._ID+"='1'";
        String[] selectionArgs = new String[] { pwlama};
        Cursor cursor = db.query(
                TableUser.EntryUser.TABLE_NAME,
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
                TabelLaporan.EntryLaporan.COLUMN_IDBARANG,
                TabelLaporan.EntryLaporan.COLUMN_NEWNAME,
                TabelLaporan.EntryLaporan.COLUMN_STOKBARU,
                TabelLaporan.EntryLaporan.COLUMN_OLDNAME,
                TabelLaporan.EntryLaporan.COLUMN_STOKLAMA,
                TabelLaporan.EntryLaporan.COLUMN_HARGALAMA,
                TabelLaporan.EntryLaporan.COLUMN_HARGABARU,
                TabelLaporan.EntryLaporan.COLUMN_DATE
        };
        String selection = TabelLaporan.EntryLaporan.COLUMN_DATE + " BETWEEN '"+date1+"' AND '"+date2+"'";
//        String[] selectionArgs = new String[] {   String.valueOf(date1) };

//        Cursor cursor;
//        cursor = db.query(
//                TabelLaporan.EntryLaporan.TABLE_NAME,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                null
//        );
        Cursor cursor = db.query(
                TabelLaporan.EntryLaporan.TABLE_NAME,
                projection,
                selection,
                null,
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

    public void gantiPassword(String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableUser.EntryUser.COLUMN_PASSWORD,password);
        String selection = TableUser.EntryUser._ID + "= 1";
//        String[] selectionArgs = new String[] {  };
        db.update(TableUser.EntryUser.TABLE_NAME,
                values, selection, null
        );
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
        CharSequence s  = DateFormat.format("yyyy-MM-dd", d.getTime());
        values.put(TabelLaporan.EntryLaporan.COLUMN_IDBARANG, item.getIdBarang());
        values.put(TabelLaporan.EntryLaporan.COLUMN_OLDNAME, item.getNamaLama());
        values.put(TabelLaporan.EntryLaporan.COLUMN_NEWNAME, item.getNamaBaru());
        values.put(TabelLaporan.EntryLaporan.COLUMN_DATE, (String) s);
        values.put(TabelLaporan.EntryLaporan.COLUMN_STOKLAMA, item.getJumlahLama());
        values.put(TabelLaporan.EntryLaporan.COLUMN_STOKBARU, item.getJumlahBaru());
        values.put(TabelLaporan.EntryLaporan.COLUMN_HARGALAMA, item.getHargaLama());
        values.put(TabelLaporan.EntryLaporan.COLUMN_HARGABARU, item.getHargaBaru());
        long id = db.insert(TabelLaporan.EntryLaporan.TABLE_NAME, null, values);
    }
}
