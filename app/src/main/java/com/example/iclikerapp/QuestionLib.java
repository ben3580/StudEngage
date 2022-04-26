package com.example.iclikerapp;

/* This is just for testing purposes to see if the program works
   Later on we will get the questions directly from our database
 */

public class QuestionLib {

    // String array to store the questions
    public static String[] questions = {
            "Which is the best programming language",
            "What class is CPTS 317",
            "Who's Alan Turing?"
    };

    // 2 dimensional array string to store the choices for each question
    private final String[][] choices = {
            {"java", "python", "C/C++"},
            {"Multivariable Calculus", "Intro to Machine learning", "Intro to Automata" },
            {"Comedian", "Mathematician", "Artist"}
    };

    // String array to store the correct answers for each question
    private final String[] correctAns = {
            "python", "Intro to Automata", "Mathematician"
    };

    // our test question
    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }
    // 1st choice
    public String getChoice1(int a){
        String choice1 = choices[a][0];
        return choice1;
    }
    // 2nd choice
    public String getChoice2(int a){
        String choice2 = choices[a][1];
        return choice2;
    }
    // 3rd choice
    public String getChoice3(int a){
        String choice3 = choices[a][2];
        return choice3;
    }

    // The correct answer
    public String getCorrectAns(int a) {
        String correctAnswer = correctAns[a];
        return correctAnswer;
    }
}
