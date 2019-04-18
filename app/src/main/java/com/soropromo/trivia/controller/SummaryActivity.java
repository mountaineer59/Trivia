package com.soropromo.trivia.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.soropromo.trivia.R;

public class SummaryActivity extends AppCompatActivity {

    private TextView summaryTxtTV;
    private TextView summaryQuestionTV;

    private String name;
    private String question;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        summaryTxtTV = findViewById(R.id.summary_txt_id);
        summaryQuestionTV = findViewById(R.id.summary_questionTxt);
        summaryTxtTV.setText("Hello " + name + "\nHere are the answers selected:");
        //todo fetch current user's data
        //get name and Q&As.
        //after fetching

        summaryQuestionTV.setText("Q." + question + "\n" + "Ans: " + answer + "\n"
                + "Q." + question + "\n" + "Ans: " + answer);
        //run in for loop to set questions from list

    }

    public void onFinishTapped(View view) {
        Intent intent = new Intent(SummaryActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
