package com.shop.nixsolution.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shop.nixsolution.R;
import com.shop.nixsolution.productall.Product;

import java.util.List;


public class DataRecyclerAdapter extends RecyclerView.Adapter<DataRecyclerAdapter.DataViewHolder> {

    List<Product> products;

    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public DataRecyclerAdapter(List<Product> products) {
        this.products = products;
    }


    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_item_recycler, viewGroup, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder viewHolder, int i) {

        Product my_product = this.products.get(i);
        viewHolder.textView.setText(my_product.getName());
        viewHolder.view.setBackgroundColor(my_product.isSelected() ? Color.CYAN : Color.WHITE);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_product.setSelected(!my_product.isSelected());
                viewHolder.view.setBackgroundColor(my_product.isSelected() ? Color.CYAN : Color.WHITE);

            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        private View view;

        public DataViewHolder(View itemView) {
            super(itemView);

            view = itemView;
            textView = itemView.findViewById(R.id.name);

            itemView.setOnClickListener((View v) -> {

                    if (DataRecyclerAdapter.listener != null) {
                        DataRecyclerAdapter.listener.onItemClick(itemView, getLayoutPosition());
                    }
                });


        }


    }
}
