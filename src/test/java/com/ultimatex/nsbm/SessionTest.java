package com.ultimatex.nsbm;

import com.ultimatex.nsbm.util.Session;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class SessionTest {

    @Test
    public void userCanLog() {
        Session session = Session.getInstance("email@email.com", "password");

        assertThat(session, is(notNullValue()));

    }
}
