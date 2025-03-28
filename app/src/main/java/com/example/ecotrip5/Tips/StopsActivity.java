package com.example.ecotrip5.Tips;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

public class StopsActivity extends BasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_notiser);
        setSelectedNavItem(R.id.nav_third);

        RecyclerView recyclerView = findViewById(R.id.stopsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<StopLocation> stopList = new ArrayList<>();
        StopAdapter adapter = new StopAdapter(stopList);
        recyclerView.setAdapter(adapter);

        // Retrofit-instans
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.resrobot.se/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ResRobotApi api = retrofit.create(ResRobotApi.class);

        // Position för att visa hållplatser (ex: Västervik)
        double lat = 57.7552;
        double lon = 16.6411;

        // Hämta hållplatser nära angiven position
        api.getNearbyStops("91bfd389-00bb-428c-885e-be18d887344a", lat, lon, "json")
                .enqueue(new Callback<LocationResponse>() {
                    @Override
                    public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                        if (response.isSuccessful()) {
                            LocationResponse data = response.body();
                            if (data != null && data.getStopLocationOrCoordLocation() != null) {
                                List<WrappedStopLocation> wrappedList = data.getStopLocationOrCoordLocation();

                                stopList.clear();
                                for (WrappedStopLocation wrapped : wrappedList) {
                                    StopLocation stop = wrapped.getStopLocation();
                                    if (stop != null) {
                                        stopList.add(stop);
                                    }
                                }

                                adapter.notifyDataSetChanged();
                            } else {
                                Toast.makeText(StopsActivity.this, "Inga hållplatser hittades.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(StopsActivity.this, "API-svar misslyckades: " + response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LocationResponse> call, Throwable t) {
                        Toast.makeText(StopsActivity.this, "Fel vid hämtning: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

