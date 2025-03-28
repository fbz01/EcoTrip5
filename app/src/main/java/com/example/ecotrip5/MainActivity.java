package com.example.ecotrip5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecotrip5.Hem.HemActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Knapp för att "Logga in" och gå vidare till HemActivity
        // Knapp för att "Logga in" och gå vidare till HemActivity
        Button loggaIn = findViewById(R.id.loggaInKnapp);

        loggaIn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HemActivity.class);
            startActivity(intent);
            finish();
        });
    }
}