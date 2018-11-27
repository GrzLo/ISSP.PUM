package com.example.greg.geoquizl0;

public class Question {

    public enum Answer {A, B, C, D};

    private int mTextResId;
    private Answer mCorrectAnswer;
    private Answer mUserAnswer;

    private boolean mHasCheated;

    public Question(int textResId, Answer correctAnswer, Answer userAnswer) {
        this.mTextResId = textResId;
        this.mCorrectAnswer = correctAnswer;
        this.mUserAnswer = userAnswer;
        this.mHasCheated = false;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public Answer getmCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setmCorrectAnswer(Answer mCorrectAnswer) {
        this.mCorrectAnswer = mCorrectAnswer;
    }

    public Answer getmUserAnswer() {
        return mUserAnswer;
    }

    public void setmUserAnswer(Answer mUserAnswer) {
        this.mUserAnswer = mUserAnswer;
    }

    public boolean getmHasCheated() {
        return mHasCheated;
    }

    public void setmHasCheated(boolean mHasCheated) {
        this.mHasCheated = mHasCheated;
    }
}