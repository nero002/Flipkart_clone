package com.nero.flipkart.Fragments.Home.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.nero.flipkart.Interface.OnitemClickListener;
import com.nero.flipkart.R;

import java.util.ArrayList;

public class HomeAllCategoriesViewHolderAdapter extends RecyclerView.Adapter<HomeAllCategoriesViewHolderAdapter.HomeAllCategoriesViewHolder> {
    private ArrayList<Integer> imagelist;
    private OnitemClickListener listener;

    public HomeAllCategoriesViewHolderAdapter(ArrayList<Integer> imagelist, OnitemClickListener listener) {
        this.imagelist = imagelist;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allcatogories_home_item, parent, false);
        return new HomeAllCategoriesViewHolder(view,listener);
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

    //
    //VIEWHOLDER
    //
    class HomeAllCategoriesViewHolder extends RecyclerView.ViewHolder {
        private OnitemClickListener listener;
        private ImageView mImageViewrr;

        public HomeAllCategoriesViewHolder(@NonNull View itemView,OnitemClickListener listener) {
            super(itemView);
            this.listener = listener;
            mImageViewrr = itemView.findViewById(R.id.ivHomeRr);
        }

        public void setImage(int id) {
            mImageViewrr.setBackgroundResource(id);

            mImageViewrr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });

        }
    }
}
