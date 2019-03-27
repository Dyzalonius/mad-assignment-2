package com.example.geoguessswipe;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

public class GeoLocationItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    GeoLocationAdapter adapter;
    Context context;

    public GeoLocationItemTouchHelper(GeoLocationAdapter adapter, Context context) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
        this.context = context;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int index = viewHolder.getAdapterPosition();
        GeoLocation item = adapter.geoLocations.get(index);
        adapter.geoLocations.remove(index);
        adapter.notifyItemRemoved(index);

        if(i == ItemTouchHelper.LEFT && item.isInEurope() || i == ItemTouchHelper.RIGHT && !item.isInEurope()) {
            Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "False..", Toast.LENGTH_SHORT).show();
        }
    }
}
