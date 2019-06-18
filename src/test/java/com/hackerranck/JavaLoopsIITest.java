package com.hackerranck;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JavaLoopsIITest{
    private final static Logger logger = LoggerFactory.getLogger(JavaLoopsII.class);

    private static final Path FILE_INPUT;
    private static final Path FILE_OUTPUT;

    static {
        //Get file from resources folder
        FILE_INPUT = Paths.get(JavaLoopsIITest.class.getClassLoader().getResource("test3.input.txt").getFile());
        FILE_OUTPUT = Paths.get(JavaLoopsIITest.class.getClassLoader().getResource("test3.output.txt").getFile());
    }
    
    @Test
    public void test() throws IOException {
        List <String> list = new JavaLoopsII().solution(FILE_INPUT);

        list.forEach( reg  -> logger.info("list of result :{}",reg));

        for (int i=0; i < list.size(); i++){

            assertEquals(list.get(i), Files.readAllLines(FILE_OUTPUT).get(i));  
        }
    }
}