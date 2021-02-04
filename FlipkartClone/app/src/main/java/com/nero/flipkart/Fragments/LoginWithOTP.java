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

import com.nero.flipkart.Interface.LoginIterface;
import com.nero.flipkart.Activities.OfferZone;
import com.nero.flipkart.R;

public class LoginWithOTP extends Fragment {

    private TextView edit, signup;
    private LoginIterface loginIterface;
    private Button verify;
    private String loginType;

    public LoginWithOTP() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_with_otp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void getDataFromBundle() {
        if(getArguments() != null){
            String s = getArguments().getString("phone");
            loginType = "phone";
            Log.d("madhuri patel", "getDataFromBundle: phone " + s);
            if(s == null){
                s = getArguments().getString("email");
                loginType = "email";
            }
            Log.d("madhuri patel", "getDataFromBundle: email " + s);
            signup.setText(s);
        }
    }

    private void initViews(View view) {
        edit = view.findViewById(R.id.tvEdit);
        signup = view.findViewById(R.id.tvSignup);
        verify = view.findViewById(R.id.btnContinueWithOtp);
        getDataFromBundle();
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("loginPageType", loginType);
                loginIterface.backToLoginPage(bundle);
            }
        });
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OfferZone.class);
                startActivity(intent);
            }
        });
    }

    public void setListener(LoginIterface listener){
        this.loginIterface = listener;
    }
}