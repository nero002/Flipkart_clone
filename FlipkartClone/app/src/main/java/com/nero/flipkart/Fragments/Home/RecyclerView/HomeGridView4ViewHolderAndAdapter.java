package com.nero.flipkart.Fragments.Home.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nero.flipkart.Model.ModelGridView;
import com.nero.flipkart.R;

import java.util.ArrayList;

public class HomeGridView4ViewHolderAndAdapter extends RecyclerView.Adapter<HomeGridView4ViewHolderAndAdapter.HomeGridView4ViewHolder> {

    private ArrayList<ModelGridView> modelGridViewArrayList;


    public HomeGridView4ViewHolderAndAdapter(ArrayList<ModelGridView> modelGridViewArrayList) {
        this.modelGridViewArrayList = modelGridViewArrayList;
    }

    @NonNull
    @Override
    public HomeGridView4ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_four_products, parent, false);
        return new HomeGridView4ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeGridView4ViewHolder holder, int position) {
        ModelGridView modelGridView = modelGridViewArrayList.get(position);
        holder.setImage(modelGridView);
    }

    @Override
    public int getItemCount() {
        return modelGridViewArrayList.size();
    }

    //
    // ViewHolder
    //
    public class HomeGridView4ViewHolder extends RecyclerView.ViewHolder {
        private ImageView grid1;
        private TextView tvProductName, tvProductOffer;

        public HomeGridView4ViewHolder(@NonNull View itemView) {
            super(itemView);
            grid1 = itemView.findViewById(R.id.grid1);
            tvProductName = itemView.findViewById(R.id.tvproductName);
            tvProductOffer = itemView.findViewById(R.id.tv4Offer);

        }

        public void setImage(ModelGridView modelGridView) {
            grid1.setBackgroundResource(modelGridView.getImageView());
            tvProductOffer.setText(modelGridView.getTvProductOffer());
            tvProductName.setText(modelGridView.getTvProductName());


        }

    }
}


