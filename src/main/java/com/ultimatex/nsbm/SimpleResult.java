package com.ultimatex.nsbm;

public class SimpleResult {

    public static final String A_PLUS = "A+";
    public static final String A_ = "A";
    public static final String A_MINUS = "A-";
    public static final String B_PLUS = "B+";
    public static final String B_ = "B";
    public static final String B_MINUS = "B-";
    public static final String C_PLUS = "C+";
    public static final String C_ = "C";
    public static final String C_MINUS = "C-";

    private Subject subject;
    private String result;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
