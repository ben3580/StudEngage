package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class InstructorScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_screen);
        // Function of create class button
        Button btn_createClass = (Button) findViewById(R.id.btn_classroom);
        btn_createClass.setOnClickListener(view -> {
            OpenCreate_classroom();
        });

        // Function of create question button
        Button btn_createQuestion = (Button) findViewById(R.id.btn_questionMC);
        btn_createQuestion.setOnClickListener(view -> {
            OpenCreate_question();
        });
    }

    // After create classroom button is pressed, go to CreateClassroom activity
    private void OpenCreate_classroom() {
        Intent intent = new Intent(this, CreateClassroom.class);
        startActivity(intent);
    }

    // After create question button is pressed, go to CreateQuestion activity
    public void OpenCreate_question()
    {
        Intent intent = new Intent(this, CreateQuestion.class);
        startActivity(intent);
    }


}