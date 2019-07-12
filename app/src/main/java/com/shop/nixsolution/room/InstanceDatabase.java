package com.shop.nixsolution.room;

import android.app.Application;
import android.arch.persistence.room.Room;

public class InstanceDatabase extends Application {

    private static InstanceDatabase instance;
    private DatabaseHelper db;

    public static InstanceDatabase getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db = Room.databaseBuilder(getApplicationContext(), DatabaseHelper.class, "data-database")
                .allowMainThreadQueries()
                .build();
    }

    public DatabaseHelper getDatabaseInstance() {
        return db;
    }
}