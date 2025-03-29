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
        // Infoga layout för HemActivity i container-vy från BasActivity
        setContentLayout(R.layout.activity_hem);
        // Markera att den första ikonen i navigationsfältet är vald
        setSelectedNavItem(R.id.nav_first);

        // Visa slumpad fakta med TextView
        TextView factText = findViewById(R.id.sustainabilityFact);
        String[] fakta = {
                "Genom att resa kollektivt istället för bil sparar du ~0.5 kg CO₂ per resa.",
                "10 resor i veckan med buss motsvarar att plantera ett träd.",
                "Du sparar pengar och miljö varje gång du samåker.",
                "Att ta cykeln istället för bilen i 5 km minskar utsläpp med 1.2 kg CO₂."
        };
        factText.setText(fakta[new Random().nextInt(fakta.length)]);

        // Hitta knappen för Rese alternativ
        Button reseAlternativKnapp = findViewById(R.id.reseAlternativKnapp);

        // Hämta vyer för att visa vald resa. includedCard är kort som visar information om resan
        View includedCard = findViewById(R.id.included_trip_card);
        TextView valdResa = includedCard.findViewById(R.id.valdResaTitel);
        TextView startplats = includedCard.findViewById(R.id.startplats);
        TextView slutplats = includedCard.findViewById(R.id.slutplats);
        TextView tid = includedCard.findViewById(R.id.tid);
        // Hämta och dölj knappen för att "Välja resa" då den inte används här
        Button btnSelectTrip = includedCard.findViewById(R.id.btnSelectTrip);
        btnSelectTrip.setVisibility(View.GONE);
        // TextView som visas om ingen resa är vald
        TextView ingenResaText = findViewById(R.id.tvIngenResa);

        // Hämta data från intent som skickas från annan aktivitet
        String selectedTrip = getIntent().getStringExtra("SELECTED_TRIP");
        String tripStart = getIntent().getStringExtra("TRIP_START");
        String tripEnd = getIntent().getStringExtra("TRIP_END");
        String tripTime = getIntent().getStringExtra("TRIP_TIME");

        // Om resa är vald, visa detaljer i kortet
        if (selectedTrip != null) {
            includedCard.setVisibility(View.VISIBLE);
            ingenResaText.setVisibility(View.GONE);

            // Sätt resans titel
            valdResa.setText(selectedTrip);
            // Sätt resans start
            startplats.setText("Från: " + (tripStart != null ? tripStart : "–"));
            // Sätt resans slut
            slutplats.setText("Till: " + (tripEnd != null ? tripEnd : "–"));
            // Sätt tid för resan
            tid.setText("Tid: " + (tripTime != null ? tripTime : "–"));
        } else {
            // Om ingen resa är vald dölj kortet och visa text istället
            includedCard.setVisibility(View.GONE);
            ingenResaText.setVisibility(View.VISIBLE);
        }

        // Aktivera knappen för resealternativ endast om en resa är vald
        boolean hasSelectedTrip = selectedTrip != null;
        reseAlternativKnapp.setEnabled(hasSelectedTrip);
        // Justera knappens opacitet för att visa om den är aktiv
        reseAlternativKnapp.setAlpha(hasSelectedTrip ? 1.0f : 0.5f);

        // Klick-lyssnare för knappen som visar ett dialogfragment med resealternativ
        reseAlternativKnapp.setOnClickListener(view -> {
            // Skapa instans av dialogfragment med detaljerna för resan
            ReseAlternativDialogFragment dialog =
                    ReseAlternativDialogFragment.newInstance(selectedTrip, tripStart, tripEnd, tripTime);
            // Visa dialogfragmentet
            dialog.show(getSupportFragmentManager(), "ReseAlternativDialog");
        });
    }
}
