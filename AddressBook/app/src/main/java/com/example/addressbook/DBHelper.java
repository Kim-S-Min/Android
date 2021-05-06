package com.example.addressbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=8;

    public DBHelper(Context context) { super(context, "addressdb", null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String addressSql = "create table address_data (" +
                "_id integer primary key autoincrement," +
                "name not null," +
                "hp varchar2(20), " +
                "content)";
        db.execSQL(addressSql);

        db.execSQL("insert into address_data (name, hp, content) values ('홍길동', '1111111', 'dddddddddddddd')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table address_data");
            onCreate(db);
        }
    }
}
