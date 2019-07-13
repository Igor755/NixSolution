package com.shop.nixsolution.productall;

import android.arch.persistence.room.Database;

import android.arch.persistence.room.RoomDatabase;

@Database(entities = { Product.class }, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {

    public abstract ProductDao productDao();

}