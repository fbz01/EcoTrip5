package com.example.ecotrip5.Tips;

import java.util.List;

import com.google.gson.annotations.SerializedName;

// -------------------------------------------------------------
// Denna klass har utformats och dokumenterats med stöd av ChatGPT (OpenAI).
// Kodstödet har använts för att skapa strukturen för API-svaret samt JavaDoc-kommentarerna.
// -------------------------------------------------------------

/*
 * Representerar svaret från en platsbaserad API-förfrågan.
 * Klassen innehåller en lista med WrappedStopLocation-objekt som kan vara antingen
 * stoppplatser eller koordinatplatser.
 */
public class LocationResponse {
    // Används för att mappa JSON-fältet "stopLocationOrCoordLocation" till denna lista
    @SerializedName("stopLocationOrCoordLocation")
    private List<WrappedStopLocation> stopLocationOrCoordLocation;

    /*
     * Hämtar listan med stoppplatser eller koordinatplatser.
     *
     * returnera Listan med WrappedStopLocation-objekt
     */
    public List<WrappedStopLocation> getStopLocationOrCoordLocation() {
        return stopLocationOrCoordLocation;
    }
}


