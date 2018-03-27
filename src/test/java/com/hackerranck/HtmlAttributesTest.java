package com.hackerranck;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;



public class HtmlAttributesTest {

    private static final File FILE;

    static {
        //Get file from resources folder
        FILE = new File(HtmlAttributes.class.getClassLoader().getResource("test.txt").getFile());        
    }
    
    @Test public void test() {
        System.out.println(FILE.getPath());
    }
}