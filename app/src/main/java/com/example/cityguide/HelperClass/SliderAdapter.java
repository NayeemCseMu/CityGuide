package com.example.cityguide.HelperClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cityguide.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
    int images[] = {
            R.drawable.add_missing_place,
            R.drawable.make_a_call,
            R.drawable.search_place,
            R.drawable.sit_back_and_relax
    };
    int headings[] = {
            R.string.missing_place_heading,
            R.string.make_call_heading,
            R.string.search_location_heading,
            R.string.sit_back_heading
    };

    int descriptions[] = {
            R.string.missing_place_desc,
            R.string.make_call_desc,
            R.string.search_location_desc,
            R.string.sit_back_desc,
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == (ConstraintLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container, false);

        ImageView imageView = view.findViewById(R.id.slidder_images);
        TextView headingText = view.findViewById(R.id.slider_headingId);
        TextView descText = view.findViewById(R.id.slider_descriptionId);

        imageView.setImageResource(images[position]);
        headingText.setText(headings[position]);
        descText.setText(descriptions[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
