package com.nero.flipkart.Interface;

import com.nero.flipkart.Model.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCallInterface {

    @GET("products")
    Call<List<ProductModel>> getData();

    @GET("products/{user}")
    Call<ProductModel> getProductData(@Path("user") String user);

}