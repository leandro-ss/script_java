package com.exercism;

public class Acronym {

    private String str;

	Acronym(String str){
        this.str = str;
    }

    String get(){

        String result = new String("");
        for (String s : str.split("\\s|-")){
            result += String.valueOf(s.charAt(0)).toUpperCase();
        }

        return result;
    }
}