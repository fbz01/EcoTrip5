package com.example.ecotrip5.Hem;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.ecotrip5.R;
import java.util.ArrayList;
import java.util.List;

public class ReseAlternativDialogFragment extends DialogFragment {

    private static final String ARG_SELECTED_TRIP = "SELECTED_TRIP";
    private static final String ARG_TRIP_START = "TRIP_START";
    private static final String ARG_TRIP_END = "TRIP_END";
    private static final String ARG_TRIP_TIME = "TRIP_TIME";

    public ReseAlternativDialogFragment() {
        // Tom konstruktor nödvändig
    }

    public static ReseAlternativDialogFragment newInstance(String selectedTrip, String tripStart, String tripEnd, String tripTime) {
        ReseAlternativDialogFragment fragment = new ReseAlternativDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SELECTED_TRIP, selectedTrip);
        args.putString(ARG_TRIP_START, tripStart);
        args.putString(ARG_TRIP_END, tripEnd);
        args.putString(ARG_TRIP_TIME, tripTime);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sätt ett fullskärmsdialog-tema
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_MyApp_FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rese_alternativ_dialog, container, false);

        // Hämta argumenten
        Bundle args = getArguments();
        String selectedTrip = args != null ? args.getString(ARG_SELECTED_TRIP) : "Ingen resa vald";
        String tripStart = args != null ? args.getString(ARG_TRIP_START) : "–";
        String tripEnd = args != null ? args.getString(ARG_TRIP_END) : "–";
        String tripTime = args != null ? args.getString(ARG_TRIP_TIME) : "–";

        // Visa informationen i det inkluderade kortet
        View includedCard = rootView.findViewById(R.id.included_trip_card);
        if (includedCard != null) {
            TextView tvTitle = includedCard.findViewById(R.id.valdResaTitel);
            TextView tvStart = includedCard.findViewById(R.id.startplats);
            TextView tvEnd = includedCard.findViewById(R.id.slutplats);
            TextView tvTime = includedCard.findViewById(R.id.tid);
            Button selectButton = includedCard.findViewById(R.id.btnSelectTrip);
            if (selectButton != null) {
                selectButton.setVisibility(View.GONE); // Döljer knappen
            }
            if (tvTitle != null) {
                tvTitle.setText(selectedTrip);
            }
            if (tvStart != null) {
                tvStart.setText("Från: " + tripStart);
            }
            if (tvEnd != null) {
                tvEnd.setText("Till: " + tripEnd);
            }
            if (tvTime != null) {
                tvTime.setText("Tid: " + tripTime);
            }
        }

        // Knapp för att stänga dialogen
        Button closeButton = rootView.findViewById(R.id.btnCloseDialog);
        if (closeButton != null) {
            closeButton.setOnClickListener(v -> dismiss());
        }

        // Skapa en lista med demo-data för resealternativ
        List<ReseAlternativ> alternativ = new ArrayList<>();
        alternativ.add(new ReseAlternativ("Samåkning", "En användare åker bil kl 08:15 och erbjuder samåkning"));
        alternativ.add(new ReseAlternativ("Kollektivtrafik", "Tåg 11 till hållplats 3. Avgång 07.38"));
        alternativ.add(new ReseAlternativ("Kollektivtrafik", "Buss 76 till tunnelbana röda linjen. Avgång 08:12."));

        // Ställ in RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewAlternativ);
        ReseAlternativAdapter adapter = new ReseAlternativAdapter(alternativ);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }
}
