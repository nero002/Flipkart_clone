package com.nero.flipkart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.nero.flipkart.Fragments.NavigationDrawer.AllCategories.AllCategoriesFragment;
import com.nero.flipkart.Fragments.Order_summary;

public class BuyNow extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Order_summary order_summary = new Order_summary();
        transaction.add(R.id.flBuyNowContainer, order_summary, "orderSummary").commit();


    }
}