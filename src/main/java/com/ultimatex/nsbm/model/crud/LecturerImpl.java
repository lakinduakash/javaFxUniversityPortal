package com.ultimatex.nsbm.model.crud;

import com.ultimatex.nsbm.model.Lecture;
import com.ultimatex.nsbm.util.MorphiaHelper;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import java.util.ArrayList;

/**
 * class for handle lecturer
 */
public class LecturerImpl extends BaseImpl<Lecture> {


    private Datastore datastore;

    public LecturerImpl() {
        super();
        datastore = MorphiaHelper.getInstance().getDataStore();
    }

    @Override
    public boolean insert(Lecture lecture) {
        try {
            datastore.save(lecture);
            return true;
        } catch (Exception e) {
            return false;
        }
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
    public ArrayList<Lecture> find(String key, Object value) {
        return null;
    }
}
