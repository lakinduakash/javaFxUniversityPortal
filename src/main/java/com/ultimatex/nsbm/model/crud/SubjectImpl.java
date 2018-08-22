package com.ultimatex.nsbm.model.crud;

import com.ultimatex.nsbm.model.Subject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import java.util.ArrayList;

public class SubjectImpl extends BaseImpl<Subject> {

    private Datastore datastore;

    public SubjectImpl() {
        super();
        datastore = getDatastore();
    }

    @Override
    public boolean insert(Subject subject) {
        try {
            datastore.save(subject);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public boolean update(ObjectId id, Subject updated) {
        try {
            updated.setId(id);
            datastore.save(updated);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Subject subject) {
        try {
            datastore.save(subject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(ObjectId id) {
        int i = datastore.delete(datastore.createQuery(Subject.class).field("_id").equal(id)).getN();
        return i != 0;
    }

    @Override
    public ArrayList<Subject> find(String key, Object value) {
        if (value != null)
            return (ArrayList<Subject>) datastore.createQuery(Subject.class).field("code").equal(value).asList();
        else
            return (ArrayList<Subject>) datastore.createQuery(Subject.class).asList();
    }

    public Subject findById(String id, Object value) {
        return datastore.createQuery(Subject.class).field("_id").equal(value).get();
    }

}
