package com.ultimatex.nsbm.model.crud;


import com.mongodb.DuplicateKeyException;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.util.MorphiaHelper;
import org.mongodb.morphia.Datastore;

import java.util.ArrayList;

public class StudentImpl {

    private Datastore datastore;

    public StudentImpl() {
        datastore = MorphiaHelper.getInstance().getDataStore();
    }

    public boolean insertNewStudent(Student student) {
        try {
            datastore.save(student);
            return true;
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Student getStudentByIndex(String index) {
        return datastore.createQuery(Student.class).field("indexNumber").equal(index).get();
    }

    public ArrayList<Student> getStudentByName(String name) {
        return new ArrayList<>(datastore.createQuery(Student.class).field("name").equal(name).asList());
    }


}
