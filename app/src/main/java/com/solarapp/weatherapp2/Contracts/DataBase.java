package com.solarapp.weatherapp2.Contracts;

/**
 * Created by vereskun on 16.09.2017.
 */

public interface DataBase {

    String NAME = "myDB";
    int VERSION = 1;
    String TABLE_CITIES = "cities";
    String CREATE_TABLE_CITIES =
            "CREATE TABLE cities (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "LocalizedName TEXT, " +
                    "Key TEXT " +
                    ")";

    interface Cities {
        String ID = "id";
        String LOCALIZED_NAME = "LocalizedName";
        String KEY = "Key";
    }
}
