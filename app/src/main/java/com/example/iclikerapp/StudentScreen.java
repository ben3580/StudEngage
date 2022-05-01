package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Must enter code that matched with the generated one in order to reach the question page
public class StudentScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_screen);

        // Enter code button
        Button btn_enterCode = (Button) findViewById(R.id.btn_enter_code);
        // After correct code is entered, we take the user to StudentClassroom screen

        btn_enterCode.setOnClickListener(view -> {
            try {
                // Get the input code from the user and store it as string
                String input_code = ((EditText) findViewById(R.id.input_code)).getText().toString();
                // Retrieve the code generated
//                Bundle bundle = getIntent().getExtras();
//                String class_code = bundle.getString("class_code");

                // Join class if the code is valid and matched
                if (input_code.equals("202122")) {
                    Intent intent = new Intent(this, StudentClassroom.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Invalid code", Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e){
                Toast.makeText(this, "Must enter a valid code...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}