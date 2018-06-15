package com.ultimatex.nsbm;

import com.mongodb.MongoClient;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;

public class MorphiaTest {

    private Morphia morphia = new Morphia();

    @Test
    public void createStudent() {
        morphia.map(AddressTest.class, Student.class);

        final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_test");
        datastore.ensureIndexes();

        AddressTest t = new AddressTest("Ratnapura", "Karangoda");
        datastore.save(t);

        Student s = new Student("Lakindu", 23, t);

        ArrayList<AddressTest> ki = new ArrayList<AddressTest>();
        ki.add(t);
        ki.add(t);
        s.setAd(ki);

        datastore.save(s);


    }

    @Test
    public void findStudent() {
        morphia.map(AddressTest.class, Student.class);
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_test");
        datastore.ensureIndexes();

        Query<Student> q = datastore.find(Student.class);

        System.out.print(q.asList().get(0).getAd().get(0).getCity());

    }
}
