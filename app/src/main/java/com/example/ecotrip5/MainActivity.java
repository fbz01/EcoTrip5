package com.example.ecotrip5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecotrip5.Hem.HemActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sätta layout för aktiviteten
        setContentView(R.layout.activity_main);

        // Hitta knappen för att logga in
        Button loggaIn = findViewById(R.id.loggaInKnapp);

        // Klick lyssnare för att "Logga in" och starta HemActivity
        loggaIn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HemActivity.class);
            // Starta HemActivity
            startActivity(intent);
            // Avsluta MainActivity så att inte användaren kan återvända
            finish();
        });
    }
}