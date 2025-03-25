package com.example.ecotrip5.Hem;

import android.os.Bundle;
import android.widget.Button;


import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;

public class HemActivity extends BasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_hem);
        setSelectedNavItem(R.id.nav_first);

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