package com.nero.flipkart.Fragments.Home.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nero.flipkart.R;

import java.util.ArrayList;

public class HomeHorizontalStatic3ViewHolder extends RecyclerView.Adapter<HomeHorizontalStatic3ViewHolder.HomeHorizontalViewHolder> {


    private ArrayList<Integer> imagelist;

    public HomeHorizontalStatic3ViewHolder(ArrayList<Integer> imagelist) {
        this.imagelist = imagelist;
    }

    @NonNull
    @Override
    public HomeHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerviewhorizontalview3position, parent, false);
        return new HomeHorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHorizontalViewHolder holder, int position) {
        int id = imagelist.get(position);
        holder.setImage(id);
    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    public class HomeHorizontalViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageHorizontal1;

        public HomeHorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageHorizontal1 = itemView.findViewById(R.id.imageHorizontal1);


        }

        public void setImage(int id) {
            imageHorizontal1.setBackgroundResource(id);

        }
    }
}





