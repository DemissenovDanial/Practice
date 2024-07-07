package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

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

        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();

        plantsList = new ArrayList<>();
        RealmResults<Plants> results = realm.where(Plants.class).findAll();
        plantsList.addAll(realm.copyFromRealm(results));

        plantsAdapter = new PlantsAdapter(this, plantsList);
        recyclerView.setAdapter(plantsAdapter);
    }

    private void addPlantToRealm(Plants plant) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(r -> {
            r.insert(plant);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Realm.getDefaultInstance().close();
    }
}
