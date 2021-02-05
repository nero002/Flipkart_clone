package com.nero.flipkart.Fragments.NavigationDrawer.MoreOnFlipkart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoreOnFlipkartViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MoreOnFlipkartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}