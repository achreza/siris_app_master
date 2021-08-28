package com.example.reza.pbobeta;

import android.provider.BaseColumns;

public class TableUser {
    public static final class EntryUser implements BaseColumns {
        public static final String TABLE_NAME = "user";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_USERNAME = "USERNAME";
        public static final String COLUMN_PASSWORD = "PASSWORD";

        public static final String CREATE_TABLE_USER = "CREATE TABLE " +
                TableUser.EntryUser.TABLE_NAME + "(" +
                TableUser.EntryUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TableUser.EntryUser.COLUMN_USERNAME + " TEXT," +
                TableUser.EntryUser.COLUMN_PASSWORD + " TEXT" + ");";
    }
}
