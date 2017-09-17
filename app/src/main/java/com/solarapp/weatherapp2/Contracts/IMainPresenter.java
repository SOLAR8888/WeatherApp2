package com.solarapp.weatherapp2.Contracts;

/**
 * Created by vereskun on 16.09.2017.
 */

public interface IMainPresenter {

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
