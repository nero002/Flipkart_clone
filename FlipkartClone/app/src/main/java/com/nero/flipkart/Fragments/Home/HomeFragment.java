package com.nero.flipkart.Fragments.Home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.slider.Slider;
import com.nero.flipkart.Fragments.Home.RecyclerView.HomeAllCategoriesViewHolderAdapter;
import com.nero.flipkart.Fragments.Home.RecyclerView.HomeGridView4ViewHolderAndAdapter;
import com.nero.flipkart.Fragments.Home.RecyclerView.HomeHorizontalStatic3ViewHolder;
import com.nero.flipkart.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private ImageSlider imageSlider;
    private RecyclerView mRrAllCategories, rrHorizontalStaticView, mRrGrid4images;
    private Button btnContinue;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    private void initViews(View view) {
        imageSlider = view.findViewById(R.id.slider);
        mRrAllCategories = view.findViewById(R.id.rrAllCategories);
        rrHorizontalStaticView = view.findViewById(R.id.rrHorizontalStaticView);
        mRrGrid4images = view.findViewById(R.id.grid4images);
        setRecyclerViewForAllCategoriesOne();
        slider();
        setRecyclerViewFor3rdStaticHorizontal();
        setRecyclerViewFor4GridView();
    }

    private void setRecyclerViewFor4GridView() {
        ArrayList<Integer> image = new ArrayList<>();
        image.add(R.drawable.saree);
        image.add(R.drawable.shoes);
        image.add(R.drawable.menshoodies);
        image.add(R.drawable.jwellery);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        HomeHorizontalStatic3ViewHolder homeHorizontalStatic3ViewHolder = new HomeHorizontalStatic3ViewHolder(image);
        mRrGrid4images.setLayoutManager(gridLayoutManager);
        mRrGrid4images.setAdapter(homeHorizontalStatic3ViewHolder);
    }

    private void setRecyclerViewFor3rdStaticHorizontal() {
        ArrayList<Integer> image = new ArrayList<>();
        image.add(R.drawable.healthsupliments);
        image.add(R.drawable.mobile_home);
        image.add(R.drawable.smart_watch);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        HomeHorizontalStatic3ViewHolder homeHorizontalStatic3ViewHolder = new HomeHorizontalStatic3ViewHolder(image);
        rrHorizontalStaticView.setLayoutManager(gridLayoutManager);
        rrHorizontalStaticView.setAdapter(homeHorizontalStatic3ViewHolder);

    }

    private void setRecyclerViewForAllCategoriesOne() {
        //1st horizontal recyclerView

        ArrayList<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.allcategories);
        imageList.add(R.drawable.offerzone);
        imageList.add(R.drawable.mobile);
        imageList.add(R.drawable.fashion);
        imageList.add(R.drawable.electronics);
        imageList.add(R.drawable.home);
        imageList.add(R.drawable.beauty);
        imageList.add(R.drawable.toys);
        imageList.add(R.drawable.flight);
        imageList.add(R.drawable.insurance);
        imageList.add(R.drawable.food);
        imageList.add(R.drawable.giftcard);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        HomeAllCategoriesViewHolderAdapter homeAllCategoriesViewHolderAdapter = new HomeAllCategoriesViewHolderAdapter(imageList);
        mRrAllCategories.setLayoutManager(linearLayoutManager);
        mRrAllCategories.setAdapter(homeAllCategoriesViewHolderAdapter);
    }

    private void slider() {

        //slider code
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.slider1, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider3, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider4, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider5, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider6, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slider7, ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);
    }
}