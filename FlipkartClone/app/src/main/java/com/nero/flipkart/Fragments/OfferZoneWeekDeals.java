package com.nero.flipkart.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nero.flipkart.Adapters.ProductsAdapter;
import com.nero.flipkart.Interface.ApiCallInterface;
import com.nero.flipkart.Interface.OnProductItemClickListener;
import com.nero.flipkart.Model.ProductModel;
import com.nero.flipkart.Networks.ProductNetwork;
import com.nero.flipkart.Activities.ProductDetails;
import com.nero.flipkart.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OfferZoneWeekDeals extends Fragment implements OnProductItemClickListener {

    private TextView tvWeekDeals;
    private RecyclerView rvDailyDeals;
    private List<ProductModel> modelList= new ArrayList<>();
    private ProductsAdapter productsAdapter;
    private ProgressBar progressBar;

    public OfferZoneWeekDeals() {
        // Required empty public constructor
    }

    public static OfferZoneWeekDeals newInstance() {
        OfferZoneWeekDeals fragment = new OfferZoneWeekDeals();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offer_zone_week_deals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        getApiData();
    }

    private void initViews(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        rvDailyDeals = view.findViewById(R.id.rvWeeklyOffer);
        productsAdapter = new ProductsAdapter(modelList);
        productsAdapter.setOnClickItemListener(this);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        rvDailyDeals.setLayoutManager(layoutManager);
        rvDailyDeals.setAdapter(productsAdapter);
    }

    private void getApiData() {
        ApiCallInterface apiCallInterface = ProductNetwork.getInstance().create(ApiCallInterface.class);
        apiCallInterface.getData().enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if (response.body() != null){
                    modelList  = response.body();
                    Collections.shuffle(modelList);
                    progressBar.setVisibility(View.INVISIBLE);
                    productsAdapter.updateAdapter(modelList);
                }
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
            }
        });
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(getContext(), ProductDetails.class);
        intent.putExtra("position", modelList.get(position).getId() + "");
        startActivity(intent);
    }
}