package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ShowClassroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_classroom);

        Button classCPTS322 = (Button) findViewById(R.id.btn_classCpts322);
        Button classCPTS422 = (Button) findViewById(R.id.btn_classCpts422);
        Button classCPTS427 = (Button) findViewById(R.id.btn_classCpts427);

        // Go to classroom which shows the name of students
        classCPTS322.setOnClickListener(view -> {
            Intent intent = new Intent(this, InstructorClassroom.class);
            startActivity(intent);
        });

        classCPTS422.setOnClickListener(view -> {
            Intent intent = new Intent(this, InstructorClassroom.class);
            startActivity(intent);
        });

        classCPTS427.setOnClickListener(view -> {
            Intent intent = new Intent(this, InstructorClassroom.class);
            startActivity(intent);
        });
    }
}
