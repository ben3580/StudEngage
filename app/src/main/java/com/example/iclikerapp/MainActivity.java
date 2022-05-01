package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.iclikerapp.Server.Communication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Make the flash screen looks better by hiding the Action bar
        getSupportActionBar().hide();
        // Connection to the server/database
        Communication home = new Communication();
        Connection homeCon = home.getConnection();
        String checkPassword = "";
        String error = "";
        String test = "";

        try{
            if(homeCon == null){
                System.out.println("Check Connection");
            }
            else{
                test = "Sarahharrisonb";
                //String query = "SELECT user_password FROM tblUser WHERE user_username = 'Sarahharrisonb'";
                String query = "SELECT * FROM tblUser";

                // statement is used for the command we run to the sql
                Statement stmt = homeCon.createStatement();
                // resultSet is used to fetch the data from sql, the object can be used like a iterator through rows
                ResultSet rs = stmt.executeQuery(query);

                // executeQuery(String) will execute the query with the command string
                stmt.executeQuery(query);
                homeCon.close();
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.d("sql error", error);
        }

        // Show the flash screen (with logo of our app) for 2.5s then go to Home screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, 2500);

    }
} 
