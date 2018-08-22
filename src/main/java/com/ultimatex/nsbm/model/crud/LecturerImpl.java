package com.ultimatex.nsbm.model.crud;

import com.ultimatex.nsbm.model.Lecture;
import org.bson.types.ObjectId;

public class LecturerImpl extends BaseImpl<Lecture> {


    @Override
    public boolean insert(Lecture lecture) {
        return false;
    }

    @Override
    public boolean update(ObjectId id, Lecture updated) {
        return false;
    }

    @Override
    public boolean update(Lecture lecture) {
        return false;
    }

    @Override
    public boolean delete(ObjectId id) {
        return false;
    }

    @Override
    public Lecture find(String key, Object value) {
        return null;
    }
}
