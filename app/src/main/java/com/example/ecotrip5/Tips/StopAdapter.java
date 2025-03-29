package com.example.ecotrip5.Tips;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ecotrip5.R;

import java.util.List;


public class StopAdapter extends RecyclerView.Adapter<StopAdapter.StopViewHolder> {

    // Lista med StopLocation-objekt för hållplatser som ska visas i RecyclerView
    private List<StopLocation> stopList;

    // Konstruktor för adaptern med listan som ska visas
    public StopAdapter(List<StopLocation> stopList) {
        this.stopList = stopList;
    }

    // Skapa ny viewholder och blåsa upp layouten för varje hållplats
    @Override
    public StopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflatera layouten item_stop för varje hållplats
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stop, parent, false);
        return new StopViewHolder(view);
    }

    // Binder data från stoplocation objekt till viewholder
    @Override
    public void onBindViewHolder(StopViewHolder holder, int position) {
        // Hämta hållplatsen på positionen
        StopLocation stop = stopList.get(position);
        // Sätt namnet på hållplatsen i textView
        holder.name.setText(stop.getName());
        // Sätt avståndet till hållplatsen med textView
        holder.distance.setText("Avstånd: " + (int) stop.getDist() + " m");
    }

    // Returnerar antalet hållplatser i listan
    @Override
    public int getItemCount() {
        return stopList.size();
    }

    // Viewholder klass för referenser till vyerna för varje hållplats
    public static class StopViewHolder extends RecyclerView.ViewHolder {
        TextView name, distance;

        // Konstruktor som initierar vyerna
        public StopViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.stopName);
            distance = itemView.findViewById(R.id.stopDistance);
        }
    }
}



