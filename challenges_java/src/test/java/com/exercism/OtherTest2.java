package com.exercism;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class OtherTest2 {

    private static final SimpleDateFormat FORMAT; 
    static{
        FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        FORMAT.setLenient(false);
    }

    @Test
    public void testCertification2() throws ParseException {

        FORMAT.setLenient(false);

        System.out.println(FORMAT.parse("99/01/2000 23:00:00"));
    }
}