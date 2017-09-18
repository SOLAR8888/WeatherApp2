package com.solarapp.weatherapp2;

import android.app.Application;

import com.solarapp.weatherapp2.constants.REST;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by avereskun on 18.09.2017.
 */

public class App extends Application {

    private static WeatherAPI weatherAPI;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("App on created()");
        retrofit = new Retrofit.Builder()
                .baseUrl(REST.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherAPI = retrofit.create(WeatherAPI.class);
    }
    public static WeatherAPI getWeatherAPI() {
        return weatherAPI;
    }
}
