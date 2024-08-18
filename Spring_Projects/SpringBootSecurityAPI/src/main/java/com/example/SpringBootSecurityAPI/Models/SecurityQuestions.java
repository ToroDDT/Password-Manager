package com.example.SpringBootSecurityAPI.Models;

import jakarta.persistence.Entity;
//@Entity
public class SecurityQuestions {
    private String security_question_1;
    private String security_answer_1;
    private String security_question_2;
    private String security_answer_2;
    private String security_question_3;
    private String security_answer_3;

    public SecurityQuestions(String security_question_1, String security_answer_1, String security_question_2, String security_answer_2, String security_question_3, String security_answer_3) {
        this.security_question_1 = security_question_1;
        this.security_answer_1 = security_answer_1;
        this.security_question_2 = security_question_2;
        this.security_answer_2 = security_answer_2;
        this.security_question_3 = security_question_3;
        this.security_answer_3 = security_answer_3;
    }


    public String getSecurity_question_1() {
        return security_question_1;
    }

    public void setSecurity_question_1(String security_question_1) {
        this.security_question_1 = security_question_1;
    }

    public String getSecurity_answer_1() {
        return security_answer_1;
    }

    public void setSecurity_answer_1(String security_answer_1) {
        this.security_answer_1 = security_answer_1;
    }

    public String getSecurity_question_2() {
        return security_question_2;
    }

    public void setSecurity_question_2(String security_question_2) {
        this.security_question_2 = security_question_2;
    }

    public String getSecurity_answer_2() {
        return security_answer_2;
    }

    public void setSecurity_answer_2(String security_answer_2) {
        this.security_answer_2 = security_answer_2;
    }

    public String getSecurity_question_3() {
        return security_question_3;
    }

    public void setSecurity_question_3(String security_question_3) {
        this.security_question_3 = security_question_3;
    }

    public String getSecurity_answer_3() {
        return security_answer_3;
    }

    public void setSecurity_answer_3(String security_answer_3) {
        this.security_answer_3 = security_answer_3;
    }



}
