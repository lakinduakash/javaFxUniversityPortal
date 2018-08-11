package com.ultimatex.nsbm.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("subject")
public class Subject {

    @Id
    private ObjectId id;

    private String name;
    private String code;
    private int price;
    private int credit;

    public Subject(String name, String code, int price, int credit) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.credit = credit;
    }

    public Subject() {

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Subject) {
            Subject s = (Subject) obj;
            return s.getId() == this.getId();
        } else return false;

    }
}
