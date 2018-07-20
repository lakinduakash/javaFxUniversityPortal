package com.ultimatex.nsbm.model.crud;

import com.ultimatex.nsbm.model.Result;
import com.ultimatex.nsbm.model.Student;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

public class ResultImpl extends BaseImpl<Result> {

    private Student student;
    private Datastore datastore;

    public ResultImpl(Student student)
    {
        super();
        datastore =getDatastore();
        this.student=student;
    }
    @Override
    public boolean insert(Result result) {
        student.setResults(result);
        new StudentImpl().update(student);
        return false;
    }

    @Override
    public boolean update(ObjectId id, Result updated) {
        return false;
    }

    @Override
    public boolean update(Result result) {
        return false;
    }

    @Override
    public boolean delete(ObjectId id) {
        return false;
    }

    @Override
    public Result find(String key, Object value) {
        return null;
    }
}
