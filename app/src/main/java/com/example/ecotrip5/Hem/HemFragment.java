package com.example.ecotrip5.Hem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ecotrip5.R;


public class HemFragment extends Fragment {

    public HemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hem, container, false);

        // Hitta din knapp i rootView
        Button loginButton = rootView.findViewById(R.id.hittaAlternativKnapp);

        // Sätt en klicklyssnare
        loginButton.setOnClickListener(view -> {

            // Byt fragment i samma aktivitet (om du kör Single-Activity) med transaction
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new ReseAlternativFragment())
                    .commit();
        });
        return rootView;
    }
}