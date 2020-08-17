package com.example.cityguide.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguide.R;
import com.example.cityguide.user.UserDashboard;

public class MainActivity extends AppCompatActivity {

    private  static int SPLASH_TIMER = 5000;
    ImageView background_image;
    TextView power_text;
    Animation bottomAnim, sideAnim;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        /* -----Hooks-----*/
        background_image = findViewById(R.id.background_image);
        power_text = findViewById(R.id.powered_line);

        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        background_image.setAnimation(sideAnim);
        power_text.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sharedPreferences = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = sharedPreferences.getBoolean("firstTime", true);

                if(isFirstTime)
                {
                    /*that sharedPreference stored activity and checked whether a user use this application as first time or not?
                    * if first time user, then it allow to go onBoardScreen otherwise direct to the UserDashboard */

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), onBoardingScren.class);
                    startActivity(intent);
                    finish();
                }

                else {
                    Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                    startActivity(intent);
                    finish();
                }


            }
        },SPLASH_TIMER);
    }
}
