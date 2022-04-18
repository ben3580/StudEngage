package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity{ //extends AppCompatActivity {
//
//    private static String ip =
//    private static String port =
//    private static String Classs =
//    private static String database =
    private static String sererUser = "studengage";
    private static String serverPass = "WSUpullman123*";
    private static String serverURL = "jdbc:sqlserver://studengage.database.windows.net:1433;database=StudEngage;user=studengage@studengage;password=WSUpullman123*;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";


    public static void main(String[] args) {

        Connection con = null;

        String serverUser = "studengage";
        String serverPass = "WSUpullman123*";
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(serverURL);
            Statement statement = con.createStatement();
            String qry = "SELECT stud_username FROM tblStudentUser WHERE stud_name = Sarah Harrison";

            rs = statement.executeQuery(qry);

            while(rs.next()){

                System.out.println(rs.getString(2));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





    }




//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
}