package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfessorScreen extends AppCompatActivity {

    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_screen);
        button = (Button) findViewById(R.id.button_classroom);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                OpenCreate_classroom();
            }
        });
        button1 = (Button) findViewById(R.id.button_question);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                OpenCreate_question();
            }
        });
    }
    public void OpenCreate_question()
    {
        Intent intent = new Intent(this, CreateQuestion.class);
        startActivity(intent);
    }
    public void OpenCreate_classroom()
    {
        Intent intent = new Intent(this, Classroom.class);
        startActivity(intent);
    }
}