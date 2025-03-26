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

        String selectedTrip = getIntent().getStringExtra("SELECTED_TRIP");

        TextView tvChosenTrip = findViewById(R.id.tvChosenTrip);


        if (selectedTrip != null && tvChosenTrip != null) {
            tvChosenTrip.setText(selectedTrip);
        } else {
            tvChosenTrip.setText("Ingen resa vald");
        }

        Button reseAlternativKnapp = findViewById(R.id.reseAlternativKnapp);

        reseAlternativKnapp.setOnClickListener(view -> {
            ReseAlternativDialogFragment dialog = new ReseAlternativDialogFragment();
            dialog.show(getSupportFragmentManager(), "ReseAlternativDialog");
        });

    }


}