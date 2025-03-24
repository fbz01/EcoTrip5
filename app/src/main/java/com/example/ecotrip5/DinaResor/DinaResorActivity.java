package com.example.ecotrip5.DinaResor;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;

public class DinaResorActivity extends BasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_dina_resor);
        setSelectedNavItem(R.id.nav_second);
    }
}