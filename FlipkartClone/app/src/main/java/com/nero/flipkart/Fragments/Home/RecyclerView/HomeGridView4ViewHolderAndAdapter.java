package com.nero.flipkart.Fragments.Home.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nero.flipkart.R;

import java.util.ArrayList;

public class HomeGridView4ViewHolderAndAdapter extends RecyclerView.Adapter<HomeGridView4ViewHolderAndAdapter.HomeGridView4ViewHolder> {

    private ArrayList<Integer> imagelist;

    public HomeGridView4ViewHolderAndAdapter(ArrayList<Integer> imagelist) {
        this.imagelist = imagelist;
    }

    @NonNull
    @Override
    public HomeGridView4ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_four_products, parent, false);
        return new HomeGridView4ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeGridView4ViewHolder holder, int position) {
        int id = imagelist.get(position);
        holder.setImage(id);
    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    public class HomeGridView4ViewHolder extends RecyclerView.ViewHolder {
        private ImageView grid1;

        public HomeGridView4ViewHolder(@NonNull View itemView) {
            super(itemView);
            grid1 = itemView.findViewById(R.id.grid1);

        }

        public void setImage(int id) {
            grid1.setBackgroundResource(id);


        }
    }
}
