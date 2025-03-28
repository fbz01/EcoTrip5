package com.example.ecotrip5.Tips;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class LocationResponse {
    @SerializedName("stopLocationOrCoordLocation")
    private List<WrappedStopLocation> stopLocationOrCoordLocation;

    public List<WrappedStopLocation> getStopLocationOrCoordLocation() {
        return stopLocationOrCoordLocation;
    }
}



