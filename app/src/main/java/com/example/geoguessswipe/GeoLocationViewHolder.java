package com.example.geoguessswipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GeoLocationViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public ImageView image;
    public View view;

    public GeoLocationViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.geoImageView);
        view = itemView;
    }
}
