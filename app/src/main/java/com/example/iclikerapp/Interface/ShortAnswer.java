package com.example.iclikerapp.Interface;

public class ShortAnswer extends Question{
    
    private String rightAnswer;

    public ShortAnswer(int weight, String questionText, String rightAnswer){
        super(weight, questionText);
        this.rightAnswer = rightAnswer;
    }

    // TODO: Connect to UI
    public void display(){

    }
}
