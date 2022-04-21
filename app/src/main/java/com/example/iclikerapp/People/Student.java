package com.example.iclikerapp.People;

import com.example.iclikerapp.Server.Classroom;

public class Student extends User {

    private int id;
    private double grade;

    public Student(String username, String password){
        super(username, password);
        this.id = 0;
        this.grade = 100.00;
    }

    @Override
    public void joinClassroom(Classroom classroom) {
        classroom.admitStudent(this);
        joinedClassroom = classroom;
    }

    @Override
    public void exitClassroom(Classroom classroom) {
        classroom.removeStudent(this);
        joinedClassroom = null;
    }

    //TODO: wait for other classes
    public void answerMultipleChoice(String answer){
        return;
    }

    public void answerShortAnswer(String answer){

    }
    //TODO: wait for other classes
    public void answerPoll(String answer){

    }

    public void setGrade(double grade){
        this.grade = grade;
    }

    public double checkGrades(){
        return grade;
    }
}
