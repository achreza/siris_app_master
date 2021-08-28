package com.example.reza.pbobeta;

import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.reza.pbobeta.usermodels;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends  SQLiteOpenHelper {
    // static variable
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "siris";

    // table name
    private static final String TABLE_TALL = "barang";

    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nama";
    private static final String KEY_TALL = "stok";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    //Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TALL + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_TALL + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);


    }

    // on Upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TALL);
        onCreate(db);


    }
    public void tambahData(usermodels userModels){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, userModels.getName());
        values.put(KEY_TALL, userModels.getTall());

        db.insert(TABLE_TALL, null, values);
        db.close();
    }
    public usermodels getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TALL, new String[] { KEY_ID,
                        KEY_NAME, KEY_TALL }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        usermodels contact = new usermodels(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;
    }
    // get All Record
    public List<usermodels> getAllRecord() {
        List<usermodels> contactList = new ArrayList<usermodels>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TALL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                usermodels userModels = new usermodels();
                userModels.setId(Integer.parseInt(cursor.getString(0)));
                userModels.setName(cursor.getString(1));
                userModels.setTall(cursor.getString(2));

                contactList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
    public int getUserModelCount() {
        String countQuery = "SELECT  * FROM " + TABLE_TALL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    public int updateContact(usermodels contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_TALL, contact.getTall());

        // updating row
        return db.update(TABLE_TALL, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
    }
    public void deleteModel(usermodels contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TALL, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        db.close();
    }









}
