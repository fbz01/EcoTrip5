package com.example.ecotrip5.Tips;

import android.os.Bundle;

import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;

public class TipsActivity extends BasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_notiser);
        setSelectedNavItem(R.id.nav_third);
    }
}