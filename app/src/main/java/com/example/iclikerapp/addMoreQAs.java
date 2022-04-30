package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class addMoreQAs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_more_qas);

        Button btn_goToProfScreen = (Button) findViewById(R.id.btn_goToProfScreen);
        btn_goToProfScreen.setOnClickListener(view -> {
            Intent intent = new Intent(this, InstructorScreen.class);
            startActivity(intent);
        });

        Button btn_addMoreQA = (Button) findViewById(R.id.btn_addMoreQAs);
        btn_addMoreQA.setOnClickListener(view -> {
            Intent intent = new Intent(this, CreateQuestion.class);
            startActivity(intent);
        });
    }
}