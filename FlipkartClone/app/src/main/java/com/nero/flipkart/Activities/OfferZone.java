package com.nero.flipkart.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.nero.flipkart.Adapters.OfferZoneViewPagerAdapter;
import com.nero.flipkart.R;

public class OfferZone extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_zone);
        viewPager = findViewById(R.id.ViewPager);
        tabLayout = findViewById(R.id.tablayout);
        setViewPageAdapter();
    }

    private void setViewPageAdapter() {
        OfferZoneViewPagerAdapter viewPagerAdapter = new OfferZoneViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }



}