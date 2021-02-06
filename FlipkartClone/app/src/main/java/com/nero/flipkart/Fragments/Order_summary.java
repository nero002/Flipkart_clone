package com.nero.flipkart.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nero.flipkart.R;


public class Order_summary extends Fragment {

    private TextView mtvOrderName, mtvPrice, mtvPriceDetails, mtvAmountPayable;
    private Button mBtnContinue;

    public Order_summary() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_summary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    private void initViews(View view) {
        mtvOrderName = view.findViewById(R.id.tvOrderName);
        mtvPrice = view.findViewById(R.id.tvPrice);
        mtvPriceDetails = view.findViewById(R.id.tvPriceDetails);
        mtvAmountPayable = view.findViewById(R.id.tvAmountPayable);
        mBtnContinue = view.findViewById(R.id.btnContinue);

        mBtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Payment_Details payment_details = new Payment_Details();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flBuyNowContainer, payment_details, "Paymentdettails")
                        .addToBackStack(null)
                        .commit();

            }
        });

    }
}