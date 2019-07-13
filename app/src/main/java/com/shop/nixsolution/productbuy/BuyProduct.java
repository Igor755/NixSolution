package com.shop.nixsolution.productbuy;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.shop.nixsolution.R;

public class BuyProduct extends AppCompatActivity {


    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);


    }

}