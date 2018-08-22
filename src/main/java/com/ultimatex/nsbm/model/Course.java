package com.ultimatex.nsbm.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;

@Entity("course")
public class Course {

    //undergraduate
    public static final int TYPE_UN = 0;
    //master degree
    public static final int TYPE_MA = 1;

    @Id
    private ObjectId id;

    private String school;
    private String name;
    private int type;

    @Indexed(options = @IndexOptions(unique = true))
    private String code;


    @Reference
    private ArrayList<Subject> year1sem1;
    @Reference
    private ArrayList<Subject> year1sem2;
    @Reference
    private ArrayList<Subject> year2sem1;
    @Reference
    private ArrayList<Subject> year2sem2;
    @Reference
    private ArrayList<Subject> year3sem1;
    @Reference
    private ArrayList<Subject> year3sem2;
    @Reference
    private ArrayList<Subject> year4sem1;
    @Reference
    private ArrayList<Subject> year4sem2;

    @Reference
    private ArrayList<Subject> year1sem1o;
    @Reference
    private ArrayList<Subject> year1sem2o;
    @Reference
    private ArrayList<Subject> year2sem1o;
    @Reference
    private ArrayList<Subject> year2sem2o;
    @Reference
    private ArrayList<Subject> year3sem1o;
    @Reference
    private ArrayList<Subject> year3sem2o;
    @Reference
    private ArrayList<Subject> year4sem1o;
    @Reference
    private ArrayList<Subject> year4sem2o;

    private int maxYears;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public ArrayList<Subject> getYear1sem1() {
        return year1sem1;
    }

    public void setYear1sem1(ArrayList<Subject> year1sem1) {
        this.year1sem1 = year1sem1;
    }

    public ArrayList<Subject> getYear1sem2() {
        return year1sem2;
    }

    public void setYear1sem2(ArrayList<Subject> year1sem2) {
        this.year1sem2 = year1sem2;
    }

    public ArrayList<Subject> getYear2sem1() {
        return year2sem1;
    }

    public void setYear2sem1(ArrayList<Subject> year2sem1) {
        this.year2sem1 = year2sem1;
    }

    public ArrayList<Subject> getYear2sem2() {
        return year2sem2;
    }

    public void setYear2sem2(ArrayList<Subject> year2sem2) {
        this.year2sem2 = year2sem2;
    }

    public ArrayList<Subject> getYear3sem1() {
        return year3sem1;
    }

    public void setYear3sem1(ArrayList<Subject> year3sem1) {
        this.year3sem1 = year3sem1;
    }

    public ArrayList<Subject> getYear3sem2() {
        return year3sem2;
    }

    public void setYear3sem2(ArrayList<Subject> year3sem2) {
        this.year3sem2 = year3sem2;
    }

    public ArrayList<Subject> getYear4sem1() {
        return year4sem1;
    }

    public void setYear4sem1(ArrayList<Subject> year4sem1) {
        this.year4sem1 = year4sem1;
    }

    public ArrayList<Subject> getYear4sem2() {
        return year4sem2;
    }

    public void setYear4sem2(ArrayList<Subject> year4sem2) {
        this.year4sem2 = year4sem2;
    }

    public ArrayList<Subject> getYear1sem1o() {
        return year1sem1o;
    }

    public void setYear1sem1o(ArrayList<Subject> year1sem1o) {
        this.year1sem1o = year1sem1o;
    }

    public ArrayList<Subject> getYear1sem2o() {
        return year1sem2o;
    }

    public void setYear1sem2o(ArrayList<Subject> year1sem2o) {
        this.year1sem2o = year1sem2o;
    }

    public ArrayList<Subject> getYear2sem1o() {
        return year2sem1o;
    }

    public void setYear2sem1o(ArrayList<Subject> year2sem1o) {
        this.year2sem1o = year2sem1o;
    }

    public ArrayList<Subject> getYear2sem2o() {
        return year2sem2o;
    }

    public void setYear2sem2o(ArrayList<Subject> year2sem2o) {
        this.year2sem2o = year2sem2o;
    }

    public ArrayList<Subject> getYear3sem1o() {
        return year3sem1o;
    }

    public void setYear3sem1o(ArrayList<Subject> year3sem1o) {
        this.year3sem1o = year3sem1o;
    }

    public ArrayList<Subject> getYear3sem2o() {
        return year3sem2o;
    }

    public void setYear3sem2o(ArrayList<Subject> year3sem2o) {
        this.year3sem2o = year3sem2o;
    }

    public ArrayList<Subject> getYear4sem1o() {
        return year4sem1o;
    }

    public void setYear4sem1o(ArrayList<Subject> year4sem1o) {
        this.year4sem1o = year4sem1o;
    }

    public ArrayList<Subject> getYear4sem2o() {
        return year4sem2o;
    }

    public void setYear4sem2o(ArrayList<Subject> year4sem2o) {
        this.year4sem2o = year4sem2o;
    }

    public int getMaxYears() {
        return maxYears;
    }

    public void setMaxYears(int maxYears) {
        this.maxYears = maxYears;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
