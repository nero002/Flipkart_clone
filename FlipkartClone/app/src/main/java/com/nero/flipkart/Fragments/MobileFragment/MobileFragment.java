package com.nero.flipkart.Fragments.MobileFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nero.flipkart.POJO.MobileModel;
import com.nero.flipkart.R;

import java.io.InputStream;
import java.lang.reflect.Type;


public class MobileFragment extends Fragment {


    private  RecyclerView mrrMobile;
    private ProgressBar mpbProgressBar;
    private Runnable fetchResponseRunnable = new Runnable() {
        @Override
        public void run() {
            fetchResponseFromAssets();
        }
    };

    public MobileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobile, container, false);
    }

    private void initViews(View view) {
        mrrMobile = view.findViewById(R.id.rrMobile);
        mpbProgressBar = view.findViewById(R.id.progressbar);
        startBackgroundThread();

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
        setRecyclerAdapter(responseModel);

    }

    private void setRecyclerAdapter(MobileModel responseModel) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mpbProgressBar.setVisibility(View.GONE);
                MobileViewHolderAdapter restaurantAdapter = new MobileViewHolderAdapter(responseModel.getMobilesProducts().get(0).getMobiles());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getContext());
                mrrMobile.setLayoutManager(linearLayoutManager);
                mrrMobile.setAdapter(restaurantAdapter);
            }
        });

    }
}