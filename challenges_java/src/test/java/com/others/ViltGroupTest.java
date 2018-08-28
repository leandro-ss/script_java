package com.others;


import static org.junit.Assert.assertTrue;

//Please write down the code for a program (using pseudo-code or any language of your choice like Java, C# or JavaScript) that prints the numbers from 1 to 200 (included) with the following exceptions:
//If the number is a multiple of 3, then the program should print “M3”.
//If the number is a multiple of 5, then the program should print “M5”.
//If the number is simultaneously a multiple of 3 and 5, then the program should print “M35”. 

import org.junit.Test;

public class ViltGroupTest  {

    @Test
    public void test1 (){

        for (int i = 1 ; i < 201 ; i ++){

            if( i  %3 == 0 && i  %5 == 0){
                System.out.println("M53");
            }else if( i  %3 == 0){
                System.out.println("M3");
            }else if( i  %5 == 0){
                System.out.println("M5");
            }else {
                System.out.println(i);
            }
        }
    }

 
    @Test
    public void test2 (){

        assertTrue("1".matches("[0-9]"));
    }

       

}