package com.ultimatex.nsbm;

import com.mongodb.MongoClient;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.model.Subject;
import com.ultimatex.nsbm.model.crud.SubjectImpl;
import com.ultimatex.nsbm.util.GenerateIndex;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MorphiaTest {

    private Morphia morphia = new Morphia();

    private Datastore init() {
        morphia.mapPackage("com.ultimatex.nsbm.model");

        return morphia.createDatastore(new MongoClient(), "morphia_test");
    }


    @Test
    public void createSubject() {
        Datastore d = init();

        ArrayList<Subject> s = new ArrayList<>();
        s.add(new Subject("SE", "1", 2000, 3));
        s.add(new Subject("DSA", "2", 2000, 3));
        s.add(new Subject("NE", "3", 2000, 3));
        s.add(new Subject("PR", "4", 2000, 3));


        d.save(s);



    }

    @Test
    public void createCourse() {
        Datastore d = init();




    }

    @Test
    public void createStudent() {




    }

    @Test
    public void genIndex() {
        GenerateIndex generateIndex1 = new GenerateIndex();
        GenerateIndex generateIndex2 = new GenerateIndex();

        int index1 = generateIndex1.genNewIndex();
        generateIndex1.saveIndex();

        int index2 = generateIndex2.genNewIndex();
        generateIndex2.saveIndex();

        assertThat(index2, is(index1 + 1));

    }

    @Test
    public void clearAllStudent() {
        Datastore d = init();
        final Query<Student> q = d.createQuery(Student.class);

        d.delete(q);
    }

    @Test
    public void insertSubject() {
        Subject[] s1 = {new Subject("SE 1", "1001", 3000, 3),
                new Subject("DSA 1", "1002", 3000, 3),
                new Subject("DSA 3", "1003", 3000, 3),
                new Subject("PRO 1", "1004", 3000, 3),
                new Subject("DB 1", "1005", 3000, 3),
                new Subject("DB 2", "1006", 3000, 3),
                new Subject("EN 1", "1007", 3000, 3),
                new Subject("DSA 2", "1008", 3000, 3)};

        for (Subject s : s1) {
            new SubjectImpl().insert(s);
        }
    }

    @Test
    public void removeAllSubject() {
        Datastore d = init();
        d.delete(d.createQuery(Subject.class));
    }

    @Test
    public void addSubjectToCourse() {

    }

    @Test
    public void updateAsWholeObject() {

    }

}
