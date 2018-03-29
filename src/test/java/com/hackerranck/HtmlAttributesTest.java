package com.hackerranck;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;


public class HtmlAttributesTest {

    private static final File FILE_1;

    static {
        //Get file from resources folder
        FILE_1 = new File(HtmlAttributes.class.getClassLoader().getResource("test.txt").getFile());        
    }
    

    @Test
    public void test() throws IOException {
        List <String> list = new HtmlAttributes().solution(FILE_1);

        list.forEach(System.out::println);
    }
}