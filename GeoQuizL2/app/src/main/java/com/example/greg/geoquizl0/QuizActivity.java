package com.example.greg.geoquizl0;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;



public class QuizActivity extends AppCompatActivity {

    private ImageButton mTrueButton;
    private ImageButton mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    private List<ImageButton> mButtonList = new ArrayList<>();

    private int mCurrentIndex = 0;
    private int mScore = 0;
    private int mQuestionsAnswered = 0;

    private Question[] mQuestionsBank = new Question[] {
            new Question(R.string.question_stolica_polski, "B", null),
            new Question(R.string.question_stolica_dolnego_slaska, "A", null),
            new Question(R.string.question_sniezka, "B", null),
            new Question(R.string.question_wisla,"B", null)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mFalseButton = findViewById(R.id.falseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answerStatus = mQuestionsBank[mCurrentIndex].getmUserAnswer();

                if(answerStatus == null) {
                    checkAnswer("A");
                    updateQuestion();
                }
            }
        });

        mTrueButton = findViewById(R.id.trueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = mQuestionsBank[mCurrentIndex].getmUserAnswer();

                if(userAnswer == null) {
                    checkAnswer("B");
                    updateQuestion();
                }
            }
        });

        mPrevButton = findViewById(R.id.prevButton);
        mPrevButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1 + mQuestionsBank.length) % mQuestionsBank.length;
                updateQuestion();
            }
        });

        mNextButton = findViewById(R.id.nextButton);
        mNextButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionsBank.length;
                updateQuestion();
            }
        });

        mButtonList.add(mFalseButton);
        mButtonList.add(mTrueButton);
        mButtonList.add(mPrevButton);
        mButtonList.add(mNextButton);

        mQuestionTextView = findViewById(R.id.textView);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionsBank.length;
                updateQuestion();
            }
        });

        updateQuestion();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("current_index", mCurrentIndex);
        outState.putInt("current_score", mScore);
        outState.putInt("current_answered", mQuestionsAnswered);

        ArrayList<String> userAnswers = new ArrayList<>();
        for(Question q : mQuestionsBank) {
            userAnswers.add(q.getmUserAnswer());
        }
        outState.putStringArrayList("user_answers", userAnswers);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mCurrentIndex = savedInstanceState.getInt("current_index");
        mScore = savedInstanceState.getInt("current_score");
        mQuestionsAnswered = savedInstanceState.getInt("current_answered");

        ArrayList<String> userAnswers = savedInstanceState.getStringArrayList("user_answers");
        for(Question q : mQuestionsBank) {
            q.setmUserAnswer(userAnswers.get(0));
            userAnswers.remove(0);
        }
        updateQuestion();
    }

    public void updateQuestion() {
        int questionId = mQuestionsBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(questionId);
        {
            String userAnswer = mQuestionsBank[mCurrentIndex].getmUserAnswer();
            String correctAnswer = mQuestionsBank[mCurrentIndex].getmCorrectAnswer();
            mTrueButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mFalseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            if (userAnswer != null) {
                if (userAnswer == correctAnswer) {
                    for (ImageButton b : mButtonList) {
                        if (userAnswer.equals((String) b.getTag())) {
                            b.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                        }
                    }
                } else {
                    for (ImageButton b : mButtonList) {
                        if (userAnswer.equals((String) b.getTag())) {
                            b.setBackgroundColor(getResources().getColor(R.color.colorRed));
                        }
                        if (correctAnswer.equals((String) b.getTag())) {
                            b.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                        }
                    }
                }
            }
        }
        if(mQuestionsAnswered == mQuestionsBank.length) {
            AlertDialog.Builder gameOver = new AlertDialog.Builder(this);
            gameOver.setTitle("Game Over!")
                    .setMessage("Twój wynik to: " + String.valueOf(mScore))
                    .show();
            mQuestionsAnswered = 0;
        }
    }

    public void checkAnswer(String userAnswerChoice) {
        if(userAnswerChoice == mQuestionsBank[mCurrentIndex].getmCorrectAnswer()) {
            mQuestionsBank[mCurrentIndex].setmUserAnswer(userAnswerChoice);
            mScore += 1;
            mQuestionsAnswered +=1;
            Toast toast = Toast.makeText(this, R.string.answer_correct, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 150);
            toast.show();
        }
        else {
            mQuestionsBank[mCurrentIndex].setmUserAnswer(userAnswerChoice);
            mQuestionsAnswered +=1;
            Toast toast = Toast.makeText(this, R.string.answer_incorrect, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 150);
            toast.show();
        }
    }
}