package com.ultimatex.nsbm.model;

import org.mongodb.morphia.annotations.Embedded;

import java.util.ArrayList;

public class Result {

    @Embedded
    private ArrayList<SingleResult> year1sem1;
    @Embedded
    private ArrayList<SingleResult> year1sem2;
    @Embedded
    private ArrayList<SingleResult> year2sem1;
    @Embedded
    private ArrayList<SingleResult> year2sem2;
    @Embedded
    private ArrayList<SingleResult> year3sem1;
    @Embedded
    private ArrayList<SingleResult> year3sem2;
    @Embedded
    private ArrayList<SingleResult> year4sem1;
    @Embedded
    private ArrayList<SingleResult> year4sem2;

    public ArrayList<SingleResult> getYear1sem1() {
        return year1sem1;
    }

    public void setYear1sem1(ArrayList<SingleResult> year1sem1) {
        this.year1sem1 = year1sem1;
    }

    public ArrayList<SingleResult> getYear1sem2() {
        return year1sem2;
    }

    public void setYear1sem2(ArrayList<SingleResult> year1sem2) {
        this.year1sem2 = year1sem2;
    }

    public ArrayList<SingleResult> getYear2sem1() {
        return year2sem1;
    }

    public void setYear2sem1(ArrayList<SingleResult> year2sem1) {
        this.year2sem1 = year2sem1;
    }

    public ArrayList<SingleResult> getYear2sem2() {
        return year2sem2;
    }

    public void setYear2sem2(ArrayList<SingleResult> year2sem2) {
        this.year2sem2 = year2sem2;
    }

    public ArrayList<SingleResult> getYear3sem1() {
        return year3sem1;
    }

    public void setYear3sem1(ArrayList<SingleResult> year3sem1) {
        this.year3sem1 = year3sem1;
    }

    public ArrayList<SingleResult> getYear3sem2() {
        return year3sem2;
    }

    public void setYear3sem2(ArrayList<SingleResult> year3sem2) {
        this.year3sem2 = year3sem2;
    }

    public ArrayList<SingleResult> getYear4sem1() {
        return year4sem1;
    }

    public void setYear4sem1(ArrayList<SingleResult> year4sem1) {
        this.year4sem1 = year4sem1;
    }

    public ArrayList<SingleResult> getYear4sem2() {
        return year4sem2;
    }

    public void setYear4sem2(ArrayList<SingleResult> year4sem2) {
        this.year4sem2 = year4sem2;
    }
}
