package com.exercism;


public class ReverseString{

    String  solution(String s) {

        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        return String.valueOf(arr);
    }

    String reverse(String inputString) {
        StringBuilder sb = new StringBuilder(inputString);

        return sb.reverse().toString();
    }
 
}