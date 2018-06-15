package com.ultimatex.nsbm.util;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MorphiaHelper {

    private static MorphiaHelper ourInstance;

    private Morphia morphia = new Morphia();

    private Datastore datastore;

    private MorphiaHelper() {

        morphia.mapPackage("com.ultimatex.nsbm.model");
        datastore = morphia.createDatastore(new MongoClient(), "morphia_test");

    }

    public static MorphiaHelper getInstance() {

        if (ourInstance == null) {
            ourInstance = new MorphiaHelper();
            return ourInstance;
        } else {
            return ourInstance;
        }
    }

    public Datastore getDataStore() {
        return datastore;
    }
}
