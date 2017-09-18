package com.solarapp.weatherapp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.solarapp.weatherapp2.Contracts.ContractMain;
import com.solarapp.weatherapp2.Presenters.MainPresenter;
import com.solarapp.weatherapp2.Views.ShowDetails;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContractMain.IMainView{

    private ContractMain.IMainPresenter mainPresenter;

    private ConstraintLayout selectLayout;
    private ConstraintLayout preferLayout;
    private Spinner spRegions;
    private Spinner spCountries;
    private AutoCompleteTextView autoCompleteCity;
    private FloatingActionButton fabAdd;
    private BottomNavigationView navigation;
    private ListView lvCities;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mainPresenter == null){
            Context context = getApplicationContext();
            mainPresenter = new MainPresenter(this,context);
        }

        selectLayout = (ConstraintLayout) findViewById(R.id.selectLayout);
        preferLayout = (ConstraintLayout) findViewById(R.id.preferLayout);
        spRegions = (Spinner) findViewById(R.id.spRegions);
        spRegions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainPresenter.onSpRegionsItemSelected(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spCountries = (Spinner) findViewById(R.id.spCoutries);
        spCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainPresenter.onSpCoutriesItemSelected(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        autoCompleteCity = (AutoCompleteTextView) findViewById(R.id.autoCompleteCity);
        autoCompleteCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mainPresenter.onAutocomleteTextChanged(autoCompleteCity.getText().toString());
            }
        });
        autoCompleteCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mainPresenter.onAutocomleteItemClick(i);
            }
        });
        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.onFabAddClick();
            }
        });
        fabAdd.setEnabled(false);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        mainPresenter.onSelectLayoutClick();
                        return true;
                    case R.id.navigation_dashboard:
                        mainPresenter.onPreferLayounClick();
                        return true;

                }
                return false;
            }
        });

        lvCities = (ListView)findViewById(R.id.lvCities);
        lvCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mainPresenter.onListViewItemClick(i);
            }
        });

        mainPresenter.onViewCreated();
    }

    @Override
    public void setSpRegionsAdspter(String[] regions) {
        ArrayAdapter<String> spRegionsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,regions);
        spRegions.setAdapter(spRegionsAdapter);
    }

    @Override
    public void setSpCountriesAdapter(String[] countries) {
        ArrayAdapter<String> spCountriesAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,countries);
        spCountries.setAdapter(spCountriesAdapter);
    }

    @Override
    public void setSpRegionsEnabled(boolean b) {
        spRegions.setEnabled(b);
    }

    @Override
    public void setSpCountriesEnabled(boolean b) {
        spCountries.setEnabled(b);
    }

    @Override
    public void setAutoComleteCitiesAdapter(String[] cities) {
        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,cities);
        autoCompleteCity.setAdapter(autoCompleteAdapter);
    }

    @Override
    public void setAutoCompleteCitiesEnabled(boolean b) {
        autoCompleteCity.setEnabled(b);
    }

    @Override
    public void setFabAddEnabled(boolean b) {
        fabAdd.setEnabled(b);
    }

    @Override
    public void setSelectLayout() {
        selectLayout.setVisibility(View.VISIBLE);
        preferLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setPreferLayout() {
        selectLayout.setVisibility(View.INVISIBLE);
        preferLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        System.out.println(message);
    }

    @Override
    public void setAutocompleteTextClear() {
        autoCompleteCity.setText("");
    }

    @Override
    public void setCitiesListAdapter(ArrayList<String> cities) {
        if (cities!=null) {
            ArrayAdapter<String> lvCitiesAdepter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cities);
            lvCities.setAdapter(lvCitiesAdepter);
        }
    }

    @Override
    public void startActivityDetails(String key) {
        Intent intent = new Intent(this, ShowDetails.class);
        intent.putExtra("key",key );
        startActivity(intent);
    }
}
