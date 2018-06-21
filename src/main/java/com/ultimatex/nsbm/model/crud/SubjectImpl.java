package com.ultimatex.nsbm.model.crud;

import com.ultimatex.nsbm.model.Subject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

public class SubjectImpl extends BaseImpl<Subject> {

    private Datastore datastore;

    public SubjectImpl() {
        super();
        datastore = getDatastore();
    }

    @Override
    public boolean insert(Subject subject) {
        datastore.save(subject);
        return false;
    }

    @Override
    public boolean update(ObjectId id, Subject updated) {
        return false;
    }

    @Override
    public boolean update(Subject subject) {
        return false;
    }

    @Override
    public boolean delete(ObjectId id) {
        int i = datastore.delete(datastore.createQuery(Subject.class).field("_id").equal(id)).getN();
        return i != 0;
    }

    @Override
    public Subject find(String key, Object value) {
        return datastore.createQuery(Subject.class).field("code").equal(value).get();
    }

    public Subject findById(String id, Object value) {
        return datastore.createQuery(Subject.class).field("_id").equal(value).get();
    }

}
