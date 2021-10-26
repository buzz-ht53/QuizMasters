package com.buzz_ht.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ResultActivity extends AppCompatActivity {

    TextView textView, prevScore;
    TextView tvScoreGk, tvScoreCon, tvScoreHis, tvScoreGeo, tvScoreSyn, tvScoreEco, tvScoreSci;
    Button saveScore, displayScore;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.tvresult);
        saveScore = findViewById(R.id.saveScore);
        // prevScore=findViewById(R.id.prevScore);
        displayScore = findViewById(R.id.displayScore);
        tvScoreGk = findViewById(R.id.tvScoreGk);
        tvScoreCon = findViewById(R.id.tvScoreCon);
        tvScoreHis = findViewById(R.id.tvScoreHis);
        tvScoreGeo = findViewById(R.id.tvScoreGeo);
        tvScoreSyn = findViewById(R.id.tvScoreSyn);
        tvScoreEco = findViewById(R.id.tvScoreEco);
        tvScoreSci = findViewById(R.id.tvScoreSci);


        Intent i = getIntent();
        int score = i.getIntExtra("Score", 0);
        String category = i.getStringExtra("Category");
        sharedPreferences = getSharedPreferences(category, Context.MODE_PRIVATE);

        // databaseReference= FirebaseDatabase.getInstance().getReference("user");

        textView.setText(category + "\n You got " + score + "/3 correct");

        saveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putInt("score", score);
                editor.putString("category", category);
                editor.commit();

            }
        });

        displayScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sp = getApplicationContext().getSharedPreferences(category, Context.MODE_PRIVATE);
                int j = sp.getInt("score", 0);
                String set = Integer.toString(j);
                //prevScore.setText(set);

                SharedPreferences sp1 = getApplicationContext().getSharedPreferences("General Knowledge", Context.MODE_PRIVATE);
                int gk1 = sp1.getInt("score", 0);
                String scoreGK1 = Integer.toString(gk1);
                tvScoreGk.setText(scoreGK1);

                SharedPreferences sp2 = getApplicationContext().getSharedPreferences("Science", Context.MODE_PRIVATE);
                int gk2 = sp2.getInt("score", 0);
                String scoreGK2 = Integer.toString(gk2);
                tvScoreSci.setText(scoreGK2);

                SharedPreferences sp3 = getApplicationContext().getSharedPreferences("History", Context.MODE_PRIVATE);
                int gk3 = sp3.getInt("score", 0);
                String scoreGK3 = Integer.toString(gk3);
                tvScoreHis.setText(scoreGK3);

                SharedPreferences sp4 = getApplicationContext().getSharedPreferences("Geography", Context.MODE_PRIVATE);
                int gk4 = sp4.getInt("score", 0);
                String scoreGK4 = Integer.toString(gk4);
                tvScoreGeo.setText(scoreGK4);

                SharedPreferences sp5 = getApplicationContext().getSharedPreferences("Economics", Context.MODE_PRIVATE);
                int gk5 = sp5.getInt("score", 0);
                String scoreGK5 = Integer.toString(gk5);
                tvScoreEco.setText(scoreGK5);

                SharedPreferences sp6 = getApplicationContext().getSharedPreferences("Constitution", Context.MODE_PRIVATE);
                int gk6 = sp6.getInt("score", 0);
                String scoreGK6 = Integer.toString(gk6);
                tvScoreCon.setText(scoreGK6);

                SharedPreferences sp7 = getApplicationContext().getSharedPreferences("Synonym", Context.MODE_PRIVATE);
                int gk7 = sp7.getInt("score", 0);
                String scoreGK7 = Integer.toString(gk7);
                tvScoreSyn.setText(scoreGK7);


            }
        });


    }
}