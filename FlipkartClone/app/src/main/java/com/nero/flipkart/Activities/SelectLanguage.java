package com.nero.flipkart.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.nero.flipkart.Adapters.LanguageAdapter;
import com.nero.flipkart.Model.LanguageModel;
import com.nero.flipkart.R;

import java.util.ArrayList;
import java.util.List;

public class SelectLanguage extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private RecyclerView recyclerView;
    private LanguageAdapter languageAdapter;
    private List<LanguageModel> languageModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        buildInput();
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.rvLanguage);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        languageAdapter = new LanguageAdapter(languageModelList, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(languageAdapter);
        languageAdapter.setOnItemClickListener(this);
    }

    private void buildInput() {
        languageModelList = new ArrayList<>();
        languageModelList.add(new LanguageModel("Hindi", "हिन्दी", R.drawable.tajmahal));
        languageModelList.add(new LanguageModel("Telugu", "తెలుగు", R.drawable.charminar));
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