package com.nero.flipkart.Fragments.NavigationDrawer.FlipkartPlusZone.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nero.flipkart.R;

import java.util.List;

public class FlipkartPlusAdapter extends RecyclerView.Adapter<FlipkartplusViewHolder> {

    private List<FlipkartPlusModel> flipkartPlusModelList;

    public FlipkartPlusAdapter(List<FlipkartPlusModel> flipkartPlusModelList) {
        this.flipkartPlusModelList = flipkartPlusModelList;
    }

    @NonNull
    @Override
    public FlipkartplusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flipkart_plus, parent, false);
        return new FlipkartplusViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FlipkartplusViewHolder holder, int position) {
        FlipkartPlusModel flipkartPlusModel = flipkartPlusModelList.get(position);
        holder.setData(flipkartPlusModel);
    }

    @Override
    public int getItemCount() {
        return flipkartPlusModelList.size();
    }
}
