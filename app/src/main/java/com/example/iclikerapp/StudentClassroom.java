package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StudentClassroom extends AppCompatActivity {

    private QuestionLib myQuestionLib = new QuestionLib();

    // Initializing the text views and all the buttons in Student classroom
    private TextView scoreView;
    private TextView questionView;
    private Button btn_choice1;
    private Button btn_choice2;
    private Button btn_choice3;
    // Initializing the correct answer, score and the question #
    private String answer;
    private int score = 0;
    private int questionNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_classroom);

        scoreView = (TextView) findViewById(R.id.score);
        questionView = (TextView) findViewById(R.id.question);
        btn_choice1 = (Button) findViewById(R.id.choice1);
        btn_choice2 = (Button) findViewById(R.id.choice2);
        btn_choice3 = (Button) findViewById(R.id.choice3);
        // We update the question (show to the screen)

        updateQuestion();

        // When pressed 1st choice button
        btn_choice1.setOnClickListener(view -> {
            // If the answer is correct we go to the next question
            // and update score
            if (btn_choice1.getText() == answer){
                score += 1;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                updateScore(score);
                updateQuestion();
            }
            // If the answer is incorrect we also go to the next question
            // but we do not update the score
            else{
                Toast.makeText(this, "Incorrect :(", Toast.LENGTH_SHORT).show();
                updateQuestion();
            }
        });

        // When pressed 2nd choice button
        btn_choice2.setOnClickListener(view -> {
            // If the answer is correct we go to the next question
            // and update score
            if (btn_choice2.getText() == answer){
                score += 1;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                updateScore(score);
                updateQuestion();
            }
            // If the answer is incorrect we also go to the next question
            // but we do not update the score
            else{
                Toast.makeText(this, "Incorrect :(", Toast.LENGTH_SHORT).show();
                updateQuestion();
            }
        });

        // When pressed 3rd choice button
        btn_choice3.setOnClickListener(view -> {
            // If the answer is correct we go to the next question
            // and update score
            if (btn_choice3.getText() == answer){
                score += 1;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                updateScore(score);
                updateQuestion();
            }
            // If the answer is incorrect we also go to the next question
            // but we do not update the score
            else{
                Toast.makeText(this, "Incorrect :(", Toast.LENGTH_SHORT).show();
                updateQuestion();
            }
        });
    }
    // Show the questions along with the choices
    private void updateQuestion(){
        // Display the questions and choices
        // The IF/ELSE statement will prevent the app from crashing when run out of questions
        if (questionNum == myQuestionLib.questions.length){
            Intent intent = new Intent(this, ResultScreen.class);
            Bundle bundle = new Bundle();
            bundle.putInt("finalScore", score);
            intent.putExtras(bundle);
            StudentClassroom.this.finish();
            startActivity(intent);
        }
        else {
            questionView.setText(myQuestionLib.getQuestion(questionNum));
            btn_choice1.setText(myQuestionLib.getChoice1(questionNum));
            btn_choice2.setText(myQuestionLib.getChoice2(questionNum));
            btn_choice3.setText(myQuestionLib.getChoice3(questionNum));
            // Store the correct answer
            answer = myQuestionLib.getCorrectAns(questionNum);
            // Increment to go to next number
            questionNum++;
        }
    }
    // Show the new score (in string)
    private void updateScore(int pts){
        scoreView.setText("" + score);

    }
}