package com.nero.flipkart.ViewHolders;

import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nero.flipkart.Adapters.ProductsAdapter;
import com.nero.flipkart.Interface.OnProductItemClickListener;
import com.nero.flipkart.Model.ProductModel;
import com.nero.flipkart.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName, tvPrice, tvDesc;
    private ImageView imgProduct;
    private CardView cardView;
    private OnProductItemClickListener listener;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null){
                    listener.OnItemClick(position);
                }
            }
        });
    }

    private void initView(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        tvDesc = itemView.findViewById(R.id.tvDescription);
        imgProduct = itemView.findViewById(R.id.imgProduct);
        cardView = itemView.findViewById(R.id.cvCard);
    }

    public void setData(ProductModel productModel, OnProductItemClickListener mListener){
        tvName.setText(productModel.getTitle());
        tvPrice.setText("Rs." + productModel.getPrice());
        tvDesc.setText(productModel.getDescription());
        Glide.with(imgProduct).load(productModel.getImage()).into(imgProduct);
        listener = mListener;
    }
}
