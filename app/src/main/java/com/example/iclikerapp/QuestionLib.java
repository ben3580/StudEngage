package com.example.iclikerapp;

public class QuestionLib {
    public static String[] questions = {
            "Which is the best programming language",
            "What class is CPTS 317",
            "Who's Alan Turing?"
    };

    private String choices[][] = {
            {"java", "python", "C/C++"},
            {"Multivariable Calculus", "Intro to Machine learning", "Intro to Automata" },
            {"Comedian", "Mathematician", "Artist"}
    };

    private String correctAns [] = {
            "python", "Intro to Automata", "Mathematician"
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice1 = choices[a][0];
        return choice1;
    }

    public String getChoice2(int a){
        String choice2 = choices[a][1];
        return choice2;
    }
    public String getChoice3(int a){
        String choice3 = choices[a][2];
        return choice3;
    }

    public String getCorrectAns(int a) {
        String correctAnswer = correctAns[a];
        return correctAnswer;
    }
}
