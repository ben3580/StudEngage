package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class StudentScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_screen);

        // Function of enter code button
        Button btn_enterCode = (Button) findViewById(R.id.btn_enter_code);
        // After correct code is entered, we take the user to StudentClassroom screen
        btn_enterCode.setOnClickListener(view -> {
            Intent intent = new Intent(this, StudentClassroom.class);
            startActivity(intent);
            Toast.makeText(this, "Entered classroom!", Toast.LENGTH_LONG).show();
        });
    }
}