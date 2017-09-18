package com.solarapp.weatherapp2.contracts;

import java.util.ArrayList;

/**
 * Created by avereskun on 18.09.2017.
 */

public class ContractMain {

    public interface MainViewable {

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

    public interface MainPresenterable {

        void onSpRegionsItemSelected(int position);
        void onSpCoutriesItemSelected(int position);
        void onAutocomleteTextChanged(String text);
        void onAutocomleteItemClick(int i);
        void onFabAddClick();
        void onListViewItemClick(int position);

        void onSelectLayoutClick();
        void onPreferLayounClick();

        void onViewCreated();

    }

}
