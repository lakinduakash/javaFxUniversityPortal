package com.ultimatex.nsbm.model.crud;


import com.mongodb.DuplicateKeyException;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.util.MorphiaHelper;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.ArrayList;

public class StudentImpl extends BaseImpl<Student> {

    private Datastore datastore;

    public StudentImpl() {
        super();
        datastore = MorphiaHelper.getInstance().getDataStore();
    }

    @Override
    public boolean insert(Student student) {
        try {
            datastore.save(student);
            return true;
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(ObjectId id, Student updated) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        if (student.getId() != null)
            datastore.save(student);
        else
            return false;
        return true;
    }

    @Override
    public boolean delete(ObjectId id) {
        return false;
    }

    @Override
    public ArrayList<Student> find(String key, Object value) {
        if (value != null)
            return new ArrayList<>(datastore.createQuery(Student.class).field(key).equal(value).asList());
        else
            return new ArrayList<>(datastore.createQuery(Student.class).asList());

    }

    /**
     * Find student by index number
     *
     * @param index index number of student
     * @return student selected
     */

    public Student getStudentByIndex(String index) {
        return datastore.createQuery(Student.class).field("indexNumber").equal(index).get();
    }

    public ArrayList<Student> getStudentByName(String name) {
        return new ArrayList<>(datastore.createQuery(Student.class).field("name").equal(name).asList());
    }

    public ArrayList<Student> getStudentList() {
        return new ArrayList<>(datastore.createQuery(Student.class).asList());
    }

    public boolean updateOneStudent(Student filter, Student updated) {
        Query<Student> query = datastore.createQuery(Student.class).field("_id").equal(filter.getId());

        UpdateOperations<Student> updateOperations = datastore.createUpdateOperations(Student.class)
                .set("fullName", updated.getFullName())
                .set("dob", updated.getDob())
                .set("email", updated.getEmail())
                .set("address", updated.getAddress())
                .set("nic", updated.getNic())
                .set("currentSem", updated.getCurrentSem())
                .set("currentYear", updated.getCurrentYear())
                .set("forthYear", updated.isFourthYear())
                .set("results", updated.getResults())
                .set("homeNumber", updated.getHomeNumber())
                .set("mobileNumber", updated.getMobileNumber())
                .set("age", updated.getAge());
        UpdateResults results = datastore.update(query, updateOperations);
        return results.getInsertedCount() > 0;
    }


}
