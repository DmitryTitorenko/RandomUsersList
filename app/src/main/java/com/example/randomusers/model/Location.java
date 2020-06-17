package com.example.randomusers.model;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("country")
    private String country;

    @SerializedName("city")
    private String city;

    @SerializedName("street")
    private Street street;

    @SerializedName("timezone")
    private Timezone timezone;

    @SerializedName("postcode")
    private String postcode;

    @SerializedName("coordinates")
    private Coordinates coordinates;

    @SerializedName("state")
    private String state;

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Street getStreet() {
        return street;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public String getPostcode() {
        return postcode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getState() {
        return state;
    }
}
