package com.example.iclikerapp;

import com.example.iclikerapp.People.*;

public class Main {
    public static void main(String[] args) {
        User testing = new User();

        testing.createAccount("abc", "ASDFGhjk123");

        System.out.println(testing.login("abc", "ASDFGhjk123"));
    }
}
