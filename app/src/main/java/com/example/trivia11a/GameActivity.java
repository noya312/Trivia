package com.example.trivia11a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btna1, btna2, btna3,btna4;
    private TextView tvQuestion, tvQuestionNumber, tvPoints, tvGameOver;
    private Question q;
    private Collection2 collection2;
    private LinearLayout nn;
    private int points=0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String str = intent.getStringExtra("nncolor");
        nn = findViewById(R.id.activity_game);
        setBackgroundColor(str);

        

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

        collection2 = new Collection2();
        collection2.initQuestions();

        nextQuestion();
    }

    private void nextQuestion() {
        if (collection2.isNotLastQuestion())
        {
            q = collection2.getNextQuestion();


            tvQuestion.setText(q.getQuestion());
            btna1.setText(q.getA1());
            btna2.setText(q.getA2());
            btna3.setText(q.getA3());
            btna4.setText(q.getA4());
        }
        else
        {
            tvGameOver.setVisibility(View.VISIBLE);
            createDialog();
        }
    }

    private void createDialog()
    {
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.show();
    }

    @Override
    public void onClick(View v)
    {
        if (v==btna1)
        {
            if (q.getCorrect()==1)
                points++;
        }
        if (v==btna2)
        {
            if (q.getCorrect()==2)
                points++;
        }
        if (v==btna3)
        {
            if (q.getCorrect()==3)
                points++;
        }
        if (v==btna4)
        {
            if (q.getCorrect()==4)
                points++;
        }
        tvPoints.setText("points: " + points);
        if(collection2.isNotLastQuestion())
        {
            tvQuestionNumber.setText("Question number: "+ (collection2.getIndex()+1));
        }
        nextQuestion();
    }

    public void reset()
    {
        this.points=0;
        collection2.initQuestions();
        tvPoints.setText("Points: "+ 0);
        tvQuestionNumber.setText("Question number: "+ 1);
        tvGameOver.setVisibility(View.INVISIBLE);
        this.nextQuestion();
    }

    public void setBackgroundColor(String color)
    {
        switch (color)
        {
            case "Red":
            {
                nn.setBackgroundColor(Color.RED);
                break;
            }
            case "Blue":
            {
                nn.setBackgroundColor(Color.BLUE);
                break;
            }
            case "Pink":
            {
                nn.setBackgroundColor(Color.argb(255,255,192,203));
                break;
            }
            case "Yellow":
            {
                nn.setBackgroundColor(Color.YELLOW);
                break;
            }

            default:
                nn.setBackgroundColor(Color.WHITE);
        }
    }
}