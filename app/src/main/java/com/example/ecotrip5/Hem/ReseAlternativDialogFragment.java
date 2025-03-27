package com.example.ecotrip5.Hem;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecotrip5.R;

public class ReseAlternativDialogFragment extends DialogFragment {

    public ReseAlternativDialogFragment() {
        // Tom konstruktor nödvändig
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sätt din fullskärmstema
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_MyApp_FullScreenDialog);
    }

    private static final String ARG_SELECTED_TRIP = "SELECTED_TRIP";
    // Metod för att skapa fragment-instans med argument
    public static ReseAlternativDialogFragment newInstance(String selectedTrip) {
        ReseAlternativDialogFragment fragment = new ReseAlternativDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SELECTED_TRIP, selectedTrip);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rese_alternativ_dialog, container, false);

        // Hämta argumentet här
        String selectedTrip = getArguments() != null ? getArguments().getString(ARG_SELECTED_TRIP) : "Ingen resa vald";

        View includedCard = rootView.findViewById(R.id.included_trip_card);
        TextView tvTitle = includedCard.findViewById(R.id.valdResaTitel);
        Button selectButton = includedCard.findViewById(R.id.btnSelectTrip);
        selectButton.setVisibility(View.GONE); // Döljer knappen

        if (tvTitle != null) {
            tvTitle.setText(selectedTrip);
        }


        // Knapp för att stänga dialogen
        Button closeButton = rootView.findViewById(R.id.btnCloseDialog);
        if (closeButton != null) {
            closeButton.setOnClickListener(v -> dismiss());
        }

        return rootView;
    }

    // Om du vill göra dialogen bokstavligen fullskärm utan marginaler
    // kan du även överraska onStart så här:
    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            // Sätt att fönstret ska fylla skärmen
            getDialog().getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
        }
    }
}
