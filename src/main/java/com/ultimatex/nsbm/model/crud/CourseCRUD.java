package com.ultimatex.nsbm.model.crud;

import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.util.MorphiaHelper;
import org.mongodb.morphia.Datastore;

import java.util.ArrayList;

public class CourseCRUD {

    private static Datastore datastore;

    public CourseCRUD() {
        datastore = MorphiaHelper.getInstance().getDataStore();
    }

    public static Course getCourseByName(String name) {
        return datastore.createQuery(Course.class).field("code").equal(name).get();
    }

    public static Course getCourseByCode(String code) {
        return datastore.createQuery(Course.class).field("code").equal(code).get();
    }

    public ArrayList<Course> getAllCourse() {

        return new ArrayList<>(datastore.createQuery(Course.class).asList());
    }
}
