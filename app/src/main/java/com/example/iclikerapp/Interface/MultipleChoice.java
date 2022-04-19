package com.example.iclikerapp.Interface;

public class MultipleChoice extends Question{
    
    private String[] choiceText;
    private String rightAnswer;

    public MultipleChoice(int weight, String questionText, String[] choiceText, String rightAnswer){
        super(weight, questionText);
        this.choiceText = choiceText;
        this.rightAnswer = rightAnswer;
    }

    // TODO: Connect to UI
    public void display(){

    }
}
