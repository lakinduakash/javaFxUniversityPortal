package com.ultimatex.nsbm.util;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import com.ultimatex.nsbm.Course;
import com.ultimatex.nsbm.Result;
import com.ultimatex.nsbm.User;
import com.ultimatex.nsbm.model.Address;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Date;

import static com.mongodb.client.model.Updates.set;


public class StudentHelper extends User {

    private String firstName;
    private String lastName;
    private String surName;
    transient private String fullName;

    private Date dob;
    private int age;
    private String email;
    private Address address;

    private Date admissionDate;
    private String nic;
    private int currentSem;
    private int currentYear;
    private boolean fourthYear;

    private String indexNumber;
    private String studentNumber;


    private Course course;
    private Result results;

    private String school;
    private int ALYear;
    private String ALStream;
    private String ALResults;
    private double zScore;

    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Document object;
    private Document filter;

    public StudentHelper(String email, MongoDatabase database) {
        super(email, database);
        this.database = database;
        this.collection = database.getCollection("user");
        this.email = email;

        this.filter = new Document("email", email);
        FindIterable<Document> findIterable = collection.find(filter);
        object = findIterable.first();

    }

    public static void addStudent(String email, MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("user");
        collection.insertOne(new Document("email", email));


    }


    public String getFirstName() {
        this.firstName = getObject().getString("first");
        return firstName;
    }

    public void setFirstName(String firstName) {
        updateOne(set("first", firstName));
        this.firstName = firstName;
    }

    public String getLastName() {
        this.lastName = getObject().getString("last");
        return lastName;
    }

    public void setLastName(String lastName) {
        updateOne(set("last", lastName));
        this.lastName = lastName;
    }

    public String getSurName() {
        this.surName = getObject().getString("surName");
        return surName;
    }

    public void setSurName(String surName) {
        updateOne(set("surName", surName));
        this.surName = surName;
    }

    public String getFullName() {
        return fullName = firstName + " " + lastName + " " + surName;
    }


    public Date getDob() {
        dob = getObject().getDate("dob");
        return dob;
    }

    public void setDob(Date dob) {
        updateOne(set("dob", dob));
        long diffInDays = ((new Date().getTime() - dob.getTime())
                / (1000 * 60 * 60 * 24));
        int years = (int) (diffInDays / 365);

        this.age = years;

        collection.updateOne(filter, set("age", years));
        this.dob = dob;
    }

    public int getAge() {
        age = getObject().getInteger("age", 0);
        return age;
    }


    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        updateOne(set("email", email));
        this.email = email;
    }

    public Address getAddress() {
        Document doc = (Document) getObject().get("address");
        String ada = doc.toJson();
        Gson gson = new Gson();
        this.address = gson.fromJson(ada, Address.class);
        return address;
    }

    public void setAddress(Address address) {
        Gson gson = new Gson();
        String ada = gson.toJson(address);


        updateOne(set("address", BsonDocument.parse(ada)));
        this.address = address;
    }

    public Date getAdmissionDate() {
        this.admissionDate = getObject().getDate("admissionDate");
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        updateOne(set("admissionDate", admissionDate));
        this.admissionDate = admissionDate;
    }

    public String getNic() {
        this.nic = getObject().getString("nic");
        return nic;
    }

    public void setNic(String nic) {
        updateOne(set("nic", nic));
        this.nic = nic;
    }

    public int getCurrentSem() {
        currentSem = getObject().getInteger("currentSem", 0);
        return currentSem;
    }

    public void setCurrentSem(int curSem) {
        updateOne(set("currentSem", curSem));
        this.currentSem = curSem;
    }

    public int getCurrentYear() {
        this.currentYear = getObject().getInteger("currentYear");
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        updateOne(set("currentYear", currentYear));
        this.currentYear = currentYear;
    }

    public boolean isFourthYear() {
        this.fourthYear = getObject().getBoolean("forthYear", false);
        return fourthYear;
    }

    public void setFourthYear(boolean fourthYear) {
        updateOne(set("forthYear", fourthYear));
        this.fourthYear = fourthYear;
    }

    public String getIndexNumber() {
        this.indexNumber = getObject().getString("indexNumber");
        return indexNumber;
    }


    public String getStudentNumber() {
        studentNumber = getObject().getString("studentNumber");
        return studentNumber;
    }


    public String getSchool() {
        school = getObject().getString("school");
        return school;
    }

    public void setSchool(String school) {
        updateOne(set("school", school));
        this.school = school;
    }

    public int getALYear() {
        ALYear = getObject().getInteger("ALyear");
        return ALYear;
    }

    public void setALYear(int ALYear) {
        updateOne(set("ALyear", ALYear));
        this.ALYear = ALYear;
    }

    public String getALStream() {
        ALStream = getObject().getString("ALStream");
        return ALStream;
    }

    public void setALStream(String ALStream) {
        updateOne(set("ALStream", ALStream));
        this.ALStream = ALStream;
    }

    public String getALResults() {
        ALResults = getObject().getString("ALResults");
        return ALResults;
    }

    public void setALResults(String ALResults) {
        updateOne(set("ALResults", ALResults));
        this.ALResults = ALResults;
    }

    public double getzScore() {
        zScore = getObject().getDouble("zScore");
        return zScore;
    }

    public void setzScore(double zScore) {
        updateOne(set("zScore", zScore));
        this.zScore = zScore;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setPassword(String password) {
        updateOne(set("password", password));
    }

    private UpdateResult updateOne(Bson value) {
        return collection.updateOne(filter, value);
    }

    private Document getObject() {
        FindIterable<Document> findIterable = collection.find(filter);
        return object = findIterable.first();
    }

}
