package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {
    // Initialize our Text Views
    TextView grades, percent, message;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        // The button which takes the student back to the Student screen
        Button btn_goHome = (Button)findViewById(R.id.btn_goHome);
        btn_goHome.setOnClickListener(view -> {
            Intent intent = new Intent(this, StudentScreen.class);
            startActivity(intent);
        });

        // We use Bundle to get the updated score from StudentClassroom activity
        // and show it on this activity
        grades = (TextView) findViewById(R.id.showResult);
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");
        grades.setText("You scored " + score + " out of " + QuestionLib.questions.length);

        // Show grades in percentage
        percent = (TextView) findViewById(R.id.percentage);
        float score_percent = ((float)score / QuestionLib.questions.length) * 100;
        percent.setText(String.format("%.2f", score_percent) + " %");

        // Additional message for our user (depending on the range of their score)
        message = (TextView) findViewById(R.id.message);
        if (score_percent > 90) {
            message.setText("Well done, you did a great job!");
        }
        else if(score_percent < 50) {
            message.setText("Try harder next time...");
        }
        else{
            message.setText("You did okay but you can do better");
        }
    }
}