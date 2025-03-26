package com.example.ecotrip5.Hem;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;

public class HemActivity extends BasActivity {

    private TextView tvChosenTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_hem);
        setSelectedNavItem(R.id.nav_first);
        Log.d("HemActivity", "Extras: " + getIntent().getExtras());

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            for (String key : extras.keySet()) {
                Log.d("HemActivity", "key=" + key + " => " + extras.get(key));
            }
        } else {
            Log.d("HemActivity", "extras är null.");
        }


        String selectedTrip = getIntent().getStringExtra("SELECTED_TRIP");


        Log.d("HemActivity", "onCreate - intent extras: " + getIntent().getExtras());

        // Hämta data från Intent
        TextView tv = findViewById(R.id.tvChosenTrip);
        if (selectedTrip != null) {
            tv.setText("Vald resa: " + selectedTrip);
        } else {
            tv.setText("Ingen resa vald");
        }



        Button loginButton = findViewById(R.id.btnReseAlternativ);

        // Sätt en klicklyssnare
        loginButton.setOnClickListener(view -> {
            // 1) Skapa en instans av din DialogFragment
            ReseAlternativDialogFragment dialog = new ReseAlternativDialogFragment();

            // 2) Visa dialogen
            dialog.show(getSupportFragmentManager(), "ReseAlternativDialog");
        });

    }


}