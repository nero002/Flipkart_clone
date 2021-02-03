package com.nero.flipkart.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.nero.flipkart.Interface.LoginIterface;
import com.nero.flipkart.R;

public class UsePhoneNumber extends Fragment {

    private TextInputEditText tvPhone;
    private Button  btnContinue;
    private TextView btnUseEmail;
    private LoginIterface loginIterface;

    public UsePhoneNumber() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_use_phone_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        tvPhone = view.findViewById(R.id.otlPhone);
        btnUseEmail = view.findViewById(R.id.useEmailId);
        btnContinue = view.findViewById(R.id.btnContinue);
        btnUseEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginIterface.onDataRecived();
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("madhuri", "onClick: "+ tvPhone.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putString("phone", tvPhone.getText().toString());
                loginIterface.continueWithPhone(bundle);
            }
        });
    }

    public void setListener(LoginIterface listener){
        this.loginIterface = listener;
    }
}