package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button btn_Instructor = (Button) findViewById(R.id.btn_Instructor);
        // After pressed signUp
        btn_Instructor.setOnClickListener(view -> {
            Intent intent = new Intent(this, ProfessorScreen.class);
            startActivity(intent);
        });


        Button btn_Student = (Button) findViewById(R.id.btn_Student);
        // After pressed signUp
        btn_Student.setOnClickListener(view -> {
            Intent intent = new Intent(this, StudentScreen.class);
            startActivity(intent);
        });
    }
}