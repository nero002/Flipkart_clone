package com.nero.flipkart.Fragments.NavigationDrawer.AllCategories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllCategoriesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AllCategoriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}