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

    public interface ResaDialogListener {
        void onResaLagd(Resa nyResa);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_lagg_till_resa_dialog, null);

        EditText inputTitel = dialogView.findViewById(R.id.inputTitel);
        EditText inputStart = dialogView.findViewById(R.id.inputStart);
        EditText inputSlut = dialogView.findViewById(R.id.inputSlut);
        EditText inputTid = dialogView.findViewById(R.id.inputTid);

        return new AlertDialog.Builder(requireContext())
                .setTitle("Lägg till ny resa")
                .setView(dialogView)
                .setPositiveButton("Spara", (dialogInterface, i) -> {
                    String titel = inputTitel.getText().toString();
                    String start = inputStart.getText().toString();
                    String slut = inputSlut.getText().toString();
                    String tid = inputTid.getText().toString();

                    Resa nyResa = new Resa(titel, start, slut, tid);

                    if (getActivity() instanceof ResaDialogListener) {
                        ((ResaDialogListener) getActivity()).onResaLagd(nyResa);
                    }
                })
                .setNegativeButton("Avbryt", null)
                .create();
    }
}
