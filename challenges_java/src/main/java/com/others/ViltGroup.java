package com.others;


//Please write down the code for a program (using pseudo-code or any language of your choice like Java, C# or JavaScript) that prints the numbers from 1 to 200 (included) with the following exceptions:
//If the number is a multiple of 3, then the program should print “M3”.
//If the number is a multiple of 5, then the program should print “M5”.
//If the number is simultaneously a multiple of 3 and 5, then the program should print “M35”. 

public class ViltGroup  {

    public final String test;

    public void test (String ... s ){

        for (int i = 1 ; i < 201 ; i ++)
            System.out.println(i);
    }

    public ViltGroup( String test ){
        this.test = test;
    }

    public static void main (String ... s ){

        ViltGroup  t = new ViltGroup("test");
    }

}