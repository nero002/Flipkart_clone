package com.nero.flipkart.Fragments.Home.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nero.flipkart.POJO.MobileModel;
import com.nero.flipkart.POJO.MobilesModel;
import com.nero.flipkart.R;

import java.util.ArrayList;
import java.util.List;

public class HomeHorizontalStatic3ViewHolder extends RecyclerView.Adapter<HomeHorizontalStatic3ViewHolder.HomeHorizontalViewHolder> {


    private List<MobilesModel> mobilesModelList;

    public HomeHorizontalStatic3ViewHolder(List<MobilesModel> mobilesModelList) {
        this.mobilesModelList = mobilesModelList;
    }

    @NonNull
    @Override
    public HomeHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerviewhorizontalview3position, parent, false);
        return new HomeHorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHorizontalViewHolder holder, int position) {
        MobilesModel mobilesModel = mobilesModelList.get(position);
        holder.setImage(mobilesModel);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class HomeHorizontalViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageHorizontal1;

        public HomeHorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageHorizontal1 = itemView.findViewById(R.id.imageHorizontal1);


        }

        public void setImage(MobilesModel mobilesModel) {
            Glide.with(imageHorizontal1.getContext()).load(mobilesModel.getImage5Url()).into(imageHorizontal1);
            Glide.with(imageHorizontal1.getContext()).load(mobilesModel.getImage5Url()).into(imageHorizontal1);
            Glide.with(imageHorizontal1.getContext()).load(mobilesModel.getImage5Url()).into(imageHorizontal1);

        }
    }
}





