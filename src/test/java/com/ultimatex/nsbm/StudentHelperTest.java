package com.ultimatex.nsbm;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ultimatex.nsbm.util.DatabaseHelper;
import com.ultimatex.nsbm.util.StudentHelper;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class StudentHelperTest {

    String email = "lakinduakash@gmail.com";
    private MongoDatabase mongoDatabase = DatabaseHelper.getInstance().getDatabase();

    @Test
    public void addStudent() {
        StudentHelper.addStudent("lakinduakash@gmail.com", mongoDatabase);

        FindIterable findIterable = mongoDatabase.getCollection("user").find(new Document("email", "lakinduakash@gmail.com"));

        assertThat(findIterable.first(), is(notNullValue()));

    }

    @Test
    public void setDobAndAge() {
        StudentHelper studentHelper = new StudentHelper(email, mongoDatabase);

        String myDate = "1995/02/27 00:00:00";
//creates a formatter that parses the date in the given format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(myDate);
        } catch (ParseException e) {

        }

        long timeInMillis = date.getTime();
        studentHelper.setDob(new Date(timeInMillis));

        int age = studentHelper.getAge();

        assertThat(age, is(23));

    }



    @Test
    public void testNativeOp() {
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");

        collection.updateMany(new Document(), Document.parse("{\n" +
                "     $set: { \"size.uom\": \"cm\", status: \"P\" },\n" +
                "     $currentDate: { lastModified: true }\n" +
                "   }"));
    }

    @Test
    public void setSubject() {
        Subject subject = new Subject("A", 3200);
        Course course = new Course();
        course.setMaxYears(4);
        course.setYear1sem1(new Subject[]{subject, subject});
        course.setYear1sem2(new Subject[]{subject});

        Gson gson = new Gson();
        //String s=gson.toJson(subject);
        String s1 = gson.toJson(course);

        MongoCollection<Document> collection = mongoDatabase.getCollection("courses");
        ArrayList objectId = collection.find(new Document("name", "cs")).first().get("year1sem1", ArrayList.class);

        MongoCollection<Document> collection1 = mongoDatabase.getCollection("subject");

        String I = (String) collection1.find(new Document("_id", objectId.get(0))).first().get("name");

        String s2 = gson.toJson(objectId.get(0));

        ObjectId ii = gson.fromJson(s2, ObjectId.class);

        System.out.print(I + s2 + ii.toHexString());


    }


    public void clean() {
        mongoDatabase.getCollection("user").deleteMany(new Document("email", "lakinduakash@gmail.com"));
    }
}
