package com.ultimatex.nsbm.util;

import com.mongodb.client.MongoDatabase;
import com.ultimatex.nsbm.User;

public class StudentHelper extends User {

    private String dob;
    private int age;

    private String admissionDate;
    private String nic;
    private String curSem;
    private int maxYear;

    public StudentHelper(String email, MongoDatabase database) {
        super(email, database);
    }
}
