package com.shop.nixsolution;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.shop.nixsolution.adapter.DataRecyclerAdapter;
import com.shop.nixsolution.productall.DatabaseHelper;
import com.shop.nixsolution.productall.Product;
import com.shop.nixsolution.productbuy.BuyProduct;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    DataRecyclerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Product> products2 = new ArrayList<>();

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

      /*  db.productDao().delete(new Product(1,"tomato"));
        db.productDao().delete(new Product(2,"tomato"));
        db.productDao().delete(new Product(3,"egor"));
        db.productDao().delete(new Product(5,"potato"));*/

        //////1 2 3 5
//        db.productDao().insert(new Product(1,"potato"));
        List<Product> products = db.productDao().getAllProducts();




        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataRecyclerAdapter(products);
        recyclerView.setAdapter(adapter);


     /*   String text = "";

        for (Product model : products) {
            if (model.isSelected()) {
                text = model.getName();
            }
        }

        System.out.println(text + "sdasdasd");
*/

        adapter.setOnItemClickListener(new DataRecyclerAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View v, int position){
                String name = products.get(position).name;
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

                Product m = products.get(position);
                addmassiv(m);

            }
        });




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), BuyProduct.class);
                intent.putExtra("my list", products2);
                System.out.println(products2);
                startActivity(intent);

            }
        });
    }

    public void addmassiv(Product product){


        products2.add(product);
        //System.out.println(products2);

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