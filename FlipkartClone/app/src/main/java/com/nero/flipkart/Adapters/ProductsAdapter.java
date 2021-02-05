package com.nero.flipkart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nero.flipkart.Interface.OnProductItemClickListener;
import com.nero.flipkart.Model.ProductModel;
import com.nero.flipkart.R;
import com.nero.flipkart.ViewHolders.ProductViewHolder;

import java.util.List;


public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<ProductModel> modelList;
    private OnProductItemClickListener mListener;

    public void setOnClickItemListener(OnProductItemClickListener listener){
        this.mListener = listener;
    }

    public ProductsAdapter(List<ProductModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductModel productModel = modelList.get(position);
        holder.setData(productModel, mListener);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void updateAdapter(List<ProductModel> list){
        this.modelList = list;
        notifyDataSetChanged();
    }
}
