package com.example.ecotrip5.DinaResor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ecotrip5.Hem.HemActivity;
import com.example.ecotrip5.R;

import java.util.List;
// -------------------------------------------------------------
// Denna RecyclerView-adapter har utvecklats med stöd av ChatGPT (OpenAI).
// ChatGPT användes för att:
// – Skicka vidare valt resa-objekt till HemActivity via Intent
// -------------------------------------------------------------

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.TripViewHolder> {
    // Lista med resor som ska visas i recyclerview
    private List<Resa> resaList;

    // Konstruktor för adaptern med en lista av resor
    public ResAdapter(List<Resa> resaList) {
        this.resaList = resaList;
    }


    // Skapa en ny viewholder
    @Override
    public TripViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        // Blås upp layouten för en item (item_resa.xml)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_resa, parent, false);
        return new TripViewHolder(view);
    }

    // Binder data från ett resa-objekt till en viewholder
    @Override
    public void onBindViewHolder(TripViewHolder holder, int position) {
        // Hämta resan från positionen
        Resa resa = resaList.get(position);
        // Sätt textview baserat på resans data
        holder.valdResaTitel.setText(resa.getTitle());
        holder.startplats.setText("Från: " + resa.getStart());
        holder.slutplats.setText("Till: " + resa.getEnd());
        holder.distans.setText("Tid: " + resa.getTid());

        // Sätt klick-lyssnare på knappen för att välja resan
        holder.btnSelectTrip.setOnClickListener(v -> {
            Context context = v.getContext();
            // Intent för att starta HemActivity
            Intent intent = new Intent(context, HemActivity.class);
            // Skicka med resans information till HemActivity
            intent.putExtra("SELECTED_TRIP", resa.getTitle());
            intent.putExtra("TRIP_START", resa.getStart());
            intent.putExtra("TRIP_END", resa.getEnd());
            intent.putExtra("TRIP_TIME", resa.getTid());
            // Starta HemActivity
            context.startActivity(intent);
        });
    }

    // Funktion för antal resor i listan
    @Override
    public int getItemCount() {
        return resaList.size();
    }

    // ViewHolder med referenserna till vyer i en item layout
    public static class TripViewHolder extends RecyclerView.ViewHolder {
        TextView valdResaTitel;
        TextView startplats;
        TextView slutplats;
        TextView distans;
        Button btnSelectTrip;

        // Konstruktor för vy referenserna
        public TripViewHolder(View itemView) {
            super(itemView);
            valdResaTitel = itemView.findViewById(R.id.valdResaTitel);
            startplats = itemView.findViewById(R.id.startplats);
            slutplats = itemView.findViewById(R.id.slutplats);
            distans = itemView.findViewById(R.id.tid);
            btnSelectTrip = itemView.findViewById(R.id.btnSelectTrip);
        }
    }
}



