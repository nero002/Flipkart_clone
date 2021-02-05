package com.nero.flipkart.Fragments.Home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.slider.Slider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nero.flipkart.Fragments.FashionSales;
import com.nero.flipkart.Fragments.Home.RecyclerView.HomeAllCategoriesViewHolderAdapter;
import com.nero.flipkart.Fragments.Home.RecyclerView.HomeGridView4ViewHolderAndAdapter;
import com.nero.flipkart.Fragments.Home.RecyclerView.HomeHorizontalStatic3ViewHolder;
import com.nero.flipkart.Fragments.MobileFragment.MobileFragment;
import com.nero.flipkart.Fragments.MobileFragment.MobileViewHolderAdapter;
import com.nero.flipkart.Fragments.NavigationDrawer.AllCategories.AllCategoriesFragment;
import com.nero.flipkart.Fragments.NavigationDrawer.OfferZone.OfferZoneFragment;
import com.nero.flipkart.HomeScreenNavActivity;
import com.nero.flipkart.Interface.OnitemClickListener;
import com.nero.flipkart.Model.ModelGridView;
import com.nero.flipkart.POJO.MobileModel;
import com.nero.flipkart.POJO.MobilesModel;
import com.nero.flipkart.R;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements OnitemClickListener {

    private ImageSlider imageSlider;
    private RecyclerView mRrAllCategories, rrHorizontalStaticView, mRrGrid4images, mrrgridcard4;
    private Button btnContinue;
    private ArrayList<ModelGridView> modelGridViewArrayList = new ArrayList<>();
    private OnitemClickListener listener;
    private HomeScreenNavActivity homeScreenNavActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeScreenNavActivity = (HomeScreenNavActivity) context;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    private Runnable fetchResponseRunnable = new Runnable() {
        @Override
        public void run() {
            fetchResponseFromAssets();
        }
    };

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
        mrrgridcard4 = view.findViewById(R.id.rrgridcard4);

        startBackgroundThread();
        setRecyclerViewForAllCategoriesOne();
        slider();
        setRecyclerViewFor4GridView();
        SetRecyclerViewCard4();
    }


    private void setRecyclerViewFor4GridView() {

        modelGridViewArrayList.add(new ModelGridView(R.drawable.saree, "Saree", "Min 70% Off"));
        modelGridViewArrayList.add(new ModelGridView(R.drawable.mug, "Mug", "Min 20% Off"));
        modelGridViewArrayList.add(new ModelGridView(R.drawable.bear, "Teddy-Bear", "Min 10% Off"));
        modelGridViewArrayList.add(new ModelGridView(R.drawable.watch, "Watches", "Min 50% Off"));

        HomeGridView4ViewHolderAndAdapter adapter = new HomeGridView4ViewHolderAndAdapter(modelGridViewArrayList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRrGrid4images.setLayoutManager(gridLayoutManager);
        mRrGrid4images.setAdapter(adapter);
    }

    private void SetRecyclerViewCard4() {
        ArrayList<ModelGridView> modelViewCard4 = new ArrayList<>();


        modelViewCard4.add(new ModelGridView(R.drawable.jwellerysets, "", ""));
        modelViewCard4.add(new ModelGridView(R.drawable.gaminglaptop, "", ""));
        modelViewCard4.add(new ModelGridView(R.drawable.topsellingrange, "", ""));
        modelViewCard4.add(new ModelGridView(R.drawable.walletslevis, "", ""));

        HomeGridView4ViewHolderAndAdapter adapter = new HomeGridView4ViewHolderAndAdapter(modelViewCard4);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mrrgridcard4.setLayoutManager(gridLayoutManager);
        mrrgridcard4.setAdapter(adapter);
    }

    private void setRecyclerViewFor3rdStaticHorizontal(MobileModel responseModel) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                HomeHorizontalStatic3ViewHolder homeHorizontalStatic3ViewHolder = new HomeHorizontalStatic3ViewHolder(responseModel.getMobilesProducts().get(0).getMobiles());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
                rrHorizontalStaticView.setLayoutManager(linearLayoutManager);
                rrHorizontalStaticView.setAdapter(homeHorizontalStatic3ViewHolder);
            }
        });
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
        HomeAllCategoriesViewHolderAdapter homeAllCategoriesViewHolderAdapter = new HomeAllCategoriesViewHolderAdapter(imageList, this);
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

    private void startBackgroundThread() {
        Thread thread = new Thread(fetchResponseRunnable);
        thread.start();
    }

    private void fetchResponseFromAssets() {
        try {
            InputStream inputStream = getActivity().getAssets().open("mobile.json");
            int data = inputStream.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (data != -1) {
                char ch = (char) data;
                stringBuffer.append(ch);
                data = inputStream.read();
            }
            buildPOJOFromJSON(stringBuffer.toString());

        } catch (Exception e) {
            Log.d("Dheeraj", e.getMessage());
        }
    }

    private void buildPOJOFromJSON(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<MobileModel>() {
        }.getType();
        MobileModel responseModel = gson.fromJson(json, type);
        setRecyclerViewFor3rdStaticHorizontal(responseModel);

    }

    @Override
    public void onClick(int position) {
        Log.d("Dheeraj", "click" + position);
        if (position == 0) {
            AllCategoriesFragment allCategoriesFragment = new AllCategoriesFragment();
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment, allCategoriesFragment, "AllCategoriesFragment")
                    .addToBackStack(null)
                    .commit();
        }
        if (position == 1) {
            OfferZoneFragment offerZoneFragment = new OfferZoneFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, offerZoneFragment, "offerZoneFragment")
                    .addToBackStack(null)
                    .commit();

        }
        if (position == 2) {
            MobileFragment mobileFragment = new MobileFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, mobileFragment, "offerZoneFragment")
                    .addToBackStack(null)
                    .commit();
        }
        if (position == 3) {
            OfferZoneFragment offerZoneFragment = new OfferZoneFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, offerZoneFragment, "FashionZone")
                    .addToBackStack(null)
                    .commit();
        }

    }


}
