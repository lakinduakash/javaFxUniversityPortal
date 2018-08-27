package com.ultimatex.nsbm;

import com.ultimatex.nsbm.util.DatabaseHelper;
import com.ultimatex.nsbm.util.Session;
import com.ultimatex.nsbm.util.UserNotFoundException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class SessionTest {

    @Test
    public void userCanLog() {
        Session session = Session.getInstance("email@email.com", "password");

        assertThat(session, is(notNullValue()));

    }

    @Test
    public void sessionClose() {
        Session.createInstance("admin", "admin");
        Session.close();

        Session session = Session.getSession();
        assertThat(session, is(nullValue()));

    }

    @Test
    public void getUserOfStudentHelperWithValidAccount() {

    }

    @Test(expected = UserNotFoundException.class)
    public void userNotFount() {
        Session.createInstance("emai@email.com", "password");

        User user = Session.getUser(Session.getSession(), DatabaseHelper.getInstance().getDatabase());

    }

}
