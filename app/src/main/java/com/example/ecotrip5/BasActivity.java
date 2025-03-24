package com.example.ecotrip5;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.ecotrip5.DinaResor.DinaResorActivity;
import com.example.ecotrip5.Hem.HemActivity;
import com.example.ecotrip5.Notiser.NotiserActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BasActivity extends AppCompatActivity {

    protected BottomNavigationView bottomNavigationView;
    protected FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Vi sätter vår baslayout
        setContentView(R.layout.activity_bas);

        // Hitta vyer i baslayouten
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        container = findViewById(R.id.container);

        // Ställ in logik för klick i BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    int id = item.getItemId();

                    if (id == R.id.nav_first) {
                        if (!(BasActivity.this instanceof HemActivity)) {
                            startActivity(new Intent(BasActivity.this, HemActivity.class));
                            finish(); // valfritt, stänger den nuvarande aktiviteten
                        }
                        return true;

                    } else if (id == R.id.nav_second) {
                        if (!(BasActivity.this instanceof DinaResorActivity)) {
                            startActivity(new Intent(BasActivity.this, DinaResorActivity.class));
                            finish();
                        }
                        return true;

                    } else if (id == R.id.nav_third) {
                        if (!(BasActivity.this instanceof NotiserActivity)) {
                            startActivity(new Intent(BasActivity.this, NotiserActivity.class));
                            finish();
                        }
                        return true;
                    }

                    return false;
                }
        );
    }

    /**
     * Hjälpfunktion för att "injicera" barnaktivitetens layout i container.
     * Vi använder layoutinflater för att infoga den i vår FrameLayout (container).
     */
    protected void setContentLayout(int layoutResID) {
        getLayoutInflater().inflate(layoutResID, container, true);
    }

    /**
     * Kan anropas av underklasser för att sätta rätt val på nav-baren.
     */
    protected void setSelectedNavItem(int itemId) {
        bottomNavigationView.setSelectedItemId(itemId);
    }
}
