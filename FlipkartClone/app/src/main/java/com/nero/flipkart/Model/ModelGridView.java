package com.nero.flipkart.Model;

public class ModelGridView {

    private int imageView;
    private String tvProductName, tvProductOffer;

    public ModelGridView(int imageView, String tvProductName, String tvProductOffer) {
        this.imageView = imageView;
        this.tvProductName = tvProductName;
        this.tvProductOffer = tvProductOffer;
    }

    public int getImageView() {
        return imageView;
    }

    public String getTvProductName() {
        return tvProductName;
    }

    public String getTvProductOffer() {
        return tvProductOffer;
    }
}

