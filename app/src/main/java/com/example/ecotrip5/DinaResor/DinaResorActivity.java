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

    private RecyclerView recyclerView;
    private ResAdapter resAdapter;
    private List<Resa> resaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentLayout(R.layout.activity_dina_resor);
        setSelectedNavItem(R.id.nav_second);

        // 3) Initiera listan med resor
        resaList = new ArrayList<>();
        resaList.add(new Resa("Exempelresa", "Hem", "Arbete", "5 km"));

        // 4) Hitta RecyclerView
        recyclerView = findViewById(R.id.recycler_resor);

        // 5) Sätt LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 6) Skapa adapter
        resAdapter = new ResAdapter(resaList);

        // 7) Koppla adapter till RecyclerView
        recyclerView.setAdapter(resAdapter);

        Button nyResaKnapp = findViewById(R.id.button); // Din "Ny resa"-knapp
        nyResaKnapp.setOnClickListener(v -> {
            LaggTillResaDialogFragment dialog = new LaggTillResaDialogFragment();
            dialog.show(getSupportFragmentManager(), "NyResaDialog");
        });

    }
    @Override
    public void onResaLagd(Resa nyResa) {
        resaList.add(nyResa);
        resAdapter.notifyItemInserted(resaList.size() - 1);
    }

}
