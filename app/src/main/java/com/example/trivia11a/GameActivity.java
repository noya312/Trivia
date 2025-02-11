package com.example.trivia11a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btna1, btna2, btna3,btna4;
    private TextView tvQuestion, tvQuestionNumber, tvPoints, tvGameOver;
    private Collection collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvQuestion= findViewById(R.id.tvQuestion);
        btna1= findViewById(R.id.btna1);
        btna2= findViewById(R.id.btna2);
        btna3= findViewById(R.id.btna3);
        btna4= findViewById(R.id.btna4);

        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);


        tvPoints = findViewById(R.id.tvPoints);
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvGameOver = findViewById(R.id.tvGameOver);

        tvGameOver.setVisibility(View.INVISIBLE);

        collection = new Collection();
        collection.initQuestions();

        nextQuestion();

    }

    private void nextQuestion() {
        Question q = collection.getNextQuestion();
        tvQuestion.setText(q.getQuestion());
        btna1.setText(q.getA1());
        btna2.setText(q.getA2());
        btna3.setText(q.getA3());
        btna4.setText(q.getA4());
    }

    @Override
    public void onClick(View v) {

    }
}