package com.ultimatex.nsbm;

import com.ultimatex.nsbm.util.*;
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
    public void getUserOfStudentHelperWithValidAccount() {
        Session.createInstance("email@email.com", "password");

        User user = Session.getUser(Session.getSession(), DatabaseHelper.getInstance().getDatabase());

        assertThat(user, is(instanceOf(StudentHelper.class)));
    }

    @Test(expected = UserNotFoundException.class)
    public void userNotFount() {
        Session.createInstance("emai@email.com", "password");

        User user = Session.getUser(Session.getSession(), DatabaseHelper.getInstance().getDatabase());

    }

}
