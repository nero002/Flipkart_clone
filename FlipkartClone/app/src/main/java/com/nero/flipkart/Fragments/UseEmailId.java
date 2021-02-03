package com.nero.flipkart.Fragments;

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

public class UseEmailId extends Fragment {

    private TextInputEditText tvEmail;
    private Button btnContinue;
    private TextView btnUsePhone;
    private LoginIterface loginIterface;

    public UseEmailId() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_use_email_id, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        tvEmail = view.findViewById(R.id.otlEmail);
        btnUsePhone = view.findViewById(R.id.usePhoneNumber);
        btnContinue = view.findViewById(R.id.btnContinueWithEmail);
        btnUsePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginIterface != null) {
                    loginIterface.onDataRecived();
                }
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("madhuri", "onClick: "+ tvEmail.getText().toString());
                if (loginIterface != null && isEmailValid()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("email", tvEmail.getText().toString());
                    loginIterface.continueWithPhoneEmail(bundle);
                }
            }
        });
    }

    private boolean isEmailValid(){
        if(!tvEmail.getText().toString().contains("@gmail.com")){
            tvEmail.setError("Invalid Email");
            return false;
        }
        return true;
    }

    public void setListener(LoginIterface listener){
        this.loginIterface = listener;
    }
}