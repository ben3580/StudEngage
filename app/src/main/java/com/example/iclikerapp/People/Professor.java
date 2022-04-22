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

    public void startQuestion(Question question){
        joinedClassroom.setActiveQuestion(question);
    }

    public void endQuestion(Question question){
        joinedClassroom.setActiveQuestion(null);
    }
}
