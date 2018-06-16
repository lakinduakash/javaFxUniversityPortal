package com.ultimatex.nsbm.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.Date;

@Entity("student")
public class Student {

    @Id
    private ObjectId id;



    private Date dob;
    private String email;
    private Address address;

    private Date admissionDate;
    private String nic;
    private int currentSem;
    private int currentYear;
    private boolean fourthYear;

    @Indexed(options = @IndexOptions(unique = true))
    private String indexNumber;
    @Indexed(options = @IndexOptions(unique = true))
    private String studentNumber;

    @Reference
    private Course course;


    @Embedded
    private Result results;

    private String school;
    private int ALYear;
    private String ALStream;
    private String ALResults;
    private double zScore;

    private String degree;
    private String university;
    private Double prevGpv;

    private String fullName;

    private String nickName;
    private String homeNumber;
    private String mobileNumber;
    private int age;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getCurrentSem() {
        return currentSem;
    }

    public void setCurrentSem(int currentSem) {
        this.currentSem = currentSem;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public boolean isFourthYear() {
        return fourthYear;
    }

    public void setFourthYear(boolean fourthYear) {
        this.fourthYear = fourthYear;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getALYear() {
        return ALYear;
    }

    public void setALYear(int ALYear) {
        this.ALYear = ALYear;
    }

    public String getALStream() {
        return ALStream;
    }

    public void setALStream(String ALStream) {
        this.ALStream = ALStream;
    }

    public String getALResults() {
        return ALResults;
    }

    public void setALResults(String ALResults) {
        this.ALResults = ALResults;
    }

    public double getzScore() {
        return zScore;
    }

    public void setzScore(double zScore) {
        this.zScore = zScore;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Double getPrevGpv() {
        return prevGpv;
    }

    public void setPrevGpv(Double prevGpv) {
        this.prevGpv = prevGpv;
    }

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results = results;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
