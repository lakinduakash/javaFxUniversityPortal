package com.ultimatex.nsbm;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.Map;

@Entity("student")
public class Student {

    @Id
    private ObjectId id;

    private String name;
    private int age;


    private Map<Integer, String> mTest;


    private ArrayList<Map<String, AddressTest>> list;

    @Reference
    private ArrayList<AddressTest> ad;

    @Reference
    private AddressTest address;

    public Student() {
    }

    public Student(String name, int age, AddressTest address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressTest getAddress() {
        return address;
    }

    public void setAddress(AddressTest address) {
        this.address = address;
    }

    public ArrayList<AddressTest> getAd() {
        return ad;
    }

    public void setAd(ArrayList<AddressTest> ad) {
        this.ad = ad;
    }

    public Map<Integer, String> getmTest() {
        return mTest;
    }

    public void setmTest(Map<Integer, String> mTest) {
        this.mTest = mTest;
    }

    public ArrayList<Map<String, AddressTest>> getList() {
        return list;
    }

    public void setList(ArrayList<Map<String, AddressTest>> list) {
        this.list = list;
    }
}
