package com.solarapp.weatherapp2.Presenters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.solarapp.weatherapp2.Contracts.DataBase;
import com.solarapp.weatherapp2.Contracts.IMainPresenter;
import com.solarapp.weatherapp2.Contracts.IMainView;
import com.solarapp.weatherapp2.Contracts.REST;
import com.solarapp.weatherapp2.Contracts.WeatherAPI;
import com.solarapp.weatherapp2.DBHelper;
import com.solarapp.weatherapp2.Models.City;
import com.solarapp.weatherapp2.Models.Region;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vereskun on 16.09.2017.
 */

public class MainPresenter implements IMainPresenter {

    private IMainView view;
    private WeatherAPI weatherAPI;
    private Retrofit retrofit;
    private ArrayList<Region> regions;
    private ArrayList<Region> countries;
    private Region selectedCountry;
    private ArrayList<City> cities;
    private String[] regionsText;
    private String[] countriesText;
    private String[] citiesText;
    private boolean isCitySelected;
    private City selectedCity;
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private ArrayList<String> preferCitiesName;
    private ArrayList<String> preferCitiesKey;
    private Context context;

    public MainPresenter(IMainView view, Context context){
        this.view = view;
        retrofit = new Retrofit.Builder()
                .baseUrl(REST.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherAPI = retrofit.create(WeatherAPI.class);
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        this.context = context;
    }

    public WeatherAPI getWeatherAPI() {
        return weatherAPI;
    }

    @Override
    public void onSpRegionsItemSelected(int position) {
        countries = new ArrayList<>();
        getWeatherAPI().getCountries(regionsText[position],REST.API_KEY).enqueue(new Callback<List<Region>>() {
            @Override
            public void onResponse(Call<List<Region>> call, Response<List<Region>> response) {
                if (response.body() != null){
                    countries.addAll(response.body());
                    countriesText = new String[countries.size()];
                    for (int i = 0; i < countries.size(); i++) {
                        countriesText[i] = countries.get(i).getLocalizedName();
                    }
                    view.setSpCountriesAdapter(countriesText);
                    view.setSpCountriesEnabled(true);
                }
                else {
                    view.showMessage("Error. Maybe API_KEY has expired");
                }
            }

            @Override
            public void onFailure(Call<List<Region>> call, Throwable t) {
                view.showMessage("Some Error");
            }
        });
    }

    @Override
    public void onSpCoutriesItemSelected(int position) {
        selectedCountry = countries.get(position);
        view.setAutocompleteTextClear();
        view.setAutoCompleteCitiesEnabled(true);
    }

    @Override
    public void onAutocomleteTextChanged(String text) {

        String countryCode = selectedCountry.getId();
        getWeatherAPI().getAutocomplete(countryCode,text,REST.API_KEY).enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                if (response.body() != null){
                    if (!isCitySelected) {
                        cities = new ArrayList<>();
                        cities.addAll(response.body());
                        citiesText = new String[cities.size()];
                        for (int i = 0; i < cities.size(); i++) {
                            citiesText[i] = cities.get(i).getLocalizedName();
                        }
                        view.setAutoComleteCitiesAdapter(citiesText);
                        view.setFabAddEnabled(false);
                    }
                    isCitySelected = false;

                }
                else {
                    view.showMessage("Error. Maybe API_KEY has expired");
                }
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                //view.showMessage("Some Error");
            }
        });
    }

    @Override
    public void onAutocomleteItemClick(int i) {
        isCitySelected = true;
        view.setFabAddEnabled(true);
        selectedCity = cities.get(i);
    }

    @Override
    public void onFabAddClick() {
        view.showMessage("Selected City: "+selectedCity.getLocalizedName()+ "added to Prefer City");
        ContentValues values = new ContentValues();
        String name = selectedCity.getLocalizedName();
        String key = selectedCity.getKey();
        values.put(DataBase.Cities.LOCALIZED_NAME,name);
        values.put(DataBase.Cities.KEY,key);
        db.insert(DataBase.TABLE_CITIES,null,values);
        getPreferCitiesFromDB();
        view.setCitiesListAdapter(preferCitiesName);
    }

    @Override
    public void onSelectLayoutClick() {
        view.setSelectLayout();
    }

    @Override
    public void onPreferLayounClick() {
        view.setPreferLayout();
    }

    @Override
    public void onViewCreated() {
        view.setSelectLayout();
        getPreferCitiesFromDB();
        view.setCitiesListAdapter(preferCitiesName);
        getRegions();
    }

    @Override
    public void onListViewItemClick(int position) {
        view.startActivityDetails(preferCitiesKey.get(position));
    }

    private void getRegions(){
        regions = new ArrayList<>();
        getWeatherAPI().getRegions(REST.API_KEY).enqueue(new Callback<List<Region>>() {
            @Override
            public void onResponse(Call<List<Region>> call, Response<List<Region>> response) {
                if (response.body() != null){
                    regions.addAll(response.body());
                    regionsText = new String[regions.size()];
                    for (int i = 0; i < regions.size(); i++) {
                        regionsText[i] = regions.get(i).getLocalizedName();
                    }
                    view.setSpRegionsAdspter(regionsText);
                    view.setSpRegionsEnabled(true);
                }
                else {
                    view.showMessage("Error. Maybe API_KEY has expired");
                }

            }

            @Override
            public void onFailure(Call<List<Region>> call, Throwable t) {
                view.showMessage("Some Error");
            }
        });
    }

    private void getPreferCitiesFromDB(){
        Cursor cursor = db.query(DataBase.TABLE_CITIES,new String[]{DataBase.Cities.LOCALIZED_NAME,DataBase.Cities.KEY},"",null,null,null,null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                preferCitiesKey = new ArrayList<>();
                preferCitiesName = new ArrayList<>();
                do{
                    preferCitiesName.add(cursor.getString(cursor.getColumnIndex(DataBase.Cities.LOCALIZED_NAME)));
                    preferCitiesKey.add(cursor.getString(cursor.getColumnIndex(DataBase.Cities.KEY)));
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
    }

}
