package com.solarapp.weatherapp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.solarapp.weatherapp2.constants.DataBase;

/**
 * Created by vereskun on 16.09.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, DataBase.NAME, null, DataBase.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBase.CREATE_TABLE_CITIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
