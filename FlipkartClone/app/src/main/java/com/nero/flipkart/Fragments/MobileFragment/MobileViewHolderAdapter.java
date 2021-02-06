package com.nero.flipkart.Fragments.MobileFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nero.flipkart.Interface.OnitemClickListener;
import com.nero.flipkart.POJO.MobilesModel;
import com.nero.flipkart.R;

import java.util.List;

public class MobileViewHolderAdapter extends RecyclerView.Adapter<MobileViewHolderAdapter.MobileHolder> {

    private List<MobilesModel> mobilesModelslist;

    public MobileViewHolderAdapter(List<MobilesModel> mobilesModelslist) {
        this.mobilesModelslist = mobilesModelslist;
    }

    @NonNull
    @Override

    public MobileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile, parent, false);
        return new MobileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MobileHolder holder, int position) {
        MobilesModel mobilesModel = mobilesModelslist.get(position);
        holder.setData(mobilesModel);
    }

    @Override
    public int getItemCount() {
        return mobilesModelslist.size();
    }

    public class MobileHolder extends RecyclerView.ViewHolder {

        private TextView mtvPrice, mTvTitle, mtvRating, mtvRam, mtvoffer;
        private ImageView mtvImage;
        private RelativeLayout mrrMobile;

        public MobileHolder(@NonNull View itemView ) {
            super(itemView);
            initViews(itemView);

        }

        private void initViews(View itemView) {
            mtvImage = itemView.findViewById(R.id.ivmobileimg);
            mTvTitle = itemView.findViewById(R.id.tvMobileName);
            mtvRating = itemView.findViewById(R.id.tvRating);
            mtvRam = itemView.findViewById(R.id.tvRam);
            mtvoffer = itemView.findViewById(R.id.tvoffer);
            mtvPrice = itemView.findViewById(R.id.tvPrice);
            mrrMobile = itemView.findViewById(R.id.rlMobile);
        }

        public void setData(MobilesModel mobileModel) {

            Glide.with(mtvImage.getContext()).load(mobileModel.getImage1Url()).into(mtvImage);
            mTvTitle.setText(mobileModel.getName());
            mtvRam.setText(mobileModel.getRam());
//            mtvExtra.setText(mobileModel.getExtra());
            mtvPrice.setText(mobileModel.getPrice());
            mtvoffer.setText(mobileModel.getOffer());
            mtvRating.setText(mobileModel.getRating());



        }
    }

}
