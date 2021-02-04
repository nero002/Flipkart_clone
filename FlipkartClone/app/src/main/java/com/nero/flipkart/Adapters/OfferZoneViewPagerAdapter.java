package com.nero.flipkart.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nero.flipkart.Fragments.OfferZoneDayDeals;
import com.nero.flipkart.Fragments.OfferZoneWeekDeals;
import com.nero.flipkart.Fragments.SuperCoins;

public class OfferZoneViewPagerAdapter extends FragmentStatePagerAdapter {
    public OfferZoneViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return OfferZoneDayDeals.newInstance();
            case 1:
                return OfferZoneWeekDeals.newInstance();
            case 2:
                return SuperCoins.newInstance();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Deals of the Day";
            case 1:
                return "Big Steals of the Week";
            case 2:
                return "SuperCoin";
        }
        return "";
    }

    @Override
    public int getCount() {
        return 3;
    }
}
