package com.example.aalam.dashboardapp;

/**
 * Created by aalam on 4/5/17.
 */

public class TrackDayQuestions {
    String question, answer;
    Boolean state;

    public TrackDayQuestions(String question, String answer,Boolean state){
        this.question = question;
        this.answer = answer;
        this.state = state;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getState(){ return state; }

}
