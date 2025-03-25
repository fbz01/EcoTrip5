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

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    private List<Trip> tripList;

    public TripAdapter(List<Trip> tripList) {
        this.tripList = tripList;
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
        Trip trip = tripList.get(position);
        holder.tvTripTitle.setText(trip.getTitle());

        // Klick på "Välj Resa"-knappen
        holder.btnSelectTrip.setOnClickListener(v -> {
            // Starta HemActivity (eller vad du nu vill)
            Context context = v.getContext(); // ger dig en context
            Intent intent = new Intent(context, HemActivity.class);
            context.startActivity(intent);

            // Om du vill stänga nuvarande aktivitet (om du är i en Activity),
            // kan du göra:
            // ((Activity) context).finish();
        });
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    // ViewHolder för en item
    public static class TripViewHolder extends RecyclerView.ViewHolder {
        TextView tvTripTitle;
        Button btnSelectTrip;

        public TripViewHolder( View itemView) {
            super(itemView);
            tvTripTitle = itemView.findViewById(R.id.tvTripTitle);
            btnSelectTrip = itemView.findViewById(R.id.btnSelectTrip);
        }
    }
}



