package com.ultimatex.nsbm.model.crud;

import com.mongodb.WriteConcernException;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.util.MorphiaHelper;
import org.mongodb.morphia.Datastore;

import java.util.ArrayList;

public class CourseImpl {

    private Datastore datastore;

    public CourseImpl() {
        datastore = MorphiaHelper.getInstance().getDataStore();
    }

    public Course getCourseByName(String name) {
        return datastore.createQuery(Course.class).field("name").equal(name).disableValidation().get();
    }

    public Course getCourseByCode(String code) {

        return datastore.createQuery(Course.class).field("code").equal(code).disableValidation().get();
    }

    public ArrayList<Course> getAllCourse() {


        return new ArrayList<>(datastore.createQuery(Course.class).asList());
    }

    public boolean insertCourse(Course course) {
        try {
            datastore.save(course);
            return true;
        } catch (WriteConcernException e) {
            System.out.print(e.getErrorCode());
            return false;
        }

    }
}
