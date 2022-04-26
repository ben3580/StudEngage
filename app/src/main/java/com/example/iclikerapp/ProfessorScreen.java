package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ProfessorScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_screen);
        // Function of create class button
        Button btn_createClass = (Button) findViewById(R.id.button_classroom);
        btn_createClass.setOnClickListener(view -> {
            OpenCreate_classroom();
        });

        // Function of create question button
        Button btn_createQuestion = (Button) findViewById(R.id.button_question);
        btn_createQuestion.setOnClickListener(view -> {
            OpenCreate_question();
        });
    }
    // After create class button is pressed, go to Classroom activity
    public void OpenCreate_classroom()
    {
        Intent intent = new Intent(this, CreateClassroom.class);
        startActivity(intent);
    }

    // After create question button is pressed, go to Question activity
    public void OpenCreate_question()
    {
        Intent intent = new Intent(this, CreateQuestion.class);
        startActivity(intent);
    }
}