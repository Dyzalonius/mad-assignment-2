package com.example.geoguessswipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GeoLocationAdapter extends RecyclerView.Adapter<GeoLocationViewHolder> {

    private Context context;
    public List<GeoLocation> geoLocations;

    public GeoLocationAdapter(Context context, List<GeoLocation> geoLocations) {
        this.context = context;
        this.geoLocations = geoLocations;
    }

    @NonNull
    @Override
    public GeoLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell, parent, false);
        return new GeoLocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GeoLocationViewHolder holder, final int position) {
        // Gets a single item in the list from its position
        final GeoLocation geoLocation = geoLocations.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.image.setImageResource(geoLocation.getImage());
    }

    @Override
    public int getItemCount() {
        return geoLocations.size();
    }
}
