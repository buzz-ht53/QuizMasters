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
            questions.add(new Questions("Among the following places, the average annual rainfall is highest at :", "Chennai", "Kolkata", "Shillong", "Thiruvananthpuram",
                    "Shillong", "NA"));
            questions.add(new Questions("Among the following rivers, which one is the longest?", "Godavari", "Krishna", "Mahanadi", "Narmada", "Godavari", "NA"));
            questions.add(new Questions("Among the following Union Territories of India, which one has the largest size?", "Pondicherry", "Lakshadweep", "Daman and Diu", "Chandigarh",
                    "Pondicherry", "NA"));
        }
        if (i == 2) {
            questions.add(new Questions("In humans, which protein transports oxygen from the lungs to the rest of body ?", "Collagen", "Keratin", "Lectin", "Hemoglobin", "Hemoglobin"
                    , "NA"));
            questions.add(new Questions("Vinegar is chemically known as", "Butanoic acid", "Ethanoic acid", "Methanoic acid", "Propanoic acid", "Ethanoic acid", "NA"));
            questions.add(new Questions("Which wave phenomenon is not common to both light and sound waves?", "Diffraction", "Polarisation", "Reflection", "Refraction", "Polarisation", "NA"));
        }
        if (i == 3) {
            questions.add(new Questions("At which place Mohenjodaro is situated?", "Punjab", "Afghanistan", "Gujarat", "Sindh Province of Pakistan",
                    "Sindh Province of Pakistan", "NA"));
            questions.add(new Questions("Azad Hind Fauj was founded in 1943 at which place?", "Singapore", "Kuala Lumpur", "Japan", "Mandalay", "Singapore", "NA"));
            questions.add(new Questions("At which place was the All India Khilafat Conference held in 1919?", "Delhi", "Lucknow", "Kolkata", "Mumbai",
                    "Delhi", "NA"));
        }
        if (i == 4) {
            questions.add(new Questions("The outermost layer of the Sun is called?", "Lithosphere", "Corona", "Chromosphere", "Photosphere", "Corona", "NA"));
            questions.add(new Questions("The phases of moon are caused by?", "The revolution of the earth", "The revolution of the moon", "The rotation of the earth", "The rotation of the moon",
                    "The rotation of the moon", "NA"));
            questions.add(new Questions("Mana Pass is located in?", "Uttarakhand", "Himachal Pradesh", "Jammu-Kashmir", "Uttar Pradesh",
                    "Uttarakhand", "NA"));
        }
        if (i == 5) {
            questions.add(new Questions("National Income of a country is also known as?", "Gross domestic product", "Net national product",
                    "Net Domestic product", "Gross national product", "Net national product", "NA"));
            questions.add(new Questions("When was the Reserve Bank of India taken over by the Government?", "1945", "1948", "1952", "1956", "1948", "NA"));
            questions.add(new Questions("The first Bank established in India was:", "Punjab National Bank", "Traders Bank", "State Bank of India", " Bank of Hindustan",
                    " Bank of Hindustan", "NA"));
        }
        if (i == 6) {
            questions.add(new Questions("Who is the Chief Law Officer of India ?", "Solicitor General", "Advocate General", "Attorney General", "Secretary, Law Department",
                    "Attorney General", "NA"));
            questions.add(new Questions("Who has the authority to proclaim emergency in the States?", "The President", "The Prime Minister", " The Chief Minister", "The Governor",
                    "The President", "NA"));
            questions.add(new Questions("The Constitution of India was adopted by the:", "Governor General", "British Parliament",
                    "Constituent Assembly", "Parliament of India", "Constituent Assembly", "NA"));
        }
        if (i == 7) {
            questions.add(new Questions("BIZARRE", "Colourful", " Exotic", "Comical", "Strange", "Strange", "NA"));
            questions.add(new Questions("PRUNE", "Impose", "Lengthen", "Trim", "Mix", "Trim", "NA"));
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