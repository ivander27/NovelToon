package com.example.noveltoon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbnoveltoon extends SQLiteOpenHelper {
    private static final String database_Name = "profil.db";
    private static final int database_Version = 1;
    public dbnoveltoon(Context context){
        super(context, database_Name,null,database_Version);
    }
    @Override
    public void onCreate (SQLiteDatabase db){
        String sql = "create table profil(no integer primary key, nama text null, email text null, umur text null);";
        Log.d("Data","onCreate : " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
