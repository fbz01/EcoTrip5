package com.example.ecotrip5.Notiser;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;

public class NotiserActivity extends BasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_notiser);
        setSelectedNavItem(R.id.nav_third);
    }
}