package com.nero.flipkart.Fragments.NavigationDrawer.FlipkartPlusZone.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nero.flipkart.R;

public class FlipkartplusViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvFlipkartPlus;
    private LinearLayout mLinearLayoutFlipkartPlus;

    public FlipkartplusViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvFlipkartPlus = itemView.findViewById(R.id.ivFlipkartPlus);
        mLinearLayoutFlipkartPlus = itemView.findViewById(R.id.linearLayoutFlipkartPlus);

    }


    public void setData(FlipkartPlusModel flipkartPlusModel) {
        mIvFlipkartPlus.setImageResource(flipkartPlusModel.getImageview());

        mLinearLayoutFlipkartPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
