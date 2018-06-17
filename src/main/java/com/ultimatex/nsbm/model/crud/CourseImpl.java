package com.ultimatex.nsbm.model.crud;

import com.mongodb.WriteConcernException;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.util.MorphiaHelper;
import org.mongodb.morphia.Datastore;

import java.util.ArrayList;

/**
 * This class work as intermediate between database and Course object. It insert,create,update and remove data from database
 */

public class CourseImpl {

    //Datastore object from Morphia
    private Datastore datastore;


    /**
     * Constructor
     * <p>
     * Assign datastore from MorphiaHelper
     */
    public CourseImpl() {
        datastore = MorphiaHelper.getInstance().getDataStore();
    }


    /**
     * Get first Course object by name from database.
     *
     * @param name Name of the course, not null
     * @return Course object,may null
     * @throws com.mongodb.MongoException if any database connectivity problem occur
     */

    public Course getCourseByName(String name) {
        return datastore.createQuery(Course.class).field("name").equal(name).disableValidation().get();
    }


    /**
     * Get Course object by code from database.
     *
     * @param code Name of the course, not null
     * @return Course object,may null
     * @throws com.mongodb.MongoException if any database connectivity problem occur
     */
    public Course getCourseByCode(String code) {

        return datastore.createQuery(Course.class).field("code").equal(code).disableValidation().get();
    }

    /**
     * Get all Course object from database
     *
     * @return ArrayList of Course, not null
     * @throws com.mongodb.MongoException if any database connectivity problem occur
     */
    public ArrayList<Course> getAllCourse() {


        return new ArrayList<>(datastore.createQuery(Course.class).asList());
    }

    /**
     * Insert new Course object into database
     *
     * @param course  Name of the course, not null
     * @return true if success
     * @throws com.mongodb.MongoException if any database connectivity problem occur
     */
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
