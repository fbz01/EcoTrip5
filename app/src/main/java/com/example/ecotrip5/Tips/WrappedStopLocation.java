package com.example.ecotrip5.Tips;

import com.google.gson.annotations.SerializedName;

public class WrappedStopLocation {
    // Mappning av JSON-fältet "StopLocation" till detta fält
    @SerializedName("StopLocation")
    private StopLocation stopLocation;

    // Hämtar StopLocation-objektet som mappats från JSON.
    public StopLocation getStopLocation() {
        return stopLocation;
    }
}
