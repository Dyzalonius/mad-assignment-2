package com.example.geoguessswipe;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    private List<GeoLocation> geoLocationList;
    private RecyclerView recyclerView;
    private GestureDetector gestureDetector;
    private GeoLocationAdapter geoLocationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geoLocationList = new ArrayList<GeoLocation>() {{
            add(new GeoLocation("Denmark", true, R.drawable.img1_yes_denmark));
            add(new GeoLocation("Canada", false, R.drawable.img2_no_canada));
            add(new GeoLocation("Bangladesh", false, R.drawable.img3_no_bangladesh));
            add(new GeoLocation("Kazachstan", true, R.drawable.img4_yes_kazachstan));
            add(new GeoLocation("Colombia", false, R.drawable.img5_no_colombia));
            add(new GeoLocation("Poland", true, R.drawable.img6_yes_poland));
            add(new GeoLocation("Malta", true, R.drawable.img7_yes_malta));
            add(new GeoLocation("Thailand", false, R.drawable.img8_no_thailand));
        }};

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        geoLocationAdapter = new GeoLocationAdapter(this, geoLocationList);
        recyclerView.setAdapter(geoLocationAdapter);

        // add click functionality to recycler view
        recyclerView.addOnItemTouchListener(this);

        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        GeoLocationItemTouchHelper thing = new GeoLocationItemTouchHelper(geoLocationAdapter, this);
        new ItemTouchHelper(thing).attachToRecyclerView(recyclerView);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        int mAdapterPosition = rv.getChildAdapterPosition(child);
        if (child != null && gestureDetector.onTouchEvent(e)) {
            Toast.makeText(this, geoLocationList.get(mAdapterPosition).getName(), Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
