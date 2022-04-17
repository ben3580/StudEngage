package People;

import Interface.Question;

public class Professor extends User {
    
    //TODO: waiting for Question.java
    public Question createMultipleChoice(){
        return null;
    }

    //TODO: wait for other classes, should replace <Question> with class <Poll> after Poll is created
    public Question createPoll(){
        return null;
    }

    //TODO: wait for other classes, should replace <Question> with class <ShortAnswer> after ShortAnswer is created
    public Question createShortAnswer(){
        return null;
    }

    //TODO: waiting for Question.java
    public void startQuestion(Question question){

    }

    // this function is different from our milestone 5, because I think also need the parameter to know which question to end
    //TODO: waiting for Question.java
    public void endQuestion(Question question){

    }

    //TODO: wait for other classes
    public void gradeShortAnswer(){

    }
}
