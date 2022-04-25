package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    //private final SignUp signUp = new SignUp();
    // Use EditText to get user input
    EditText username, password;
    // Testing purposes
    //EditText correct_user = signUp.get_user();
    //EditText correct_pass = signUp.get_password();
    // Click forgot password (to reset)
    TextView btn_forgotPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Function of Login button
        // Login and sign up button on our homepage
        Button btn_login = (Button) findViewById(R.id.btn_login);
        // After pressed Login
        btn_login.setOnClickListener(view -> {
            // Get the username and password given by the user
            username = (EditText) findViewById(R.id.enter_email);
            password = (EditText) findViewById(R.id.enter_password);

            // Get email and password from SignUp activity using Bundle
            //Also get error, not sure why (app won't run with this)
            /*Bundle bundle = getIntent().getExtras();
            String email = bundle.getString("email");
            String pw = bundle.getString("password");*/

            // Tell user that they cannot have empty username or password
            if(TextUtils.isEmpty(username.getText().toString()) ||
                    TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(this, "Email and password can't be empty", Toast.LENGTH_LONG).show();
            }

            // Show message telling the user they logged in successfully
            /*else if(username.getText().toString().equals(correct_user.getText().toString())
                    && password.getText().toString().equals(correct_pass.getText().toString())){*/
            else if(username.getText().toString().equals("email")
                    && password.getText().toString().equals("123")){
                Toast.makeText(this, username.getText() + " login successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, User.class);
                startActivity(intent);
            }

            // Show error message if username/password is incorrect
            else{
                Toast.makeText(this, "INVALID credentials", Toast.LENGTH_LONG).show();
            }


        });

        btn_forgotPw = (TextView)findViewById(R.id.btn_forgotPw);
        // After pressed Forgot password
        btn_forgotPw.setOnClickListener(view -> {
            Intent intent = new Intent(this, ResetPassword.class);
            startActivity(intent);
        });

        // Function of signUp button
        Button btn_signUp = (Button) findViewById(R.id.btn_signUp);
        // After pressed signUp
        btn_signUp.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        });

    }

}