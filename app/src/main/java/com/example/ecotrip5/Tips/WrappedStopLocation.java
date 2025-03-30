package com.example.ecotrip5.Tips;

import com.google.gson.annotations.SerializedName;

// -------------------------------------------------------------
// Denna klass har skapats med stöd av ChatGPT (OpenAI).
// Syftet är att hantera inbäddade objekt från ResRobots JSON-svar,
// där varje StopLocation är inslagen i ett objekt.
// ChatGPT hjälpte till att identifiera behovet av denna wrapper
// och att använda @SerializedName-annotering.
// -------------------------------------------------------------

public class WrappedStopLocation {
    // Mappning av JSON-fältet "StopLocation" till detta fält
    @SerializedName("StopLocation")
    private StopLocation stopLocation;

    // Hämtar StopLocation-objektet som mappats från JSON.
    public StopLocation getStopLocation() {
        return stopLocation;
    }
}
