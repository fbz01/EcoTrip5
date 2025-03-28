package com.example.ecotrip5.Tips;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecotrip5.R;

import java.util.List;


public class StopAdapter extends RecyclerView.Adapter<StopAdapter.StopViewHolder> {

    private List<StopLocation> stopList;

    public StopAdapter(List<StopLocation> stopList) {
        this.stopList = stopList;
    }

    @NonNull
    @Override
    public StopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stop, parent, false);
        return new StopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StopViewHolder holder, int position) {
        StopLocation stop = stopList.get(position);
        holder.name.setText(stop.getName());
        holder.distance.setText("Avstånd: " + (int) stop.getDist() + " m");
    }

    @Override
    public int getItemCount() {
        return stopList.size();
    }

    public static class StopViewHolder extends RecyclerView.ViewHolder {
        TextView name, distance;

        public StopViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.stopName);
            distance = itemView.findViewById(R.id.stopDistance);
        }
    }
}




