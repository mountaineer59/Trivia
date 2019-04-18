package com.soropromo.trivia.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.soropromo.trivia.R;
import static com.soropromo.trivia.utils.Constants.NAME;

public class MainActivity extends AppCompatActivity {

    //views
    private TextView questionTV;
    private EditText answerET;

    //sharedpref
//    private SharedPreferences sharedPreferences;
//    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = findViewById(R.id.question_nameTV);
        answerET = findViewById(R.id.answer_nameET);

//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //change status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }

    }

    // next button clicked
    public void onNextTapped(View view) {
        String answer = answerET.getText().toString();
        if (!TextUtils.isEmpty(answer)) {

            //save to sharedPref
//            editor = sharedPreferences.edit();
//            editor.putString(NAME, answer);
//            editor.commit();


            //todo start a session of that user
            //save user's name into db and as user selects answers save those under user object.
            //how to save a user session into sqlite db? add columns?



            //go to next page
            Intent intent = new Intent(MainActivity.this, QuesAnsActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

//a) Please use local database for storing history

