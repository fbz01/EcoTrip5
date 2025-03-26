package com.example.ecotrip5.DinaResor;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ecotrip5.Hem.HemActivity;
import com.example.ecotrip5.R;

import java.util.List;

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.TripViewHolder> {

    private List<Resa> resaList;

    public ResAdapter(List<Resa> resaList) {
        this.resaList = resaList;
    }


    @Override
    public TripViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        // Blås upp layouten för en item (item_resa.xml)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_resa, parent, false);
        return new TripViewHolder(view);
    }

    @Override
    public void onBindViewHolder( TripViewHolder holder, int position) {
        Resa resa = resaList.get(position);
        Log.d("ResAdapter", "Binding trip: " + resa.getTitle());
        holder.valdResaTitel.setText(resa.getTitle());

        holder.btnSelectTrip.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, HemActivity.class);
            intent.putExtra("SELECTED_TRIP", resa.getTitle());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return resaList.size();
    }

    // ViewHolder för en item
    public static class TripViewHolder extends RecyclerView.ViewHolder {
        TextView valdResaTitel;
        Button btnSelectTrip;

        public TripViewHolder( View itemView) {
            super(itemView);
            valdResaTitel = itemView.findViewById(R.id.valdResaTitel);
            btnSelectTrip = itemView.findViewById(R.id.btnSelectTrip);
        }
    }
}



