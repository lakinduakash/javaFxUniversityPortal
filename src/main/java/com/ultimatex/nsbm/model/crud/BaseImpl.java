package com.ultimatex.nsbm.model.crud;

import com.ultimatex.nsbm.util.MorphiaHelper;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

public abstract class BaseImpl<T> {

    private Datastore datastore;

    public BaseImpl() {
        datastore = MorphiaHelper.getInstance().getDataStore();
    }

    public abstract boolean insert(T t);

    public abstract boolean update(ObjectId id, T updated);

    public abstract boolean delete(ObjectId id);

    public abstract T find(String key, Object value);

    protected Datastore getDatastore() {
        return datastore;
    }
}
