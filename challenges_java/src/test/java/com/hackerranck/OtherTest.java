package com.hackerranck;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class OtherTest {

    private final static Logger logger = LoggerFactory.getLogger(OtherTest.class);

    @Test
    public void JavaDateTimeTest() {
        logger.info("JavaDateTimeTest");

        try (Scanner in =  new Scanner("08 05 2015")){
            
            Calendar cal = new GregorianCalendar(in.nextInt(),in.nextInt(),in.nextInt());
            SimpleDateFormat sf = new SimpleDateFormat("EEEE");

            assertEquals( "QUARTA-FEIRA", sf.format(cal.getTime()).toUpperCase());
        }   
    }

    @Test
    public void JavaOtherTest() {
        logger.info("JavaDateTimeTest");

        try (Scanner in =  new Scanner("2015 05 08")){
            //                                   YEAR         MONTH        DAYOFMONTH
            Calendar cal = new GregorianCalendar(in.nextInt(),in.nextInt(),in.nextInt());
            SimpleDateFormat sf = new SimpleDateFormat("M d y y y y");

            assertEquals( "8 5 2 0 1 5", sf.format(cal.getTime()));
        }   
    }

    private enum EnumTest {
        TEST;
    }

    @Test
    public void enumValidate() {
        assertNotNull(EnumTest.valueOf("TEST")); ;
    }

}

