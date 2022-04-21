package com.example.iclikerapp.People;

import com.example.iclikerapp.Interface.MultipleChoice;
import com.example.iclikerapp.Interface.Question;
import com.example.iclikerapp.Interface.ShortAnswer;
import com.example.iclikerapp.Server.Classroom;

public class Professor extends User {

    public Professor(String username, String password){
        super(username, password);
    }

    public MultipleChoice createMultipleChoice(int weight, String questionText, String[] choiceText, String rightAnswer){
        return new MultipleChoice(weight, questionText, choiceText, rightAnswer);
    }

    public ShortAnswer createShortAnswer(int weight, String questionText, String rightAnswer){
        return new ShortAnswer(weight, questionText, rightAnswer);
    }

    @Override
    public void joinClassroom(Classroom classroom) {
        classroom.admitProfessor(this);
        joinedClassroom = classroom;
    }

    @Override
    public void exitClassroom(Classroom classroom) {
        classroom.removeProfessor(this);
        joinedClassroom = null;
    }

    //TODO: waiting for Question.java
    public void startQuestion(Question question){

    }

    // this function is different from our milestone 5, because I think also need the parameter to know which question to end
    //TODO: waiting for Question.java
    public void endQuestion(Question question){

    }
}
