package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlantsAdapter plantsAdapter;
    private ArrayList<Plants> plantsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        if (recyclerView == null) {
            throw new NullPointerException("RecyclerView is null. Check your layout.");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        plantsList = new ArrayList<>();
        plantsAdapter = new PlantsAdapter(plantsList);
        recyclerView.setAdapter(plantsAdapter);
    }
}
