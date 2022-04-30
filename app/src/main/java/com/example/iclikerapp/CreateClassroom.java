package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CreateClassroom extends AppCompatActivity {
    // Instantiate random
    Random rand = new Random();
    // Generate a random code for the classroom
    int rand_code = rand.nextInt(30000) + 20000;
    String class_code = Integer.toString(rand_code);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_classroom);

        TextView code = (TextView) findViewById(R.id.view_code);
        // Show code on the screen
        code.setText("" + class_code);

        // Function of Back button
        Button btn_testCode = (Button)findViewById(R.id.btn_testCode);
        btn_testCode.setOnClickListener(view -> {
            // Store the generated code using bundle
            Intent intent = new Intent(this, StudentScreen.class);
            Bundle bundle = new Bundle();
            bundle.putString("class_code", class_code);
            intent.putExtras(bundle);
            CreateClassroom.this.finish();
            startActivity(intent);
        });
    }
}