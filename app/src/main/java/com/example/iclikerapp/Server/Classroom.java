package com.example.iclikerapp.Server;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.iclikerapp.People.*;
import com.example.iclikerapp.Interface.*;
public class Classroom {

    private ArrayList<Professor> professors;
    private ArrayList<Student> students;
    // May defer to SQL server
    private ArrayList<Question> questions;
    private HashMap<Student, String> questionRecord;

    public Classroom(){
        this.professors = new ArrayList<Professor>();
        this.students = new ArrayList<Student>();
        this.questions = new ArrayList<Question>();
        this.questionRecord = new HashMap<Student, String>();
    }

    public void admitStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    public void admitProfessor(Professor professor){
        professors.add(professor);
    }

    public void removeProfessor(Professor professor){
        professors.remove(professor);
    }
}
