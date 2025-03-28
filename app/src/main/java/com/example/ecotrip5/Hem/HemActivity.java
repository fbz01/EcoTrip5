package com.example.ecotrip5.Hem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;

public class HemActivity extends BasActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_hem);
        setSelectedNavItem(R.id.nav_first);

        // Visa ett slumpmässigt faktatext
        TextView factText = findViewById(R.id.sustainabilityFact);
        String[] fakta = {
                "Genom att resa kollektivt istället för bil sparar du ~0.5 kg CO₂ per resa.",
                "10 resor i veckan med buss motsvarar att plantera ett träd.",
                "Du sparar pengar och miljö varje gång du samåker.",
                "Att ta cykeln istället för bilen i 5 km minskar utsläpp med 1.2 kg CO₂."
        };
        factText.setText(fakta[new Random().nextInt(fakta.length)]);

        // Hämta vyer för resans info
        Button reseAlternativKnapp = findViewById(R.id.reseAlternativKnapp);
        View includedCard = findViewById(R.id.included_trip_card);
        TextView valdResa = includedCard.findViewById(R.id.valdResaTitel);
        TextView startplats = includedCard.findViewById(R.id.startplats);
        TextView slutplats = includedCard.findViewById(R.id.slutplats);
        TextView tid = includedCard.findViewById(R.id.tid);
        Button btnSelectTrip = includedCard.findViewById(R.id.btnSelectTrip);
        btnSelectTrip.setVisibility(View.GONE); // vi använder inte knappen här

        TextView ingenResaText = findViewById(R.id.tvIngenResa);

        // Hämta data från intent
        String selectedTrip = getIntent().getStringExtra("SELECTED_TRIP");
        String tripStart = getIntent().getStringExtra("TRIP_START");
        String tripEnd = getIntent().getStringExtra("TRIP_END");
        String tripTime = getIntent().getStringExtra("TRIP_TIME");

        if (selectedTrip != null) {
            includedCard.setVisibility(View.VISIBLE);
            ingenResaText.setVisibility(View.GONE);

            valdResa.setText(selectedTrip);
            startplats.setText("Från: " + (tripStart != null ? tripStart : "–"));
            slutplats.setText("Till: " + (tripEnd != null ? tripEnd : "–"));
            tid.setText("Tid: " + (tripTime != null ? tripTime : "–"));
        } else {
            includedCard.setVisibility(View.GONE);
            ingenResaText.setVisibility(View.VISIBLE);
        }

        // Aktivera knappen om en resa är vald
        boolean hasSelectedTrip = selectedTrip != null;
        reseAlternativKnapp.setEnabled(hasSelectedTrip);
        reseAlternativKnapp.setAlpha(hasSelectedTrip ? 1.0f : 0.5f);

        // Uppdaterad: skicka med all info till dialogen
        reseAlternativKnapp.setOnClickListener(view -> {
            ReseAlternativDialogFragment dialog =
                    ReseAlternativDialogFragment.newInstance(selectedTrip, tripStart, tripEnd, tripTime);
            dialog.show(getSupportFragmentManager(), "ReseAlternativDialog");
        });
    }
}
