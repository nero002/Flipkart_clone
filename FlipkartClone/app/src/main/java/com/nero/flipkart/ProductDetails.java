package com.nero.flipkart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nero.flipkart.Fragments.Order_summary;
import com.nero.flipkart.Interface.ApiCallInterface;
import com.nero.flipkart.Model.ProductModel;
import com.nero.flipkart.Networks.ProductNetwork;
import com.nero.flipkart.R;

import java.text.DecimalFormat;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetails extends AppCompatActivity {

    private ImageView imgProduct;
    private TextView tvCategory, tvTitle, tvPrice, tvActualPrice, tvDiscount, tvDesc, tvEMI;
    private LinearLayout linearLayout;
    private ProgressBar progressBar;
    private TextView headerText;
    private Button mbtnBuyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        initViews();
    }

    private void initViews() {
        linearLayout = findViewById(R.id.layout);
        headerText = findViewById(R.id.headerText);
        linearLayout.setVisibility(View.INVISIBLE);
        progressBar = findViewById(R.id.progressBar);
        imgProduct = findViewById(R.id.imgProduct);
        tvEMI = findViewById(R.id.tvEMI);
        tvCategory = findViewById(R.id.tvCategory);
        tvDesc = findViewById(R.id.tvDesc);
        tvTitle = findViewById(R.id.tvTitle);
        tvPrice = findViewById(R.id.tvPrice);
        tvActualPrice = findViewById(R.id.tvActualPrice);
        tvDiscount = findViewById(R.id.tvDiscount);
        mbtnBuyNow = findViewById(R.id.btnBuyNow);
        tvActualPrice.setPaintFlags(tvActualPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        getDataFromAPI();
        mbtnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetails.this, BuyNow.class);
                startActivity(intent);
            }
        });
    }

    private void getDataFromAPI() {
        String userid = "0";
        Log.d("madhuripatel", "getDataFromAPI: " + userid);
        if (getIntent() != null) {
            userid = getIntent().getStringExtra("position").toString();
            Log.d("madhuripatel", "getDataFromAPI: " + userid);
        }
        ApiCallInterface apiCallInterface = ProductNetwork.getInstance().create(ApiCallInterface.class);
        apiCallInterface.getProductData(userid).enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if (response.body() != null) {
                    ProductModel productModel = response.body();
                    Glide.with(imgProduct).load(productModel.getImage()).into(imgProduct);
                    tvCategory.setText(productModel.getCategory());
                    tvTitle.setText(productModel.getTitle());
                    tvPrice.setText("₹ " + productModel.getPrice());
                    tvDesc.setText(productModel.getDescription());
                    progressBar.setVisibility(View.INVISIBLE);
                    linearLayout.setVisibility(View.VISIBLE);
                    Random r = new Random();
                    int i1 = r.nextInt(80) + 10;
                    tvDiscount.setText(i1 + "%");
                    double actualPrice = ((double) productModel.getPrice() * 100.0) / (100.0 - i1);
                    DecimalFormat df = new DecimalFormat("#.##");
                    tvEMI.setText("No cost EMI ₹" + df.format((double) productModel.getPrice() / 12) + "/ month. ");
                    tvActualPrice.setText(df.format(actualPrice) + "");
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {

            }
        });


    }
}