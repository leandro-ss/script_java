package com.hackerranck;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;


public class HtmlAttributesTest {

    private static final Path FILE_INPUT;
    private static final Path FILE_OUTPUT;


    static {
        //Get file from resources folder
        FILE_INPUT = Paths.get(HtmlAttributes.class.getClassLoader().getResource("test1.input.txt").getFile());        
        FILE_OUTPUT = Paths.get(HtmlAttributes.class.getClassLoader().getResource("test1.output.txt").getFile());        
    }
    

    @Test
    public void test() throws IOException {
        List <String> list = new HtmlAttributes().solution(FILE_INPUT);

        list.forEach(System.out::println);

        for (int i=0; i < list.size(); i++){

            assertEquals(list.get(i), Files.readAllLines(FILE_OUTPUT).get(i));  
        }
    }
}