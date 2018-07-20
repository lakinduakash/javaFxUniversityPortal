package com.ultimatex.nsbm;

import com.mongodb.client.MongoDatabase;
//User s
public abstract class User {

    public final static String TYPE_STUDENT = "student";
    public final static String TYPE_ADMIN = "admin";

    private String email;


    private MongoDatabase database;

    protected User(String email, MongoDatabase database) {
        this.email = email;
        this.database = database;
    }

    public String getEmail() {
        return email;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
