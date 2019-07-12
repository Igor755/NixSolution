package com.shop.nixsolution.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    List<Product> getAll();

    /*@Query("SELECT * FROM product WHERE id = :id")
    Product getById(String id);*/

    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}
