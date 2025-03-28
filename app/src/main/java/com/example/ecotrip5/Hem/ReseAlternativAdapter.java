package com.example.ecotrip5.Hem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecotrip5.R;

import java.util.List;

public class ReseAlternativAdapter extends RecyclerView.Adapter<ReseAlternativAdapter.ViewHolder> {
    private List<ReseAlternativ> lista;

    public ReseAlternativAdapter(List<ReseAlternativ> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rese_alternativ, parent, false);
        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ReseAlternativ alternativ = lista.get(position);
        holder.typ.setText(alternativ.getTyp());
        holder.beskrivning.setText(alternativ.getBeskrivning());

        ImageView icon = holder.icon;
        CardView card = holder.cardRoot;
        String typ = alternativ.getTyp();
        switch (typ) {
            case "Samåkning":
                icon.setImageResource(R.drawable.baseline_directions_car_24);
                card.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green_700));

                break;
            case "Kollektivtrafik":
                icon.setImageResource(R.drawable.baseline_directions_bus_24);
                card.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.blue_700));

                break;
        }

        // 🎬 Startposition: utanför till höger, liten skala, osynlig
        holder.itemView.setTranslationX(700f);
        holder.itemView.setScaleX(0.8f);
        holder.itemView.setScaleY(0.8f);
        holder.itemView.setAlpha(0f);

        // 🎉 Animera in
        holder.itemView.animate()
                .translationX(0f)
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(400)
                .setStartDelay(position * 50L)
                .start();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView typ, beskrivning;
        ImageView icon;
        CardView cardRoot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            typ = itemView.findViewById(R.id.typText);
            beskrivning = itemView.findViewById(R.id.beskrivningText);
            icon = itemView.findViewById(R.id.icon);
            cardRoot = itemView.findViewById(R.id.cardRoot);
        }
    }
}

