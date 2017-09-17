package com.solarapp.weatherapp2.Contracts;

import java.util.ArrayList;

/**
 * Created by vereskun on 16.09.2017.
 */

public interface IMainView {

    void setSpRegionsAdspter(String[] regions);
    void setSpCountriesAdapter(String[] countries);
    void setSpRegionsEnabled(boolean b);
    void setSpCountriesEnabled(boolean b);
    void setAutoComleteCitiesAdapter(String[] cities);
    void setAutoCompleteCitiesEnabled(boolean b);
    void setAutocompleteTextClear();
    void setFabAddEnabled(boolean b);
    void setCitiesListAdapter(ArrayList<String> cities);
    void startActivityDetails(String key);

    void setSelectLayout();
    void setPreferLayout();

    void showMessage(String message);

}
