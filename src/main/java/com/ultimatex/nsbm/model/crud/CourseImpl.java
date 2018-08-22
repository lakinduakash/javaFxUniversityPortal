package com.ultimatex.nsbm.model.crud;

import com.mongodb.WriteConcernException;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Subject;
import com.ultimatex.nsbm.util.MorphiaHelper;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;

/**
 * This class work as intermediate between database and Course object. It insert,create,update and remove data from database
 */

public class CourseImpl extends BaseImpl<Course> {

    public static final String Y1S1 = "year1sem1";
    public static final String Y1S2 = "year1sem2";
    public static final String Y2S1 = "year2sem1";
    public static final String Y2S2 = "year2sem2";
    public static final String Y3S1 = "year3sem1";
    public static final String Y3S2 = "year3sem2";
    public static final String Y4S1 = "year4sem1";
    public static final String Y4S2 = "year4sem2";

    public static final String Y1S1O = "year1sem1o";
    public static final String Y1S2O = "year1sem2o";
    public static final String Y2S1O = "year2sem1o";
    public static final String Y2S2O = "year2sem2o";
    public static final String Y3S1O = "year3sem1o";
    public static final String Y3S2O = "year3sem2o";
    public static final String Y4S1O = "year4sem1o";
    public static final String Y4S2O = "year4sem2o";

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

    @Override
    public boolean insert(Course course) {
        return false;
    }

    @Override
    public boolean update(ObjectId id, Course updated) {
        return false;
    }

    @Override
    public boolean update(Course course) {
        if (course.getId() != null)
            datastore.save(course);
        else
            return false;
        return true;
    }

    @Override
    public boolean delete(ObjectId id) {
        return false;
    }

    @Override
    public ArrayList<Course> find(String key, Object value) {
        return null;
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
     * @param course Name of the course, not null
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


    public void addCompulsorySubject(Course course, ArrayList<Subject> subjects, boolean override, String semesterCode) {
        Query<Course> q = datastore.createQuery(Course.class).field("_id").equal(course.getId());
        if (override) {
            switch (semesterCode) {
                case Y1S1:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y1S1, subjects));
                    break;
                case Y1S2:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y1S2, subjects));
                    break;
                case Y2S1:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y2S1, subjects));
                    break;
                case Y2S2:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y2S2, subjects));
                    break;
                case Y3S1:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y3S1, subjects));
                    break;
                case Y3S2:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y3S2, subjects));
                    break;
                case Y4S1:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y4S1, subjects));
                    break;
                case Y4S2:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y4S2, subjects));
                    break;
            }
        } else {
            switch (semesterCode) {
                case Y1S1:
                    ArrayList<Subject> s = new ArrayList<>(course.getYear1sem1());
                    s.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y1S1, s));
                    break;
                case Y1S2:
                    ArrayList<Subject> s1 = new ArrayList<>(course.getYear1sem2());
                    s1.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y1S2, s1));
                    break;
                case Y2S1:
                    ArrayList<Subject> s2 = new ArrayList<>(course.getYear2sem1());
                    s2.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y2S1, s2));
                    break;
                case Y2S2:
                    ArrayList<Subject> s3 = new ArrayList<>(course.getYear2sem2());
                    s3.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y2S2, s3));
                    break;
                case Y3S1:
                    ArrayList<Subject> s4 = new ArrayList<>(course.getYear3sem1());
                    s4.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y3S1, s4));
                    break;
                case Y3S2:
                    ArrayList<Subject> s5 = new ArrayList<>(course.getYear3sem2());
                    s5.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y3S2, s5));
                    break;
                case Y4S1:
                    ArrayList<Subject> s6 = new ArrayList<>(course.getYear4sem1());
                    s6.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y4S1, s6));
                    break;
                case Y4S2:
                    ArrayList<Subject> s7 = new ArrayList<>(course.getYear4sem2());
                    s7.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y4S2, s7));
                    break;
            }
        }
    }

    public void addOptionalSubject(Course course, ArrayList<Subject> subjects, boolean override, String semesterCode) {
        Query<Course> q = datastore.createQuery(Course.class).field("_id").equal(course.getId());
        if (override) {
            switch (semesterCode) {
                case Y1S1O:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y1S1O, subjects));
                    break;
                case Y1S2O:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y1S2O, subjects));
                    break;
                case Y2S1O:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y2S1O, subjects));
                    break;
                case Y2S2O:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y2S2O, subjects));
                    break;
                case Y3S1O:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y3S1O, subjects));
                    break;
                case Y3S2O:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y3S2O, subjects));
                    break;
                case Y4S1O:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y4S1O, subjects));
                    break;
                case Y4S2O:
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y4S2O, subjects));
                    break;
            }
        } else {
            switch (semesterCode) {
                case Y1S1O:
                    ArrayList<Subject> s = new ArrayList<>(course.getYear1sem1o());
                    s.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y1S1O, s));
                    break;
                case Y1S2O:
                    ArrayList<Subject> s1 = new ArrayList<>(course.getYear1sem2o());
                    s1.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y1S2O, s1));
                    break;
                case Y2S1O:
                    ArrayList<Subject> s2 = new ArrayList<>(course.getYear2sem1o());
                    s2.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y2S1O, s2));
                    break;
                case Y2S2O:
                    ArrayList<Subject> s3 = new ArrayList<>(course.getYear2sem2o());
                    s3.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y2S2O, s3));
                    break;
                case Y3S1O:
                    ArrayList<Subject> s4 = new ArrayList<>(course.getYear3sem1o());
                    s4.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y3S1O, s4));
                    break;
                case Y3S2O:
                    ArrayList<Subject> s5 = new ArrayList<>(course.getYear3sem2o());
                    s5.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y3S2O, s5));
                    break;
                case Y4S1O:
                    ArrayList<Subject> s6 = new ArrayList<>(course.getYear4sem1o());
                    s6.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y4S1O, s6));
                    break;
                case Y4S2O:
                    ArrayList<Subject> s7 = new ArrayList<>(course.getYear4sem2o());
                    s7.addAll(subjects);
                    datastore.update(q, datastore.createUpdateOperations(Course.class).set(Y4S2O, s7));
                    break;
            }
        }
    }

    public void addOptionalSubject(String courseCode, ArrayList<Subject> subjects, boolean override, String semesterCode) {
        addOptionalSubject(this.getCourseByCode(courseCode), subjects, override, semesterCode);
    }

    public void addCompulsorySubject(String courseCode, ArrayList<Subject> subjects, boolean override, String semesterCode) {
        addCompulsorySubject(this.getCourseByCode(courseCode), subjects, override, semesterCode);
    }

}

