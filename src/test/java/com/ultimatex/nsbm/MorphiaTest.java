package com.ultimatex.nsbm;

import com.mongodb.MongoClient;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.model.Subject;
import com.ultimatex.nsbm.model.crud.CourseImpl;
import com.ultimatex.nsbm.model.crud.StudentImpl;
import com.ultimatex.nsbm.util.GenerateIndex;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

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
        Subject s = d.createQuery(Subject.class).field("name").equal("PR").get();

        if (s != null) {
            Course course = new Course();
            course.setMaxYears(3);
            course.setName("BS");

            ArrayList<Subject> arrayList = new ArrayList<>();

            arrayList.add(s);
            arrayList.add(s);
            arrayList.add(s);

            course.setYear1sem1(arrayList);

            d.save(course);
        }

    }

    @Test
    public void createStudent() {

        StudentImpl imp = new StudentImpl();

        Student student = new Student();
        student.setFullName("Lakindu Akash");

        Course c1 = new Course();
        c1.setCode("CS");
        c1.setName("Computer Science");
        new CourseImpl().insertCourse(c1);

        Course course = new CourseImpl().getCourseByCode("CS");

        GenerateIndex g = new GenerateIndex();

        student.setCourse(course);
        student.setIndexNumber(course.getCode() + g.genNewIndex());

        boolean inserted = imp.insertNewStudent(student);
        g.saveIndex();
        assertThat(true, is(inserted));

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


}
