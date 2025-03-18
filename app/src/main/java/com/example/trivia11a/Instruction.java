package com.example.trivia11a;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Instruction extends AppCompatActivity {
    private TextView t1;
    @SuppressWarnings("MissingInflatedId")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        t1= findViewById(R.id.t1);
    }

}