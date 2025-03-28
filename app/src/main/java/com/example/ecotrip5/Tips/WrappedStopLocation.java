package com.example.ecotrip5.Tips;

import com.google.gson.annotations.SerializedName;

public class WrappedStopLocation {
    @SerializedName("StopLocation")
    private StopLocation stopLocation;

    public StopLocation getStopLocation() {
        return stopLocation;
    }
}

