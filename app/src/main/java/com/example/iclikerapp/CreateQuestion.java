package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);

        // Function of "Add to classroom" button
        Button btn_addToClass = (Button) findViewById(R.id.btn_addToClass);
        btn_addToClass.setOnClickListener(view -> {
            Intent intent = new Intent(this, addMoreQAs.class);
            startActivity(intent);
            Toast.makeText(this, "MC questions added to class successfully",
                    Toast.LENGTH_SHORT).show();
        });
    }
}