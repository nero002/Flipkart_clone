package com.nero.flipkart.NavigationDrawer.FlipkartPlusZone;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nero.flipkart.MainActivity;
import com.nero.flipkart.NavigationDrawer.FlipkartPlusZone.RecyclerView.FlipkartPlusAdapter;
import com.nero.flipkart.NavigationDrawer.FlipkartPlusZone.RecyclerView.FlipkartPlusModel;
import com.nero.flipkart.R;

import java.util.ArrayList;
import java.util.List;


public class FlipkartPlusZoneFragment extends Fragment {

    private RecyclerView mRvFlipkartPlus;
    private List<FlipkartPlusModel> flipkartPlusModelList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_flipkart_plus_zone, container, false);

    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
//
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRvFlipkartPlus = view.findViewById(R.id.recyclerViewFlipkartPlus);
        buildRecyclerViewData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        FlipkartPlusAdapter flipkartPlusAdapter = new FlipkartPlusAdapter(flipkartPlusModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRvFlipkartPlus.setLayoutManager(linearLayoutManager);
        mRvFlipkartPlus.setAdapter(flipkartPlusAdapter);

    }

    private void buildRecyclerViewData() {
        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.flipkart_plus_img1));
        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.onerupees));
        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.supercoin));
        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.supercoinbonus));
        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.supercoindeals));
        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.tvchannel));
        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.steps));
        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.faqs1));
//        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.faq2));
//        flipkartPlusModelList.add(new FlipkartPlusModel(R.drawable.faq3));

    }


}