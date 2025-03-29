package com.example.ecotrip5;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.ecotrip5.DinaResor.DinaResorActivity;
import com.example.ecotrip5.Hem.HemActivity;
import com.example.ecotrip5.Tips.StopsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BasActivity extends AppCompatActivity {

    // Variabler för navigeringsmeny och cointainer-vy
    protected BottomNavigationView bottomNavigationView;
    protected FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sätter baslayout för aktiviteten
        setContentView(R.layout.activity_bas);

        // Hitta vyer i layout
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        container = findViewById(R.id.container);

        // Lyssnare för klick i navigeringsmenyn
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    int id = item.getItemId();

                    // Om första navigationsknappen klickas
                    if (id == R.id.nav_first) {
                        // Om inte är i HemActivity, starta den
                        if (!(BasActivity.this instanceof HemActivity)) {
                            startActivity(new Intent(BasActivity.this, HemActivity.class));
                            finish();
                        }
                        return true;
                        // Om andra navigationsknappen klickas
                    } else if (id == R.id.nav_second) {
                        // Om inte är i DinaResorActivity, starta den
                        if (!(BasActivity.this instanceof DinaResorActivity)) {
                            startActivity(new Intent(BasActivity.this, DinaResorActivity.class));
                            finish();
                        }
                        return true;
                        // Om tredje navigationsknappen klickas
                    } else if (id == R.id.nav_third) {
                        // Om inte är i StopsActivity, starta den
                        if (!(BasActivity.this instanceof StopsActivity)) {
                            startActivity(new Intent(BasActivity.this, StopsActivity.class));
                            finish();
                        }
                        return true;
                    }
                    return false;
                }
        );
    }

    // Funktion för att infoga en layout i container-vyn. Används för att byta innehållet i layouten
    protected void setContentLayout(int layoutResID) {
        getLayoutInflater().inflate(layoutResID, container, true);
    }
    // Funktion för att markera i navigationsmenyn vilken sida användaren befinner sig
    protected void setSelectedNavItem(int itemId) {
        bottomNavigationView.setSelectedItemId(itemId);
    }
}
