package com.solarapp.weatherapp2.contracts;

import com.solarapp.weatherapp2.adapters.DetailsAdapter;

/**
 * Created by avereskun on 18.09.2017.
 */

public class ContractDetails {

    public interface DetailViewable {

        void setDatailsAdapter(DetailsAdapter adapter);

        void showMessage(String message);

    }

    public interface DetailsPresenterable {

        void onViewCreated();

    }

}
