package com.example.ecotrip5.Tips;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ResRobotApi {
    /**
     * Hämtar en lista med närliggande busshållsplatser baserat på angivna koordinater.
     *
     * @param apiKey  API-nyckeln (accessId) som krävs för autentisering.
     * @param lat     Latitud för utgångspunkten.
     * @param lon     Longitud för utgångspunkten.
     * @param format  Önskat format på svaret (t.ex. "json").
     * @return Ett Call-objekt som hanterar den asynkrona förfrågan och returnerar ett LocationResponse.
     */
    @GET("v2.1/location.nearbystops")
    Call<LocationResponse> getNearbyStops(
            @Query("accessId") String apiKey,
            @Query("originCoordLat") double lat,
            @Query("originCoordLong") double lon,
            @Query("format") String format
    );
}
