package com.shop.nixsolution.productbuy;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shop.nixsolution.R;
import com.shop.nixsolution.adapter.DataRecyclerAdapter;
import com.shop.nixsolution.productall.Product;

import java.util.ArrayList;

public class BuyProduct extends AppCompatActivity {


    BuyAdapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);



        ArrayList<Buy> myList = (ArrayList<Buy>) getIntent().getParcelableExtra("mylist");




        System.out.println(myList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BuyAdapter(myList);
        recyclerView.setAdapter(adapter);


    }

}