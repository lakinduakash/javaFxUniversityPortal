package com.ultimatex.nsbm.model;

import jdk.nashorn.internal.ir.annotations.Reference;

public class SingleResult {

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
