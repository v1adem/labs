package org.example.lab_4_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoderTest {
    @Test
    public void vowelsDecodeTest() {
        assertEquals("testing", Decoder.decode("t2st3ng"));
    }

    @Test
    public void consonantsDecodeTest() {
        assertEquals("testing", Decoder.decode("vetviph"));
    }
}