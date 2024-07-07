package com.example.myapplication;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class Plants extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    private String description;
    private int imageResource;

    public Plants() {
    }

    public Plants(String name, String description, int imageResource) {
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
