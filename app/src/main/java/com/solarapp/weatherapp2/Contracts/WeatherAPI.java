package com.solarapp.weatherapp2.Contracts;

import com.solarapp.weatherapp2.Models.City;
import com.solarapp.weatherapp2.Models.Region;
import com.solarapp.weatherapp2.Models.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by vereskun on 16.09.2017.
 */

public interface WeatherAPI {
    @GET("locations/v1/regions")
    Call<List<Region>> getRegions(@Query("apikey") String apikey);

    @GET("locations/v1/countries/{regionCode}")
    Call<List<Region>> getCountries(@Path("regionCode") String regionCode, @Query("apikey") String apikey);

    @GET("locations/v1/cities/{countryCode}/autocomplete")
    Call<List<City>> getAutocomplete(@Path("countryCode") String countryCode, @Query("q") String q, @Query("apikey") String apikey);

    @GET("forecasts/v1/daily/5day/{locationKey}")
    Call<Weather> getWeather5days(@Path("locationKey") String locationKey, @Query("apikey") String apikey, @Query("metric") String metric);

}
