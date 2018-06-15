package com.ultimatex.nsbm.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("last_index")
public class LastIndex {


    @Id
    private ObjectId id;

    private int index;

    public LastIndex() {

    }

    public LastIndex(int index) {
        this.index = index;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
