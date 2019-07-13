package com.shop.nixsolution;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.shop.nixsolution.adapter.DataRecyclerAdapter;
import com.shop.nixsolution.productall.DatabaseHelper;
import com.shop.nixsolution.productall.Product;
import com.shop.nixsolution.productbuy.BuyProduct;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




      /*  for(int i = 0; i <10; i++){

            product = new Product(i,"vv");
            products.add(product);

        }*/

        DatabaseHelper db = Room.databaseBuilder(getApplicationContext(),DatabaseHelper.class,"production")
                .allowMainThreadQueries()
                .build();


     /*   db.productDao().insert(new Product(1,"tomato"));
        db.productDao().insert(new Product(2,"potato"));*/

        List<Product> products = db.productDao().getAllProducts();




        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataRecyclerAdapter(products);
        recyclerView.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), BuyProduct.class);
                startActivity(intent);

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.action_add:
                ////////////

                return true;
            case R.id.select_all:
                ////////////

                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_button, menu);
        return true;
    }
}