package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/* Our 1st screen after the splash screen
   This is where the login happens and user can also choose to create a new account
   Currently, user can only click login if they've created an account
   (app will crash if user try to login when they haven't created an account)
 */

public class Home extends AppCompatActivity {

    // Get username and password in string format
    String username;
    String password;
    // Click forgot password (to reset)
    TextView btn_forgotPw;
    // Sign up button
    Button btn_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Function of Login button
        Button btn_login = (Button) findViewById(R.id.btn_login);
        // After pressed Login
        btn_login.setOnClickListener(view -> {
            // Get the username (in lowercase) and password given by the user
            username = ((EditText)findViewById(R.id.enter_email)).getText().toString().toLowerCase();
            password = ((EditText) findViewById(R.id.enter_password)).getText().toString();
            // Use Bundle to get data from another activity
            Bundle bundle = getIntent().getExtras();

            // Get email and password from SignUp activity using Bundle
            String email = bundle.getString("email");
            String pw = bundle.getString("password");

            // Tell user that they cannot have empty username or password
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Email and password can't be empty", Toast.LENGTH_LONG).show();
            }

            // Show message telling the user they logged in successfully
            // Can login only if match with sign up data
            else if (username.equals(email) && password.equals(pw)) {
                Toast.makeText(this, username + " login successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, User.class);
                startActivity(intent);
            }

            // Show error message if username/password is incorrect
            else {
                Toast.makeText(this, "INVALID credentials", Toast.LENGTH_LONG).show();
            }
        });

        // Function of forgot password
        btn_forgotPw = (TextView)findViewById(R.id.btn_forgotPw);
        btn_forgotPw.setOnClickListener(view -> {
            Intent intent = new Intent(this, ResetPassword.class);
            startActivity(intent);
        });

        // Function of signUp button
        btn_signUp = (Button) findViewById(R.id.btn_signUp);
        btn_signUp.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        });
    }
}