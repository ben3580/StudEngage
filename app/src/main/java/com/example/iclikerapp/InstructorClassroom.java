package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

// Show list of students along with their scores
public class InstructorClassroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_classroom);

        Button btn_goToShowClasses = (Button) findViewById(R.id.btn_goToShowClass);
        btn_goToShowClasses.setOnClickListener(view -> {
            Intent intent = new Intent(this, ShowClassroom.class);
            startActivity(intent);
        });

    }
}










