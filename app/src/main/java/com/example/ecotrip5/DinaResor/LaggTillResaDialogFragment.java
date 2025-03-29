package com.example.ecotrip5.DinaResor;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.ecotrip5.R;

public class LaggTillResaDialogFragment extends DialogFragment {

    // interface för metod att meddela när en ny resa har lagts till
    public interface ResaDialogListener {
        void onResaLagd(Resa nyResa);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Blås upp layouten för dialogen
        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_lagg_till_resa_dialog, null);

        // Hämta referenser för EditText i dialogen
        EditText inputTitel = dialogView.findViewById(R.id.inputTitel);
        EditText inputStart = dialogView.findViewById(R.id.inputStart);
        EditText inputSlut = dialogView.findViewById(R.id.inputSlut);
        EditText inputTid = dialogView.findViewById(R.id.inputTid);

        // Returnera alert dialog med anpassad layout
        return new AlertDialog.Builder(requireContext())
                // Sätter titel på dialogen
                .setTitle("Lägg till ny resa")
                .setView(dialogView)
                // Knapp för att spara
                .setPositiveButton("Spara", (dialogInterface, i) -> {
                    // Hämta textinnehållet från EditText
                    String titel = inputTitel.getText().toString();
                    String start = inputStart.getText().toString();
                    String slut = inputSlut.getText().toString();
                    String tid = inputTid.getText().toString();

                    // Skapa ett nytt resa-objekt med informationen
                    Resa nyResa = new Resa(titel, start, slut, tid);

                    if (getActivity() instanceof ResaDialogListener) {
                        // Anropa metoden för att meddela att en resa har lagts till
                        ((ResaDialogListener) getActivity()).onResaLagd(nyResa);
                    }
                })
                // Knapp för att avbryta
                .setNegativeButton("Avbryt", null)
                .create();
    }
}
