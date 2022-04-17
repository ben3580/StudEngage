package People;

public class Student extends User {

    int id;
    double grade;

    public Student(){
        this.id = 0;
        this.grade = 100.00;
    }

    //TODO: wait for other classes
    public void answerMultipleChoice(String answer){
        return;
    }

    // Do we still need this?
    public void answerShortAnswer(String answer){

    }
    //TODO: wait for other classes
    public void answerPoll(String answer){

    }
    
    //TODO: wait for other classes
    public double checkGrades(){
        return 0;
    }
}
