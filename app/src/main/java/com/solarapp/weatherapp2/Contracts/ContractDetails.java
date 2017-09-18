package com.solarapp.weatherapp2.Contracts;

import com.solarapp.weatherapp2.Adapters.DetailsAdapter;

/**
 * Created by avereskun on 18.09.2017.
 */

public class ContractDetails {

    public interface IDetailView {

        void setDatailsAdapter(DetailsAdapter adapter);

        void showMessage(String message);

    }

    public interface IDetailsPresenter {

        void onViewCreated();

    }

}
