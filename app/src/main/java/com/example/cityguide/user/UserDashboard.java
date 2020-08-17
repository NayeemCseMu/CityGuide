package com.example.cityguide.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.cityguide.HelperClass.HomeAdapter.CategoiresHelperClass;
import com.example.cityguide.HelperClass.HomeAdapter.CategoriesAdapter;
import com.example.cityguide.HelperClass.HomeAdapter.FeaturedAdapter;
import com.example.cityguide.HelperClass.HomeAdapter.FeaturedHelperClass;
import com.example.cityguide.HelperClass.HomeAdapter.MostViewAdapter;
import com.example.cityguide.HelperClass.HomeAdapter.MostviewHelperClass;
import com.example.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {

    RecyclerView featuredRecycler, mostViewRecycler, categoiresRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);
        /*---Hooks----*/
        featuredRecycler = findViewById(R.id.featured_recyclerViewId);
        mostViewRecycler = findViewById(R.id.mostviewRecylcerViewId);
        categoiresRecycler = findViewById(R.id.categoiresviewRecylcerViewId);
        featuredRecycler();
        most_viewRecycler();
        categorieRecycler();
    }

    private void categorieRecycler() {
        categoiresRecycler.setHasFixedSize(true);
        categoiresRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        ArrayList<CategoiresHelperClass> categoiresLocations = new ArrayList<>();
        categoiresLocations.add(new CategoiresHelperClass(gradient1, R.drawable.macdonald,"Educatoin"));
        categoiresLocations.add(new CategoiresHelperClass(gradient2, R.drawable.brsitol_hotel, "Hospital"));
        categoiresLocations.add(new CategoiresHelperClass(gradient3, R.drawable.kfc, "Transport"));

        adapter = new CategoriesAdapter(categoiresLocations);
        categoiresRecycler.setAdapter(adapter);
    }

    private void most_viewRecycler() {
        mostViewRecycler.setHasFixedSize(true);
        mostViewRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        ArrayList<MostviewHelperClass> mostviewLocations = new ArrayList<>();
        mostviewLocations.add(new MostviewHelperClass(R.drawable.macdonald, "Macdonald", "Here add the strings of the title Description and Buttons between the resources tag."));
        mostviewLocations.add(new MostviewHelperClass(R.drawable.kfc, "Kfc", "Here add the strings of the title Description and Buttons between the resources tag."));
        mostviewLocations.add(new MostviewHelperClass(R.drawable.brsitol_hotel, "Bristol", "Here add the strings of the title Description and Buttons between the resources tag."));

        adapter = new MostViewAdapter(mostviewLocations);
        mostViewRecycler.setAdapter(adapter);
    }

    private void featuredRecycler(){
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        ArrayList<FeaturedHelperClass> featureLocations = new ArrayList<>();
        featureLocations.add(new FeaturedHelperClass(R.drawable.macdonald, "Macdonald", "Here add the strings of the title Description and Buttons between the resources tag."));
        featureLocations.add(new FeaturedHelperClass(R.drawable.kfc, "Kfc", "Here add the strings of the title Description and Buttons between the resources tag."));
        featureLocations.add(new FeaturedHelperClass(R.drawable.brsitol_hotel, "Bristol", "Here add the strings of the title Description and Buttons between the resources tag."));

        adapter = new FeaturedAdapter(featureLocations);
        featuredRecycler.setAdapter(adapter);

    }
}
