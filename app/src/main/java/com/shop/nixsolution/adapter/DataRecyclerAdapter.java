package com.shop.nixsolution.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.shop.nixsolution.R;
import com.shop.nixsolution.productall.Product;

import java.util.List;


public class DataRecyclerAdapter extends RecyclerView.Adapter<DataRecyclerAdapter.ViewHolder> {

    List<Product> products;


    public DataRecyclerAdapter(List<Product> products) {
        this.products = products;
    }


    @Override
    public DataRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_item_recycler, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataRecyclerAdapter.ViewHolder viewHolder, int i) {

        Product my_product = this.products.get(i);
        viewHolder.textView.setText(my_product.getName());
        viewHolder.checkBox.setChecked(false);


    }

    @Override
    public int getItemCount() {
        return products.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.name);
            checkBox = itemView.findViewById(R.id.checkBox);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                }

            });
        }
    }
}
