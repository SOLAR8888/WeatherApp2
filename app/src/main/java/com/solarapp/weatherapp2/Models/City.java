package com.solarapp.weatherapp2.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vereskun on 16.09.2017.
 */

public class City {
    @SerializedName("Version")
    @Expose
    private int version;

    @SerializedName("Key")
    @Expose
    private String key;

    @SerializedName("Type")
    @Expose
    private String type;

    @SerializedName("Rank")
    @Expose
    private int rank;

    @SerializedName("LocalizedName")
    @Expose
    private String localizedName;

    @SerializedName("Country")
    @Expose
    private Country country;

    @SerializedName("AdministrativeArea")
    @Expose
    private AdministrativeArea administrativeArea;

    class Country {
        @SerializedName("ID")
        @Expose
        private String id;

        @SerializedName("LocalizedName")
        @Expose
        private String localizedName;


    }
    class AdministrativeArea {
        @SerializedName("ID")
        @Expose
        private String id;

        @SerializedName("LocalizedName")
        @Expose
        private String localizedName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public AdministrativeArea getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(AdministrativeArea administrativeArea) {
        this.administrativeArea = administrativeArea;
    }
}
