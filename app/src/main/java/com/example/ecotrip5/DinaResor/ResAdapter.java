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
    public void onBindViewHolder(TripViewHolder holder, int position) {
        Resa resa = resaList.get(position);
        holder.valdResaTitel.setText(resa.getTitle());
        holder.startplats.setText("Från: " + resa.getStart());
        holder.slutplats.setText("Till: " + resa.getEnd());
        holder.distans.setText("Distans: " + resa.getDistance());

        holder.btnSelectTrip.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, HemActivity.class);
            intent.putExtra("SELECTED_TRIP", resa.getTitle());
            intent.putExtra("TRIP_START", resa.getStart());
            intent.putExtra("TRIP_END", resa.getEnd());
            intent.putExtra("TRIP_DISTANCE", resa.getDistance());
            // Du kan lägga till mer info här
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
        TextView startplats;
        TextView slutplats;
        TextView distans;
        Button btnSelectTrip;

        public TripViewHolder(View itemView) {
            super(itemView);
            valdResaTitel = itemView.findViewById(R.id.valdResaTitel);
            startplats = itemView.findViewById(R.id.startplats);
            slutplats = itemView.findViewById(R.id.slutplats);
            distans = itemView.findViewById(R.id.distans);
            btnSelectTrip = itemView.findViewById(R.id.btnSelectTrip);
        }
    }
}



