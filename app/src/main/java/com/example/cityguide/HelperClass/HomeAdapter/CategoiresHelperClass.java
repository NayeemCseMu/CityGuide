package com.example.cityguide.HelperClass.HomeAdapter;

import android.graphics.drawable.GradientDrawable;

public class CategoiresHelperClass {

    GradientDrawable gradientDrawable;
    int images;
    String title;

    public CategoiresHelperClass(GradientDrawable gradientDrawable, int images, String title) {
        this.gradientDrawable = gradientDrawable;
        this.images = images;
        this.title = title;
    }

    public GradientDrawable getGradientDrawable() {
        return gradientDrawable;
    }

    public int getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }
}
