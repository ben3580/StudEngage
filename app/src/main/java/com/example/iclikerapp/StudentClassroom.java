package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iclikerapp.Server.Communication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// This is for testing purposes of showing multiple questions along with choices to the screen
// Later on we will get the questions and choices from our database (that are entered by instructor)

public class StudentClassroom extends AppCompatActivity {

    // Create myQuestionLib object (from QuestionLib class)
    private final QuestionLib myQuestionLib = new QuestionLib();

    // Initializing the text views and all the buttons in Student classroom
    private TextView scoreView;
    private TextView questionView;
    private Button btn_choice1;
    private Button btn_choice2;
    private Button btn_choice3;
    // Initializing the question text, correct answer, choice texts, score and the question #
    private String questionText;
    private String answer;
    private String choice1;
    private String choice2;
    private String choice3;

    private int score = 0;
    // question_ID
    private int questionNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_classroom);

        // Get the textView and Button by their IDs
        scoreView = (TextView) findViewById(R.id.score);
        questionView = (TextView) findViewById(R.id.question);
        btn_choice1 = (Button) findViewById(R.id.choice1);
        btn_choice2 = (Button) findViewById(R.id.choice2);
        btn_choice3 = (Button) findViewById(R.id.choice3);
        // We update the question (show questions the screen)
        updateQuestion();

        // When pressed 1st choice button
        btn_choice1.setOnClickListener(view -> {
            // If the answer is correct we go to the next question and update the score
            if (btn_choice1.getText().equals(answer)){
                score += 1;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            }
            // If the answer is incorrect we also go to the next question but we do not update the score
            else Toast.makeText(this, "Incorrect :(", Toast.LENGTH_SHORT).show();

            updateQuestion();
        });

        // When pressed 2nd choice button
        btn_choice2.setOnClickListener(view -> {
            // If the answer is correct we go to the next question and update the score
            if (btn_choice2.getText().equals(answer)){
                score += 1;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            }
            // If the answer is incorrect we also go to the next question but we do not update the score
            else Toast.makeText(this, "Incorrect :(", Toast.LENGTH_SHORT).show();

            updateQuestion();
        });

        // When pressed 3rd choice button
        btn_choice3.setOnClickListener(view -> {
            // If the answer is correct we go to the next question and update the score
            if (btn_choice3.getText().equals(answer)){
                score += 1;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            }
            // If the answer is incorrect we also go to the next question but we do not update the score
            else Toast.makeText(this, "Incorrect :(", Toast.LENGTH_LONG).show();

            updateQuestion();
        });
    }
    // Show the questions along with the choices
    private void updateQuestion(){
        // Display the questions and choices
        // The IF/ELSE statement will prevent the app from crashing when run out of questions
        // if on last question and user selects answer --> goes to results screen
        updateScore(score);
        if (questionNum == 4){
            Intent intent = new Intent(this, ResultScreen.class);
            Bundle bundle = new Bundle();
            bundle.putInt("finalScore", score);
            intent.putExtras(bundle);
            StudentClassroom.this.finish();
            startActivity(intent);
        }
        else {

            String error = "";

            Communication com = new Communication();
            Connection studClassCon = com.getConnection();

            try{
                if(studClassCon == null){
                    error = "Check Connection";
                }
                else{
                    //Run Query based off of question number (PK)
                    String query = "SELECT * FROM tblQuestion WHERE question_ID = " + questionNum;
                    Statement stmt = studClassCon.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    if(rs.next()){

                        //getting values from tblQuestion
                        questionText = rs.getString("question_text");
                        choice1 = rs.getString("question_choiceText1");
                        choice2 = rs.getString("question_choiceText2");
                        choice3 = rs.getString("question_choiceText3");
                        answer = rs.getString("question_answer");

                        questionView.setText(questionText);
                        btn_choice1.setText(choice1);
                        btn_choice2.setText(choice2);
                        btn_choice3.setText(choice3);

                        // Increment to go to next number
                        questionNum++;
                    }
                    else{
                        error = "invalid query";
                    }

                    studClassCon.close();
                }
            } catch (SQLException throwables) {
                Log.d("sql error", error);
            }
        }
    }
    // Show the new score (in string)
    private void updateScore(int pts){
        scoreView.setText("" + score);
    }
}
