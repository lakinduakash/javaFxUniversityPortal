package com.ultimatex.nsbm.model.crud;

import com.ultimatex.nsbm.util.MorphiaHelper;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import java.util.ArrayList;

/**
 * This class is the base class for all classes which have direct database connectivity and Entity classes
 * @param <T>  T is the type of entity class
 */

public abstract class BaseImpl<T> {

    private Datastore datastore;

    public BaseImpl() {
        datastore = MorphiaHelper.getInstance().getDataStore();
    }

    /**
     * Insert new value
     *
     * @param t insert new t value to database
     * @return returns true if successfully inserted
     */
    public abstract boolean insert(T t);

    /**
     * Update existing value
     * @param id object id
     * @param updated updated value. ObjectId should be same
     * @return returns true if successfully updated
     */
    public abstract boolean update(ObjectId id, T updated);

    public abstract boolean update(T t);

    /**
     * Delete value from database
     * @param id ObjectId to delete
     * @return returns true if successfully deleted
     */
    public abstract boolean delete(ObjectId id);

    /**
     * Find specific value from database
     * @param key key of the data
     * @param value value of the data
     * @return returns List of data which matches to key/value pair
     */
    public abstract ArrayList<T> find(String key, Object value);

    protected Datastore getDatastore() {
        return datastore;
    }
}
