package com.ultimatex.nsbm.util;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DatabaseHelper {

    private static DatabaseHelper ourInstance = new DatabaseHelper();
    private MongoClient mongoClient;
    private DB database;

    private DatabaseHelper() {
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            database = mongoClient.getDB("nsbm");
        } catch (Exception e) {
            e.printStackTrace();
            database = null;
        }


    }

    public static DatabaseHelper getInstance() {
        return ourInstance;
    }

    public DB getDatabase() {
        return database;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void close() {
        mongoClient.close();
    }
}
