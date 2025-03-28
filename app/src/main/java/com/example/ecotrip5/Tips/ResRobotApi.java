package com.example.ecotrip5.Tips;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ResRobotApi {
    @GET("v2.1/location.nearbystops")
    Call<LocationResponse> getNearbyStops(
            @Query("accessId") String apiKey,
            @Query("originCoordLat") double lat,
            @Query("originCoordLong") double lon,
            @Query("format") String format
    );
}

