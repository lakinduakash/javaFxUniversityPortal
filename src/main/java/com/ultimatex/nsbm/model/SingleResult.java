package com.ultimatex.nsbm.model;

import jdk.nashorn.internal.ir.annotations.Reference;

public class SingleResult {

    public static final String A_PLUS = "A+";
    public static final String A_ = "A";
    public static final String A_MINUS = "A-";
    public static final String B_PLUS = "B+";
    public static final String B_ = "B";
    public static final String B_MINUS = "B-";
    public static final String C_PLUS = "C+";
    public static final String C_ = "C";
    public static final String C_MINUS = "C-";

    @Reference
    private Subject subject;
    private String grade;

    public SingleResult(Subject subject, String grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public SingleResult() {

    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
