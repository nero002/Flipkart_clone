package com.nero.flipkart.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nero.flipkart.HomeScreenNavActivity;
import com.nero.flipkart.Interface.LoginIterface;
import com.nero.flipkart.OfferZone;
import com.nero.flipkart.R;

public class LoginWithOTP extends Fragment {

    private TextView edit, signup;
    private LoginIterface loginIterface;
    private Button verify;
    private EditText mEtFistDigit;
    private EditText mEtSecondDigit;
    private EditText mEtThirdDigit;
    private EditText mEtFourthDigit;
    private EditText mEtFifthDigit;
    private EditText mEtSixth;
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
        otpGenerator();
    }

    private void getDataFromBundle() {
        if (getArguments() != null) {
            String s = getArguments().getString("phone");
            loginType = "phone";
            Log.d("madhuri patel", "getDataFromBundle: phone " + s);
            if (s == null) {
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
        mEtFistDigit = view.findViewById(R.id.mEtFistDigit);
        mEtSecondDigit = view.findViewById(R.id.mEtSecondDigit);
        mEtThirdDigit = view.findViewById(R.id.mEtThirdDigit);
        mEtFourthDigit = view.findViewById(R.id.mEtFourthDigit);
        mEtFifthDigit = view.findViewById(R.id.mEtFifthDigit);
        mEtSixth = view.findViewById(R.id.mEtSixthDigit);
        mEtFistDigit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                verify.setBackgroundResource(R.color.orange_login);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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
                Intent intent = new Intent(getContext(), HomeScreenNavActivity.class);
                startActivity(intent);
            }
        });


    }

    private void otpGenerator() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEtFistDigit.setText("2");
                mEtSecondDigit.setText("6");
                mEtThirdDigit.setText("0");
                mEtFourthDigit.setText("5");
                mEtFifthDigit.setText("9");
                mEtSixth.setText("0");
            }
        }, 1600);
    }


    public void setListener(LoginIterface listener) {
        this.loginIterface = listener;
    }
}