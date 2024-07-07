package com.example.myapplication;

import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .modules(new MyRealmModule())
                .build();
        Realm.setDefaultConfiguration(config);
    }
}