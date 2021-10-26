package com.buzz_ht.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.buzz_ht.quiz.model.Questions;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    String cate = null;
    int score = 0;
    int currentIndex;
    TextView titleOfSection, question, result, remark;
    RadioButton option1, option2, option3, option4;
    Button btnSubmit, btnNext;
    List<Questions> questions;
    RadioGroup radioGroup;
    Questions current;
    LottieAnimationView lottieAnimationView1;
    LottieAnimationView lottieAnimationView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initlz();

        Intent i = getIntent();
        int j = i.getIntExtra("Case", 0);

        switch (j) {
            //GK
            case 1:
                setUpViews();
                titleOfSection.setText("General Knowledge");
                cate = "General Knowledge";
                setList(j);
                setQuestion();
                break;
            //Science
            case 2:
                setUpViews();
                titleOfSection.setText("Science");
                cate = "Science";
                setList(j);
                setQuestion();
                break;
            //History
            case 3:
                setUpViews();
                titleOfSection.setText("History");
                cate = "History";
                setList(j);
                setQuestion();
                break;
            //History
            case 4:
                setUpViews();
                titleOfSection.setText("Geography");
                cate = "Geography";
                setList(j);
                setQuestion();
                break;
            //Geo
            case 5:
                setUpViews();
                titleOfSection.setText("Economics");
                cate = "Economics";
                setList(j);
                setQuestion();
                break;
            //Economics
            case 6:
                setUpViews();
                titleOfSection.setText("Constitution");
                cate = "Constitution";
                setList(j);
                setQuestion();
                break;
            //Constitution
            case 7:
                setUpViews();
                titleOfSection.setText("Synonyms");
                cate = "Synonym";
                setList(j);
                setQuestion();
                break;
        }


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkRadioGroup();
                printAnswer();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = currentIndex + 1;
                //lottieAnimationView1.clearAnimation();
                //lottieAnimationView2.clearAnimation();
                if (currentIndex == 2) {

                    btnNext.setText("See Result");
                    result.setVisibility(View.GONE);
                    remark.setVisibility(View.GONE);
                    btnNext.setEnabled(false);
                    lottieAnimationView1.setVisibility(View.GONE);
                    lottieAnimationView2.setVisibility(View.GONE);
                    btnSubmit.setEnabled(true);

                    setQuestion();

                }

                if (currentIndex == 3) {
                    //New Result Activity
                    Intent j = new Intent(getApplicationContext(), ResultActivity.class);
                    j.putExtra("Score", score);
                    j.putExtra("Category", cate);
                    startActivity(j);

                    //Toast.makeText(getApplicationContext(), "Total Score is " + score, Toast.LENGTH_SHORT).show();
                    finish();

                } else {
                    result.setVisibility(View.GONE);
                    remark.setVisibility(View.GONE);
                    btnNext.setEnabled(false);
                    lottieAnimationView1.setVisibility(View.GONE);
                    lottieAnimationView2.setVisibility(View.GONE);
                    btnSubmit.setEnabled(true);

                    setQuestion();

                }

            }
        });


    }


    private void setQuestion() {
        current = questions.get(currentIndex);
        question.setText(current.getDescription());
        option1.setText(current.getOption1());
        option2.setText(current.getOption2());
        option3.setText(current.getOption3());
        option4.setText(current.getOption4());

    }

    private void setUpViews() {
        currentIndex = 0;
        result.setVisibility(View.GONE);
        remark.setVisibility(View.GONE);
        btnNext.setEnabled(false);
        lottieAnimationView1.setVisibility(View.GONE);
        lottieAnimationView2.setVisibility(View.GONE);


    }

    private void setList(int i) {
        questions.clear();

        if (i == 1) {
            questions.add(new Questions("On whose report President promulgates President Rule in the State?", "Prime Minister", "Governor", "Chief Minister", "Home Minister",
                    "Chief Minister", "NA"));
            questions.add(new Questions("Which planet is known as Morning Star as well as Evening Star?", "Mercury", "Jupiter", "Saturn", "Venus", "Saturn", "NA"));
            questions.add(new Questions("In which one of the following is the Himalayan pass Shipki La located?", "Chandra Valley", "Hunza Valley", "Nubra Valley", "Sutlej Valley",
                    "Nubra Valley", "NA"));
        }
        if (i == 2) {
            questions.add(new Questions("Which variety of glass is heat resistant ?", "Hard Glass", "Flint Glass", "Pyrex Glass", "Bottle Glass", "Bottle Glass"
                    , "NA"));
            questions.add(new Questions("The metal used in storage batteries is:", "Iron", "Copper", "Lead", "Zinc", "Lead", "NA"));
            questions.add(new Questions("The most abundant element in the earth's crust is:", "O", "Al", "Si", "Fe", "Si", "NA"));
        }
        if (i == 3) {
            questions.add(new Questions("Which of the following Craftsmanships was not practised by the Aryans?", "Pottery", "Jewellery", "Carpentry", "Blacksmith",
                    "Carpentry", "NA"));
            questions.add(new Questions("When was Burma separated from India?", "1942", "1932", "1947", "1937", "1937", "NA"));
            questions.add(new Questions("The earliest known Indian script is?", "Devanagari", "Kharosti", "Mori", "Brahmi",
                    "Devanagari", "NA"));
        }
        if (i == 4) {
            questions.add(new Questions("The Bermuda Triangle lies in", "Eastern South Atlantic Ocean", "Western North Atlantic Ocean", "North Pacific Ocean", "South Pacific Ocean",
                    "Eastern South Atlantic Ocean", "NA"));
            questions.add(new Questions("Which one of the following is a landlocked country?", "Bulgaria", "Hungary", "Romania", "Ukraine", "Romania", "NA"));
            questions.add(new Questions("What is the name of Research Station established by Indian Government for conducting research in Antarctic?", "Dakshin Gangotri", "Yamunotri", "Uttari Gangotri", "None of these",
                    "Yamunotri", "NA"));
        }
        if (i == 5) {
            questions.add(new Questions("In India, the first bank of limited liability managed by Indians and founded in 1881 was:", "Hindustan Commercial Bank", "Oudh Commercial Bank",
                    "Punjab National Bank", "Punjab and Sind Bank", "Hindustan Commercial Bank", "NA"));
            questions.add(new Questions("In India, Inflation is measured by the?", "National Income Deflation", "Consumers Price Index for agriculture workers",
                    "Consumers Price Index for urban non-manual workers", " Wholesale Price Index number", "National Income Deflation", "NA"));
            questions.add(new Questions("In India, Paper Currency first started in the year?", "1774", "1810", "1852", "1861",
                    "1774", "NA"));
        }
        if (i == 6) {
            questions.add(new Questions("The President may appoint all the following except:", "Prime Minister", "Governor", "High Court judges", "Rajya Sabha Chairman",
                    "Prime Minister", "NA"));
            questions.add(new Questions("Plural Theory of Sovereignty emphasises the importance of?", "State", "Religion", "Individual", "Associations", "State", "NA"));
            questions.add(new Questions("The High Court which has the distinction of having the first woman Chief Justice is ?", "Himachal Pradesh High Court", "Delhi High Court",
                    "Guwahati High Court", "Allahabad High Court", "Himachal Pradesh High Court", "NA"));
        }
        if (i == 7) {
            questions.add(new Questions("BIZARRE", "Colourful", " Exotic", "Comical", "Strange", "Strange", "NA"));
            questions.add(new Questions("PRUNE", "Impose", "Lengthen", "Trim", "Mix", "Impose", "NA"));
            questions.add(new Questions("MUTATION", "Invariability", "Alteration", "Artificial", "Conspiracy", "Alteration", "NA"));
        }


    }

    public void checkRadioGroup() {
        int id = radioGroup.getCheckedRadioButtonId();

        switch (id) {
            case R.id.option1:
                current.setUserAnswer(current.getOption1());
                break;
            case R.id.option2:
                current.setUserAnswer(current.getOption2());
                break;
            case R.id.option3:
                current.setUserAnswer(current.getOption3());
                break;
            case R.id.option4:
                current.setUserAnswer(current.getOption4());
                break;

        }


    }

    public void printAnswer() {

        if (current.getAnswer().equals(current.getUserAnswer())) {

            score = score + 1;

            btnSubmit.setEnabled(false);

            lottieAnimationView1.setVisibility(View.VISIBLE);
            lottieAnimationView1.resumeAnimation();

            //result.setVisibility(View.VISIBLE);
            //result.setText("Your Answer is Correct");

            btnNext.setEnabled(true);

        } else {
            btnSubmit.setEnabled(false);

            lottieAnimationView2.setVisibility(View.VISIBLE);
            lottieAnimationView2.resumeAnimation();


            //result.setVisibility(View.VISIBLE);
            //result.setText("Your answer is Wrong");

            remark.setVisibility(View.VISIBLE);
            remark.setText("Correct answer is " + current.getAnswer());

            btnNext.setEnabled(true);

        }

    }

    private void initlz() {

        titleOfSection = findViewById(R.id.titleOfSection);
        question = findViewById(R.id.question);
        result = findViewById(R.id.result);
        remark = findViewById(R.id.remark);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        btnNext = findViewById(R.id.btnNext);
        btnSubmit = findViewById(R.id.btnSubmit);
        radioGroup = findViewById(R.id.radiogroup);
        questions = new ArrayList<>();
        lottieAnimationView1 = findViewById(R.id.lottie1);
        lottieAnimationView2 = findViewById(R.id.lottie2);
    }


}