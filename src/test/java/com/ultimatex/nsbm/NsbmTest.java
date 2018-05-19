package com.ultimatex.nsbm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NsbmTest {

    private NsbmMain nsbmMain = new NsbmMain();

    @Test
    public void testAddPlus() {
        int x = 1;
        int y = 1;
        assertEquals(nsbmMain.add(1, 1), 2);
    }

    @Test
    public void testStart() {

    }

}
