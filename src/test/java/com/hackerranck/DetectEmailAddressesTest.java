package com.hackerranck;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class DetectEmailAddressesTest {

    private static final Path FILE_INPUT;
    private static final Path FILE_OUTPUT;

    static {
        //Get file from resources folder
        FILE_INPUT = Paths.get(DetectEmailAddressesTest.class.getClassLoader().getResource("test2.input.txt").getFile());
        FILE_OUTPUT = Paths.get(DetectEmailAddressesTest.class.getClassLoader().getResource("test2.output.txt").getFile());
    }

    @Test
    public void test() throws IOException {
        List <String> list = new DetectEmailAddresses().solution(FILE_INPUT);

        for (int i=0; i < list.size(); i++){

            assertEquals(list.get(i), Files.readAllLines(FILE_OUTPUT).get(i));  
        }
    }
}
