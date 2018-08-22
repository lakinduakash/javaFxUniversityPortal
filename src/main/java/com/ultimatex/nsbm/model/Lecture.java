package com.ultimatex.nsbm.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

public class Lecture {
    public final static String TYPE_LEC = "Lecturer";
    public final static String TYPE_INS = "Instructor";


    private String name;
    private String type;
    private ObjectId id;



    @Indexed(options = @IndexOptions(unique = true))
    private String empId;

    private String dept;

    public Lecture() {

    }

    public Lecture(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
