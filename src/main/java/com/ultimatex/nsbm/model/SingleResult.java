package com.ultimatex.nsbm.model;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.util.HashMap;

/**
 * Single result object which have grade and subject
 */
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
    public static final String D_PLUS = "D+";
    public static final String D_ = "D";
    public static final String D_MINUS = "D-";
    public static final String E_ = "E";
    public static final String AB_ = "AB";

    public static final HashMap<String,Double> gradeMap =new HashMap<String, Double>() {{
        put("A+", 4.25);
        put("A", 4.0);
        put("A-", 3.75);
        put("B+", 3.25);
        put("B", 3.0);
        put("B-", 2.75);
        put("C+", 2.25);
        put("C", 2.0);
        put("C-", 1.75);
        put("D+", 1.25);
        put("D", 1.0);
        put("D-", 0.75);
        put("E", 0.25);
        put("AB", 0.0);
    }};

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
