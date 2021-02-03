package com.nero.flipkart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.nero.flipkart.Fragments.UseEmailId;
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


    private void launchFragment(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        UseEmailId useEmailId = new UseEmailId();
        fragmentTransaction.add(R.id.flConatiner,useEmailId,"useEmailId").commit();
    }

    @Override
    public void onDataRecived() {

    }

    @Override
    public void continueWithEmail(Bundle bundle) {

    }

    @Override
    public void continueWithPhone(Bundle bundle) {

    }
}