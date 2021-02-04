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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OfferZoneDayDeals extends Fragment implements OnProductItemClickListener {

    private TextView timeRemaining;
    private RecyclerView rvDailyDeals;
    private List<ProductModel> modelList= new ArrayList<>();
    private ProductsAdapter productsAdapter;
    private ProgressBar progressBar;

    public OfferZoneDayDeals() {
        // Required empty public constructor
    }

    public static OfferZoneDayDeals newInstance() {
        OfferZoneDayDeals fragment = new OfferZoneDayDeals();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offer_zone_day_deals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        getApiData();
    }

    private void initViews(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        timeRemaining = view.findViewById(R.id.tvTimeRemaining);
        rvDailyDeals = view.findViewById(R.id.rvDailyOffer);
        timeRemaining.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rc_time, 0, 0, 0);

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