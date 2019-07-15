package com.shop.nixsolution.productbuy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shop.nixsolution.R;
import com.shop.nixsolution.productall.Product;

import java.util.ArrayList;
import java.util.List;


public class BuyAdapter extends RecyclerView.Adapter<BuyAdapter.BuyViewHolder> {


    List<Buy> buys;

    public BuyAdapter(List<Buy> buys) {
        this.buys = buys;
    }


    @NonNull
    @Override
    public BuyAdapter.BuyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_item_recycler, viewGroup, false);
        return new BuyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyAdapter.BuyViewHolder buyViewHolder, int i) {

        Buy my_product = this.buys.get(i);
        buyViewHolder.textView.setText(my_product.getName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BuyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        // private View view;

        public BuyViewHolder(View itemView) {
            super(itemView);

            //view = itemView;
            textView = itemView.findViewById(R.id.name);

        }


    }
}
