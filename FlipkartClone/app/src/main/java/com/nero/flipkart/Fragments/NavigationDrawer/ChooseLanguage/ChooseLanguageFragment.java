package com.nero.flipkart.Fragments.NavigationDrawer.ChooseLanguage;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.nero.flipkart.Adapters.LanguageAdapter;
import com.nero.flipkart.Fragments.Home.HomeFragment;
import com.nero.flipkart.LoginActivity;
import com.nero.flipkart.Model.LanguageModel;
import com.nero.flipkart.R;
import com.nero.flipkart.SelectLanguage;

import java.util.ArrayList;
import java.util.List;


public class ChooseLanguageFragment extends Fragment implements AdapterView.OnItemClickListener {

    private RecyclerView recyclerView;
    private LanguageAdapter languageAdapter;
    private List<LanguageModel> languageModelList;
    private Button btnContinue;

    public ChooseLanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_language, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buildInput();
        init(view);
    }
    private void init(View view) {
        recyclerView = view.findViewById(R.id.rvLanguage);
        btnContinue = view.findViewById(R.id.btnContinue);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        languageAdapter = new LanguageAdapter(languageModelList, getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(languageAdapter);
        languageAdapter.setOnItemClickListener(this);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void buildInput() {
        languageModelList = new ArrayList<>();
        languageModelList.add(new LanguageModel("Hindi", "हिन्दी", R.drawable.tajmahal));
        languageModelList.add(new LanguageModel("Telugu", "తెలుగు", R.drawable.charminar1));
        languageModelList.add(new LanguageModel("Tamil", "தமிழ்", R.drawable.charminar1));
        languageModelList.add(new LanguageModel("Marathi", "मराठी", R.drawable.gateway_of_india));
        languageModelList.add(new LanguageModel("Kannada", "ಕನ್ನಡ", R.drawable.murudeshwar));
        languageModelList.add(new LanguageModel("English", "English", R.drawable.towerbridge));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        LanguageModel languageModel =
        Log.d("madhuri patel", "onItemClick: " + position);
        view.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.login_fb));
    }
}