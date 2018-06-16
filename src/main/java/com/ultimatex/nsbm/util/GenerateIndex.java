package com.ultimatex.nsbm.util;

import com.ultimatex.nsbm.model.LastIndex;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

public class GenerateIndex {

    private Datastore datastore;

    private int lastIndex;

    public GenerateIndex() {
        datastore = MorphiaHelper.getInstance().getDataStore();
    }

    private int getLastIndex() {
        Query<LastIndex> query = datastore.createQuery(LastIndex.class);

        LastIndex index = query.get();

        if (index == null) {
            index = new LastIndex(0);
            datastore.save(index);
            return index.getIndex();
        } else {
            return index.getIndex();
        }

    }

    public int genNewIndex() {

        lastIndex = getLastIndex();
        lastIndex += 1;
        return lastIndex;

    }

    public void saveIndex() {
        UpdateOperations<LastIndex> updateOperations = datastore.createUpdateOperations(LastIndex.class);
        Query<LastIndex> query = datastore.createQuery(LastIndex.class).field("index").equal(lastIndex - 1);
        updateOperations.set("index", lastIndex);
        datastore.update(query, updateOperations);
    }

}
