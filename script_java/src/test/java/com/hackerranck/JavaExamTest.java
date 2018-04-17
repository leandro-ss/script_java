package com.hackerranck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class JavaExamTest{
    
    @Test
    public void testA() {

        assertEquals("Yes", new JavaExam().isPossible(1, 4, 5, 9));
        
    }

    @Test
    public void testB() {

        assertEquals("Yes", new JavaExam().isPossible(1, 2, 3, 6));
        
    }    
}
