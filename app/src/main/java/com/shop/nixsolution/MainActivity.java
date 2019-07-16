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
import android.widget.Toast;

import com.shop.nixsolution.adapter.DataRecyclerAdapter;
import com.shop.nixsolution.productall.DatabaseHelper;
import com.shop.nixsolution.productall.Product;
import com.shop.nixsolution.productbuy.BuyProductActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    DataRecyclerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Product> act2_products = new ArrayList<>();

    static List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHelper db = Room.databaseBuilder(getApplicationContext(), DatabaseHelper.class, "production")
                .allowMainThreadQueries()
                .build();



        /*db.productDao().insert(new Product(1,"tomato"));
        db.productDao().insert(new Product(2,"tomato"));
        db.productDao().insert(new Product(3,"egg"));*/


        //db.productDao().insert(new Product(1,"potato"));
        products = db.productDao().getAllProducts();


        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new DataRecyclerAdapter(products);
        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new DataRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String name = products.get(position).name;
                Toast.makeText(MainActivity.this, "add in recycler", Toast.LENGTH_SHORT).show();

                Product m = products.get(position);
               // addarray(m);

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), BuyProductActivity.class);
                intent.putExtra("act2_products", act2_products);
                System.out.println(intent);
                startActivity(intent);

            }
        });
    }

   /* public void addarray(Product product) {


        act2_products.add(product);

    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                ////////////

                for (Product model : products) {
                    if (model.isSelected())
                    {
                        act2_products.add(model);
                        model.setSelected(false);
                    }
                    model.setSelected(false);
                }
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