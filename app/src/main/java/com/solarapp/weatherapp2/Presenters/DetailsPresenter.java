package com.solarapp.weatherapp2.Presenters;

import com.solarapp.weatherapp2.Adapters.DetailsAdapter;
import com.solarapp.weatherapp2.Contracts.IDetailView;
import com.solarapp.weatherapp2.Contracts.IDetailsPresenter;
import com.solarapp.weatherapp2.Contracts.REST;
import com.solarapp.weatherapp2.Contracts.WeatherAPI;
import com.solarapp.weatherapp2.Models.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vereskun on 16.09.2017.
 */

public class DetailsPresenter implements IDetailsPresenter{

    private IDetailView view;
    private Retrofit retrofit;
    private WeatherAPI weatherAPI;
    private String key;

    public DetailsPresenter(IDetailView view, String key) {
        this.view = view;
        this.key = key;
        retrofit = new Retrofit.Builder()
                .baseUrl(REST.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherAPI = retrofit.create(WeatherAPI.class);
    }

    @Override
    public void onViewCreated() {
        getWeatherAPI().getWeather5days(key,REST.API_KEY,"true").enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.body() != null){
                    DetailsAdapter adapter = new DetailsAdapter(response.body());
                    view.setDatailsAdapter(adapter);
                }
                else {
                    view.showMessage("Error. Maybe API_KEY has expired");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                view.showMessage("Error. Something wrong");
            }
        });
    }

    public WeatherAPI getWeatherAPI() {
        return weatherAPI;
    }
}
