package com.ultimatex.nsbm;

import com.ultimatex.nsbm.util.DatabaseHelper;
import com.ultimatex.nsbm.util.InvalidSessionException;
import com.ultimatex.nsbm.util.Session;
import com.ultimatex.nsbm.util.StudentHelper;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class SessionTest {

    @Test
    public void userCanLog() {
        Session session = Session.getInstance("email@email.com", "password");

        assertThat(session, is(notNullValue()));

    }

    @Test(expected = InvalidSessionException.class)
    public void sessionClose() {
        Session.createInstance("email@email.com", "password");
        Session.close();

        Session.getSession();

    }

    @Test
    public void getUser() {
        Session.createInstance("email@email.com", "password");

        User user = Session.getUser(Session.getSession(), DatabaseHelper.getInstance().getDatabase());

        assertThat(user, is(instanceOf(StudentHelper.class)));
    }
}