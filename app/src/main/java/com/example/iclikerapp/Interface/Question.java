package com.example.iclikerapp.Interface;

public abstract class Question {

    private int weight;
    private String questionText;

    public Question(int weight, String questionText){
        this.weight = weight;
        this.questionText = questionText;
    }

    public abstract void display();
}
