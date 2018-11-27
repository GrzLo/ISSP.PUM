package com.example.greg.geoquizl0;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class CheatActivity extends AppCompatActivity {

    private TextView mCheatTextView;

    private static final String CHEAT_ANSWER = "CHEAT_ANSWER";
    private static final String CHEAT_ANSWER_SHOWN = "CHEAT_ANSWER_SHOWN";
    private Serializable mCorrectAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mCorrectAnswer = getIntent().getSerializableExtra(CHEAT_ANSWER);

        mCheatTextView = findViewById(R.id.cheatView);

        if(mCorrectAnswer.equals(Question.Answer.B)) {
            String answer = "Prawda";
            mCheatTextView.setText(getString(R.string.answer_cheat, answer));
        }
        else {
            String answer = "Fałsz";
            mCheatTextView.setText(getString(R.string.answer_cheat, answer));
        }
        setAnswerShown(true);

    }

    public static Intent newIntent(Context packageContext, Question.Answer answer) {

        Intent intent= new Intent(packageContext, CheatActivity.class);
        intent.putExtra(CHEAT_ANSWER, answer);
        return intent;
    }

    public void setAnswerShown(boolean isAnswerShow) {
        Intent intent = new Intent();
        intent.putExtra(CHEAT_ANSWER_SHOWN, isAnswerShow);
        setResult(RESULT_OK, intent);
    }

    public static boolean wasAnswerShown(Intent intent) {
        return intent.getBooleanExtra(CHEAT_ANSWER_SHOWN, false);
    }
}
