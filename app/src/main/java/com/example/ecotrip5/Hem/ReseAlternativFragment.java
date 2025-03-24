package com.example.ecotrip5.Hem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecotrip5.R;


public class ReseAlternativFragment extends Fragment {

    public ReseAlternativFragment() {
        // Tom konstruktor nödvändig
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Blås upp fragmentets layout
        return inflater.inflate(R.layout.fragment_rese_alternativ, container, false);
    }
}
