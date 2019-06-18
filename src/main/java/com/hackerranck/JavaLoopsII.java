package com.hackerranck;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;

public class JavaLoopsII{

    private final static Logger logger = LoggerFactory.getLogger(JavaLoopsII.class);

    public List<String> solution(Path filepath) throws IOException {
        logger.info( "solution path:{}", filepath);

        List<String> result = new ArrayList<String>();

        try (Scanner in = new Scanner(filepath)) {

            int t=in.nextInt();
            
            for(int i=0;i<t;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                int n = in.nextInt();
                int ant = 0;

                List<Integer> list = new ArrayList<>();

                for(int j=0; j<n; j++){
                    int act = Double.valueOf(b * Math.pow(2,j)).intValue() ;

                    list.add(a+act+ant);

                    ant += act;
                }

                result.add(list.stream().map(num -> num.toString()).collect(Collectors.joining(" ")));
            }
        }
        return result;
    }
}