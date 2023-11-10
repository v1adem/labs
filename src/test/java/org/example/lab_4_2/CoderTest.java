package org.example.lab_4_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoderTest {
    @Test
    public void vowelsCodeTest() {
        assertEquals("t2st3ng",Coder.vowelsCode("testing"));
    }

    @Test
    public void consonantsCodeTest() {
        assertEquals("vetviph", Coder.consonantsCode("testing"));
    }
}