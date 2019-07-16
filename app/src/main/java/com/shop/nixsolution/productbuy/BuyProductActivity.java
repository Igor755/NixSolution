package com.shop.nixsolution.productbuy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shop.nixsolution.R;
import com.shop.nixsolution.adapter.DataRecyclerAdapter;
import com.shop.nixsolution.productall.Product;

import java.util.ArrayList;
import java.util.List;

public class BuyProductActivity extends AppCompatActivity {


    DataRecyclerAdapter adapter;
    RecyclerView recyclerView21;
    ArrayList<Product> myList =  new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);


        Bundle extras = getIntent().getExtras();
        myList = extras.getParcelableArrayList("act2_products");

        System.out.println(extras);
        System.out.println(myList);

        recyclerView21 = findViewById(R.id.recyclerView_buy);
        recyclerView21.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataRecyclerAdapter(myList);
        recyclerView21.setAdapter(adapter);


        /*adapter.setOnItemClickListener(new DataRecyclerAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View v, int position){

            }
        });
*/


    }

}