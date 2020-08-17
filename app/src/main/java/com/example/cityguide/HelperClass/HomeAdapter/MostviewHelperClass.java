package com.example.cityguide.HelperClass.HomeAdapter;

public class MostviewHelperClass {
    int images;
    String title, description;

    public MostviewHelperClass(int images, String title, String description) {
        this.images = images;
        this.title = title;
        this.description = description;
    }

    public int getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
