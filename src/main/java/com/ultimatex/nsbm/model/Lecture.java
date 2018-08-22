package com.ultimatex.nsbm.model;

import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

public class Lecture {
    public final static String TYPE_LEC = "Lecturer";
    public final static String TYPE_INS = "Instructor";

    private String name;
    private String type;

    @Indexed(options = @IndexOptions(unique = true))
    private int id;

    private String dept;


}
