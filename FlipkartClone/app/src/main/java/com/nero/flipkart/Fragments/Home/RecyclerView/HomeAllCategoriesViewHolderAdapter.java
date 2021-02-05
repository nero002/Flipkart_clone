package com.nero.flipkart.Fragments.Home.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.nero.flipkart.R;

import java.util.ArrayList;

public class HomeAllCategoriesViewHolderAdapter extends RecyclerView.Adapter<HomeAllCategoriesViewHolderAdapter.HomeAllCategoriesViewHolder> {
    private ArrayList<Integer> imagelist;

    public HomeAllCategoriesViewHolderAdapter(ArrayList<Integer> imagelist) {
        this.imagelist = imagelist;
    }

    @NonNull
    @Override
    public HomeAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allcatogories_home_item, parent, false);
        return new HomeAllCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAllCategoriesViewHolder holder, int position) {
        int id = imagelist.get(position);
        holder.setImage(id);

    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    class HomeAllCategoriesViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageViewrr;

        public HomeAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewrr = itemView.findViewById(R.id.ivHomeRr);
        }

        public void setImage(int id) {
            mImageViewrr.setBackgroundResource(id);
        }
    }
}
