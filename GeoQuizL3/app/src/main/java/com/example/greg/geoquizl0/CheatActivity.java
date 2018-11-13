package com.example.greg.geoquizl0;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private TextView mCheatTextView;

    private static final String CHEAT_ANSWER = "CHEAT_ANSWER";
    private static final String CHEAT_ANSWER_SHOWN = "CHEAT_ANSWER_SHOWN";
    private String mCorrectAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mCorrectAnswer = getIntent().getStringExtra(CHEAT_ANSWER);

        mCheatTextView = findViewById(R.id.cheatView);

        if(mCorrectAnswer.equals("B")) {
            String answer = "Prawda";
            mCheatTextView.setText(getString(R.string.answer_cheat, answer));
        }
        else {
            String answer = "Fałsz";
            mCheatTextView.setText(getString(R.string.answer_cheat, answer));
        }
        setAnswerShown(true);

    }

    public static Intent newIntent(Context packageContext, String answer) {

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
