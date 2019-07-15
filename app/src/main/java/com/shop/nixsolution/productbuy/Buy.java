package com.shop.nixsolution.productbuy;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;


public class Buy  {


    private int id;

    public String name;
/*
    @ColumnInfo(name = "date")
    public String date;*/

    public Buy(int id, String name) {
        this.id = id;
        this.name = name;
       // this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }*/
}
