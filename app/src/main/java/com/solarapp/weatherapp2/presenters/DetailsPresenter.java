package com.solarapp.weatherapp2.presenters;

import com.solarapp.weatherapp2.adapters.DetailsAdapter;
import com.solarapp.weatherapp2.contracts.ContractDetails;
import com.solarapp.weatherapp2.constants.REST;
import com.solarapp.weatherapp2.models.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.solarapp.weatherapp2.App.getWeatherAPI;

/**
 * Created by vereskun on 16.09.2017.
 */

public class DetailsPresenter implements ContractDetails.DetailsPresenterable {

    private ContractDetails.DetailViewable view;
    private String key;

    public DetailsPresenter(ContractDetails.DetailViewable view, String key) {
        this.view = view;
        this.key = key;
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

}
