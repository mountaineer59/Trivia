package com.soropromo.trivia.controller;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.soropromo.trivia.R;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(2000)
                .withBackgroundColor(Color.parseColor("#dcdcdc"))//1a1b29 2c384d
                .withHeaderText("")//
                .withFooterText("Quiz app")
                .withBeforeLogoText("")//
                .withAfterLogoText("Trivia")
                .withLogo(R.mipmap.forest_small);

//        config.getHeaderTextView().setTextColor(Color.WHITE);//f16161
        config.getHeaderTextView().setPadding(100, 40, 100, 40);

//        config.getHeaderTextView().setBackground(getDrawable(R.drawable.round_button_red));


//        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setPadding(100, 40, 100, 40);
        config.getFooterTextView().setTextSize(14);
        //config.getFooterTextView().setBackgroundColor((Color.parseColor("#f16161")));//1a1b29

//        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setPadding(32, 32, 32, 32);

//        config.getAfterLogoTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextSize(18);
//        config.getAfterLogoTextView().setPadding(32, 32, 32, 32);


        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}
