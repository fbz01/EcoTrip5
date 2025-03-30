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

// -------------------------------------------------------------
// Denna aktivitet har utvecklats med stöd av ChatGPT (OpenAI).
// ChatGPT användes för att:
// – Strukturera onCreate-metoden och RecyclerView-flödet
// – Implementera Retrofit-anrop mot ResRobot API
// – Felsöka API-svar och hantera olika felkoder
// – Kommentera och förklara koden i pedagogisk stil
// -------------------------------------------------------------

public class StopsActivity extends BasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Infoga layouten för aktiviteten i container-vyn från BasActivity
        setContentLayout(R.layout.activity_stops);
        // Markera den tredje navigationsikonen
        setSelectedNavItem(R.id.nav_third);

        // Hitta recyclerview i layouten och sätt linjär layout
        RecyclerView recyclerView = findViewById(R.id.stopsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Skapa en lista som ska fyllas med hållplatser
        List<StopLocation> stopList = new ArrayList<>();
        // Skapa adapter med listan och koppla till recyclerview
        StopAdapter adapter = new StopAdapter(stopList);
        recyclerView.setAdapter(adapter);

        // Retrofit-instans för att kommunicera med ResRobot API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.resrobot.se/") // Bas URL för API:et
                .addConverterFactory(GsonConverterFactory.create()) // Gson för JSON konvertering
                .build();

        // Skapa en instans av API gränssnittet
        ResRobotApi api = retrofit.create(ResRobotApi.class);

        // Longitut och latitud för position där närliggande hållplatser ska visas
        double lat = 57.7552;
        double lon = 16.6411;

        // Anropa API:et för att hämta närliggande stoppplatser och hantera svaret asynkront
        api.getNearbyStops("91bfd389-00bb-428c-885e-be18d887344a", lat, lon, "json")
                .enqueue(new Callback<LocationResponse>() {
                    @Override
                    public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                        // Kontrollera om API svaret lyckas
                        if (response.isSuccessful()) {
                            LocationResponse data = response.body();
                            // Kontrollera att datan är giltig och listan inte är null
                            if (data != null && data.getStopLocationOrCoordLocation() != null) {
                                List<WrappedStopLocation> wrappedList = data.getStopLocationOrCoordLocation();
                                // Rensa listan innan ny data läggs till
                                stopList.clear();
                                // Iterera igenom varje stopplats-objekt
                                for (WrappedStopLocation wrapped : wrappedList) {
                                    StopLocation stop = wrapped.getStopLocation();
                                    if (stop != null) {
                                        stopList.add(stop);
                                    }
                                }
                                // Meddela adaptern att data har ändrats så vyn kan uppdateras
                                adapter.notifyDataSetChanged();
                            } else {
                                // Visa en toast meddelande om inga hållplatser hittats
                                Toast.makeText(StopsActivity.this, "Inga hållplatser hittades.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Visa toast meddelande om api svaret misslyckats med status kod
                            Toast.makeText(StopsActivity.this, "API-svar misslyckades: " + response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LocationResponse> call, Throwable t) {
                        // Vid fel, visa toast meddelande med felinformation
                        Toast.makeText(StopsActivity.this, "Fel vid hämtning: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
