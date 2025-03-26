package com.example.ecotrip5.DinaResor;

import android.os.Bundle;
import com.example.ecotrip5.BasActivity;
import com.example.ecotrip5.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DinaResorActivity extends BasActivity {

    private RecyclerView recyclerView;
    private ResAdapter resAdapter;
    private List<Resa> resaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1) Lägg baslayouten i BasActivity
        // setContentView(R.layout.activity_bas);  // om du har en baslayout

        // 2) Lägg in "activity_dina_resor" i BasActivitys container
        // (om du använder ditt BasActivity-upplägg)
        setContentLayout(R.layout.activity_dina_resor);
        setSelectedNavItem(R.id.nav_second);

        // 3) Initiera listan med resor
        resaList = new ArrayList<>();
        resaList.add(new Resa("Hem - Arbete\n5 km"));
        resaList.add(new Resa("Hem - Centrum\n2.3 km"));
        resaList.add(new Resa("Hem - Stockholm\n41 km"));

        // 4) Hitta RecyclerView
        recyclerView = findViewById(R.id.recycler_resor);

        // 5) Sätt LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 6) Skapa adapter
        resAdapter = new ResAdapter(resaList);

        // 7) Koppla adapter till RecyclerView
        recyclerView.setAdapter(resAdapter);
    }
}
