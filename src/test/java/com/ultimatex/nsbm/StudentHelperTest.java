package com.ultimatex.nsbm;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.ultimatex.nsbm.util.DatabaseHelper;
import com.ultimatex.nsbm.util.StudentHelper;
import org.bson.Document;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void setAddress() {
        StudentHelper studentHelper = new StudentHelper(email, mongoDatabase);

        Address exp = new Address("new sreww", "jjsj", "hhhha", "Sri Lanka");

        studentHelper.setAddress(exp);

        Address actual = studentHelper.getAddress();

        boolean o = false;

        if (exp.getCity().equals(actual.getCity()) && exp.getCountry().equals(actual.getCountry()) && exp.getStreet().equals(actual.getStreet()) && exp.getZipCode().equals(actual.getZipCode()))
            o = true;

        assertThat(o, is(true));

        clean();
    }


    public void clean() {
        mongoDatabase.getCollection("user").deleteMany(new Document("email", "lakinduakash@gmail.com"));
    }
}