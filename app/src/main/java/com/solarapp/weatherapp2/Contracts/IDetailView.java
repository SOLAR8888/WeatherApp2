package com.solarapp.weatherapp2.Contracts;

import com.solarapp.weatherapp2.Adapters.DetailsAdapter;

/**
 * Created by vereskun on 16.09.2017.
 */

public interface IDetailView {

    void setDatailsAdapter(DetailsAdapter adapter);

    void showMessage(String message);

}
