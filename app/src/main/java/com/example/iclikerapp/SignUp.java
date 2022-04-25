package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iclikerapp.Server.Login;

public class SignUp extends AppCompatActivity {
    TextView btn_signIn;
    EditText new_username, new_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        // Function of signUp button
        Button btn_createAcc = (Button) findViewById(R.id.btn_createAcc);
        // After pressed signUp
        btn_createAcc.setOnClickListener(view -> {
            new_username = (EditText) findViewById(R.id.create_Email);
            new_password = (EditText) findViewById(R.id.create_Pw);

            //Toast.makeText(this, "Created successfully!", Toast.LENGTH_LONG).show();
            Toast.makeText(this, new_username.getText().toString() + " created!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);

        });

        updateUser();

        btn_signIn = (TextView) findViewById(R.id.click_signIn);
        btn_signIn.setOnClickListener(view -> {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        });
    }
        // Error when try to do this (Not sure why...)

    //String email = new_username.getText().toString();
    //String pw = new_password.getText().toString();
    private void updateUser(){
        // Store email and password using Bundle
        Intent intent = new Intent(this, Home.class);
        Bundle bundle = new Bundle();
        bundle.putString("email", "admin");
        bundle.putString("password", "123");
        intent.putExtras(bundle);
        //startActivity(intent);
    }


    /*public EditText get_user(){
        EditText username = new_username;
        return username;
    }

    public EditText get_password(){
        EditText password = new_password;
        return password;
    }
*/
}