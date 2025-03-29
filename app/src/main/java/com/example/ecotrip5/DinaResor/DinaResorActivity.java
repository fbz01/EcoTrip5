package com.example.ecotrip5.DinaResor;

import android.os.Bundle;
import android.widget.Button;

import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DinaResorActivity extends BasActivity implements LaggTillResaDialogFragment.ResaDialogListener{

    // Recyclerview för listan med resor
    private RecyclerView recyclerView;
    // Adapter för hur resorna ska visas
    private ResAdapter resAdapter;
    // Lista med resor
    private List<Resa> resaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Infoga layouten för dina resor i container-vyn från BasActivty
        setContentLayout(R.layout.activity_dina_resor);
        // Markera att den andra navigeringsikonen är vald
        setSelectedNavItem(R.id.nav_second);

        // Initiera listan med resor
        resaList = new ArrayList<>();
        resaList.add(new Resa("Exempelresa", "Hem", "Arbete", "08.30"));

        // Hitta RecyclerView i layouten
        recyclerView = findViewById(R.id.recycler_resor);

        // Sätt linjär layout för resorna
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Skapa adaptern med listan av resor
        resAdapter = new ResAdapter(resaList);

        // Koppla adapter till RecyclerView
        recyclerView.setAdapter(resAdapter);

        // Hitta knappen för att lägga till en ny resa
        Button nyResaKnapp = findViewById(R.id.button);
        // Klick-lyssnare för att öppna en dialogruta för att lägga till en ny resa
        nyResaKnapp.setOnClickListener(v ->
                new LaggTillResaDialogFragment().show(getSupportFragmentManager(), "NyResaDialog")
        );

    }

    @Override
    public void onResaLagd(Resa nyResa) {
        // Lägg till den nya resan i listan
        resaList.add(nyResa);
        // Informera adaptern så att recyclerview uppdateras
        resAdapter.notifyItemInserted(resaList.size() - 1);
    }

}
