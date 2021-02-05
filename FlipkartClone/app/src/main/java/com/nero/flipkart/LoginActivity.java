package com.nero.flipkart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.nero.flipkart.Fragments.LoginWithOTP;
import com.nero.flipkart.Fragments.UseEmailId;
import com.nero.flipkart.Fragments.UsePhoneNumber;
import com.nero.flipkart.Interface.LoginIterface;
import com.nero.flipkart.R;

public class LoginActivity extends AppCompatActivity implements LoginIterface {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragmentManager = getSupportFragmentManager();
        launchFragment();
    }


    private void launchFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        UseEmailId useEmailId = new UseEmailId();
        useEmailId.setListener(this);
        fragmentTransaction.add(R.id.flConatiner, useEmailId, "useEmailId").commit();
    }

    @Override
    public void onDataRecived() {
        Log.d("madhuri patel", "onDataRecived: init");
        UseEmailId useEmailId = (UseEmailId) fragmentManager.findFragmentByTag("useEmailId");
        UsePhoneNumber usePhoneNumber;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (useEmailId != null && useEmailId.isVisible()) {
            Log.d("madhuri patel", "onDataRecived: email");
            usePhoneNumber = new UsePhoneNumber();
            usePhoneNumber.setListener(this);
            fragmentTransaction.replace(R.id.flConatiner, usePhoneNumber, "usePhone").commit();
        }
        usePhoneNumber = (UsePhoneNumber) fragmentManager.findFragmentByTag("usePhone");
        if (usePhoneNumber != null && usePhoneNumber.isVisible()) {
            useEmailId = new UseEmailId();
            useEmailId.setListener(this);
            fragmentTransaction.replace(R.id.flConatiner, useEmailId, "useEmailId").commit();
        }
    }

    @Override
    public void continueWithEmail(Bundle bundle) {
    }

    @Override
    public void continueWithPhoneEmail(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginWithOTP loginWithOTP = new LoginWithOTP();
        loginWithOTP.setArguments(bundle);
        loginWithOTP.setListener(this);
        fragmentTransaction.replace(R.id.flConatiner, loginWithOTP, "loginWithOTP").addToBackStack("loginWithOTP").commit();
    }

    @Override
    public void backToLoginPage(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (bundle.getString("loginPageType") == "email") {
            UseEmailId useEmailId = new UseEmailId();
            useEmailId.setListener(this);
            fragmentTransaction.add(R.id.flConatiner, useEmailId, "useEmailId").commit();
        } else if (bundle.getString("loginPageType") == "phone") {
            UsePhoneNumber usePhoneNumber = new UsePhoneNumber();
            usePhoneNumber.setListener(this);
            fragmentTransaction.replace(R.id.flConatiner, usePhoneNumber, "usePhone").commit();
        }
    }

}