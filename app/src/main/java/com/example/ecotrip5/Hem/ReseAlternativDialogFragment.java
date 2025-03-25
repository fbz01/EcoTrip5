package com.example.ecotrip5.Hem;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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


    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {

        // Blås upp layouten för resealternativ
        View rootView = inflater.inflate(R.layout.fragment_rese_alternativ_dialog, container, false);

        // Exempel: hämta en knapp i layouten för att stänga dialogen
        Button closeButton = rootView.findViewById(R.id.btnCloseDialog);
        if (closeButton != null) {
            closeButton.setOnClickListener(v -> dismiss()); // stänger dialogen
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
