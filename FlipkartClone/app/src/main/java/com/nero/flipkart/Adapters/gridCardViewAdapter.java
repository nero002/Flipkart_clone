package com.nero.flipkart.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class gridCardViewAdapter extends RecyclerView.Adapter<gridCardViewAdapter.gridViewHolder> {
    @NonNull
    @Override
    public gridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull gridViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class gridViewHolder extends RecyclerView.ViewHolder {
        public gridViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View itemView) {


        }
    }
}
