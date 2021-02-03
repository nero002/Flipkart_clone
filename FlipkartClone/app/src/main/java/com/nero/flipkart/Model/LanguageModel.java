package com.nero.flipkart.Model;

import android.widget.ImageView;

import java.io.Serializable;

public class LanguageModel implements Serializable {
    private String langName, langLocalName;
    private int imgPlace;

    public LanguageModel(String langName, String langLocalName, int imgPlace) {
        this.langName = langName;
        this.langLocalName = langLocalName;
        this.imgPlace = imgPlace;
    }

    public String getLangName() {
        return langName;
    }

    public String getLangLocalName() {
        return langLocalName;
    }

    public int getImgPlace() {
        return imgPlace;
    }
}
