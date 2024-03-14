package com.example.SpringBootSecurityAPI.Models;

public class SecurityQuestions {
    private String questionOne;
    private String questionTwo;
    private String questionThree;
    public SecurityQuestions(String questionOne, String questionTwo, String questionThree) {
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
    }
    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public void setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
    }

}
