package com.example.cityguide.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguide.HelperClass.SliderAdapter;
import com.example.cityguide.R;
import com.example.cityguide.user.UserDashboard;

public class onBoardingScren extends AppCompatActivity {


    ViewPager viewPager;
    LinearLayout dotLayout;
    Button skip_button, next_button, let_started_button;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Animation animation;
    int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding_scren);

        /*----Hooks----*/
        viewPager = findViewById(R.id.slider);
        dotLayout = findViewById(R.id.dots);
        skip_button = findViewById(R.id.skip_btnId);
        next_button = findViewById(R.id.next_btnId);
        let_started_button = findViewById(R.id.lets_started_btnID);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);


    }

    private void addDots(int position){
        dots = new TextView[4];
        dotLayout.removeAllViews();


        for(int i=0; i<dots.length; i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotLayout.addView(dots[i]);
        }
        if(dots.length > 0)
        {
            dots[position].setText(Html.fromHtml("&#9992;"));
            dots[position].setTextSize(40);
        }

    }

    ViewPager.OnPageChangeListener changeListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition = position;
            if(position != dots.length - 1)
            {
                let_started_button.setVisibility(View.INVISIBLE);
            }
            else
            {
                animation = AnimationUtils.loadAnimation(onBoardingScren.this, R.anim.bottom_animation);
                let_started_button.setAnimation(animation);
                let_started_button.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void skip(View view){
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
        finish();
    }
    public void next(View view){
        viewPager.setCurrentItem(currentPosition + 1);
    }

    public void go_to_dashboard(View view) {
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
        finish();
    }
}
