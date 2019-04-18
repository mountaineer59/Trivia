package com.soropromo.trivia.controller;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.soropromo.trivia.R;
import com.soropromo.trivia.model.Question;
import com.soropromo.trivia.utils.QuizDbHelper;

import java.util.List;

public class QuesAnsActivity extends AppCompatActivity {

    private TextView questionTV;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button confirmNextBtn;

    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_ans);

        //change status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }

        questionTV = findViewById(R.id.questionTV);
        radioGroup = findViewById(R.id.radio_group);
        radioButton1 = findViewById(R.id.radio_btn1);
        radioButton2 = findViewById(R.id.radio_btn2);
        radioButton3 = findViewById(R.id.radio_btn3);
        radioButton4 = findViewById(R.id.radio_btn4);
        confirmNextBtn = findViewById(R.id.nextTwoBtn);


        //get list
        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestions();

        questionCountTotal = questionList.size();

        showNextQuestion();

        confirmNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!answered) {
                if (radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked() || radioButton4.isChecked()) {
                    checkAnswer();
                } else {
                    Toast.makeText(QuesAnsActivity.this, "Please select an answer first", Toast.LENGTH_SHORT).show();
                }
//                } else {
//                }
            }
        });
    }

    private void checkAnswer() {
        answered = true;

        RadioButton radioButtonSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNr = radioGroup.indexOfChild(radioButtonSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()) {
            //todo save to db as correct ans. for current question under current user.

        }

        showNextQuestion();

        if (questionCounter < questionCountTotal) {
            confirmNextBtn.setText("Next");
        } else {
            confirmNextBtn.setText("Finish");
        }
    }


    private void showNextQuestion() {
        radioGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            questionTV.setText(currentQuestion.getQuestion());
            radioButton1.setText(currentQuestion.getOption1());
            radioButton2.setText(currentQuestion.getOption2());
            radioButton3.setText(currentQuestion.getOption3());
            radioButton4.setText(currentQuestion.getOption4());

            questionCounter++;
//            answered = false;
//            confirmNextBtn.setText("Confirm");
        } else {

            //show summary
            Intent intent = new Intent(QuesAnsActivity.this, SummaryActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
