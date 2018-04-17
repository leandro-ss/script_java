package com.exercism;

public class Twofer {
    String twofer(String name) {
        
        String pattern = new String("One for %s, one for me.");

        String result = null;

        if (name == null || name.isEmpty()){

            result = String.format(pattern, "you").toString();
        } else {

            result = String.format(pattern, name).toString();
        }
        return  result;
    }

    String reverse(String inputString) {
        StringBuilder sb = new StringBuilder(inputString);

        return sb.reverse().toString();
    }
 
}
