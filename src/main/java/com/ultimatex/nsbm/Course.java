package com.ultimatex.nsbm;

public class Course {

    private String school;
    private String name;

    private Subject[] year1sem1;
    private Subject[] year1sem2;
    private Subject[] year2sem1;
    private Subject[] year2sem2;
    private Subject[] year3sem1;
    private Subject[] year3sem2;
    private Subject[] year4sem1;
    private Subject[] year4sem2;

    private int maxYears;

    public Subject[] getYear1sem1() {
        return year1sem1;
    }

    public void setYear1sem1(Subject[] year1sem1) {
        this.year1sem1 = year1sem1;
    }

    public Subject[] getYear1sem2() {
        return year1sem2;
    }

    public void setYear1sem2(Subject[] year1sem2) {
        this.year1sem2 = year1sem2;
    }

    public Subject[] getYear2sem1() {
        return year2sem1;
    }

    public void setYear2sem1(Subject[] year2sem1) {
        this.year2sem1 = year2sem1;
    }

    public Subject[] getYear2sem2() {
        return year2sem2;
    }

    public void setYear2sem2(Subject[] year2sem2) {
        this.year2sem2 = year2sem2;
    }

    public Subject[] getYear3sem1() {
        return year3sem1;
    }

    public void setYear3sem1(Subject[] year3sem1) {
        this.year3sem1 = year3sem1;
    }

    public Subject[] getYear3sem2() {
        return year3sem2;
    }

    public void setYear3sem2(Subject[] year3sem2) {
        this.year3sem2 = year3sem2;
    }

    public Subject[] getYear4sem1() {
        return year4sem1;
    }

    public void setYear4sem1(Subject[] year4sem1) {
        this.year4sem1 = year4sem1;
    }

    public Subject[] getYear4sem2() {
        return year4sem2;
    }

    public void setYear4sem2(Subject[] year4sem2) {
        this.year4sem2 = year4sem2;
    }

    public int getMaxYears() {
        return maxYears;
    }

    public void setMaxYears(int maxYears) {
        this.maxYears = maxYears;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
