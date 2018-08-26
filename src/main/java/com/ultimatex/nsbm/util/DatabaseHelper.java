package com.ultimatex.nsbm.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DatabaseHelper {

    private static DatabaseHelper ourInstance = new DatabaseHelper();
    private MongoClient mongoClient;
    private MongoDatabase database;

    /**
     * Initialise the database connection. Constructor is private
     */
    private DatabaseHelper() {
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            database = mongoClient.getDatabase("nsbm");
        } catch (Exception e) {
            e.printStackTrace();
            database = null;
        }


    }

    /**
     * return one instance with singleton patern
     *
     * @return instance of DatabaseHelper
     */
    public static DatabaseHelper getInstance() {
        if (ourInstance == null)
            return new DatabaseHelper();
        else
            return ourInstance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void close() {
        mongoClient.close();
    }
}
