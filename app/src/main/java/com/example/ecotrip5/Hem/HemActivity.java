package com.example.ecotrip5.Hem;

import android.os.Bundle;
import android.widget.Button;


import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;

public class HemActivity extends BasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new HemFragment())
                .commit();
        setSelectedNavItem(R.id.nav_first);

    }
}