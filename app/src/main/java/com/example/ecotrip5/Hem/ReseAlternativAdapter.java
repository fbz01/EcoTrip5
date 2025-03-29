package com.example.ecotrip5.Hem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecotrip5.R;

import java.util.List;

public class ReseAlternativAdapter extends RecyclerView.Adapter<ReseAlternativAdapter.ViewHolder> {
    // Lista med ReseAlternativ
    private List<ReseAlternativ> lista;

    // Konstruktor för adaptern med en lista
    public ReseAlternativAdapter(List<ReseAlternativ> lista) {
        this.lista = lista;
    }

    // Skapa viewholder
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rese_alternativ, parent, false);
        return new ViewHolder(v);
    }

    // Binder listan till viewholder
    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        // Hämta resealternativet på positionen
        ReseAlternativ alternativ = lista.get(position);
        // Sätt texten typ och beskrivning
        holder.typ.setText(alternativ.getTyp());
        holder.beskrivning.setText(alternativ.getBeskrivning());

        // Referenser till ikoner och kortet för anpassning
        ImageView icon = holder.icon;
        CardView card = holder.cardRoot;
        String typ = alternativ.getTyp();

        // Anpassar ikon och bakgrundsfärg beroende på vilken typ resealternativet är
        switch (typ) {
            case "Samåkning":
                // Om det är samåkning, sätt en bil ikon och färgen grön
                icon.setImageResource(R.drawable.baseline_directions_car_24);
                card.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green_700));
                break;
            case "Kollektivtrafik":
                // Om det är kollektivtrafik, sätt en buss ikon och färgen blå
                icon.setImageResource(R.drawable.baseline_directions_bus_24);
                card.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.blue_700));
                break;
        }

        // Animation för korten, starta utanför skärmen och flyttas in
        holder.itemView.setTranslationX(700f);
        holder.itemView.setScaleX(0.8f);
        holder.itemView.setScaleY(0.8f);
        holder.itemView.setAlpha(0f);

        holder.itemView.animate()
                .translationX(0f)
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(400)
                .setStartDelay(position * 50L)
                .start();
    }

    // Returnerar antalet resealternativ i listan
    @Override
    public int getItemCount() {
        return lista.size();
    }

    // Viewholder klass med referenser för enskilt resealternativ
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView typ, beskrivning;
        ImageView icon;
        CardView cardRoot;

        // Konstruktor som initierar vy från layout
        public ViewHolder( View itemView) {
            super(itemView);
            typ = itemView.findViewById(R.id.typText);
            beskrivning = itemView.findViewById(R.id.beskrivningText);
            icon = itemView.findViewById(R.id.icon);
            cardRoot = itemView.findViewById(R.id.cardRoot);
        }
    }
}

