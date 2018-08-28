package com.hackerranck;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class JavaIfElse {

    public String solution(Path pathfile) throws IOException {

        try(Scanner sc=new Scanner(pathfile)){

            int n=sc.nextInt();            
            String ans="";

            if(n%2==1){

                ans = "Weird";

            }else{       

                if( n >= 2 && n<= 5){
                    ans = "Not Weird";
                } else if (n >= 6 && n <= 20)
                    ans = "Weird";
                else{
                    ans = "Not Weird";
                }
            }
            return ans;
        }
    }
}