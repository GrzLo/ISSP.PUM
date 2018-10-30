package com.example.greg.geoquizl0;

public class Question {

    private int mTextResId;
    private String mCorrectAnswer;
    private String mUserAnswer;

    public Question(int textResId, String correctAnswer, String userAnswer) {
        this.mTextResId = textResId;
        this.mCorrectAnswer = correctAnswer;
        this.mUserAnswer = userAnswer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public String getmCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setmCorrectAnswer(String mCorrectAnswer) {
        this.mCorrectAnswer = mCorrectAnswer;
    }

    public String getmUserAnswer() {
        return mUserAnswer;
    }

    public void setmUserAnswer(String mUserAnswer) {
        this.mUserAnswer = mUserAnswer;
    }
}