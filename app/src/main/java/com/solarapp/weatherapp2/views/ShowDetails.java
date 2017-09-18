package com.solarapp.weatherapp2.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.solarapp.weatherapp2.adapters.DetailsAdapter;
import com.solarapp.weatherapp2.contracts.ContractDetails;
import com.solarapp.weatherapp2.presenters.DetailsPresenter;
import com.solarapp.weatherapp2.R;

public class ShowDetails extends AppCompatActivity implements ContractDetails.DetailViewable {

    private RecyclerView rvDetails;
    private RecyclerView.LayoutManager mLayoutManager;
    private ContractDetails.DetailsPresenterable detailsPresenter;
    private String key = "349727";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        key = getIntent().getStringExtra("key");
        rvDetails = (RecyclerView) findViewById(R.id.rvDetails);

        mLayoutManager = new LinearLayoutManager(this);
        rvDetails.setLayoutManager(mLayoutManager);

        detailsPresenter = new DetailsPresenter(this,key);
        detailsPresenter.onViewCreated();
    }

    @Override
    public void setDatailsAdapter(DetailsAdapter adapter) {
        rvDetails.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        System.out.println(message);
    }
}
