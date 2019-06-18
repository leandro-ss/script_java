package com.exercism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Alphametics{

    private final static Logger logger = LoggerFactory.getLogger(Alphametics.class);

    private static final String rgx =  "(([A-Z]+)|== ([A-Z]+))";
    
    protected String product = new String();

    protected List<String> factors = new ArrayList<>();

    protected Map<Character, Integer> map = new LinkedHashMap<>();

    public Alphametics(String s) throws UnsolvablePuzzleException{
    
        Matcher m = Pattern.compile(rgx).matcher(s);
        while (m.find()) {
    
            if ( m.group(2) != null) {
                this.factors.add(m.group(2));
            }else if (m.group(3) != null){
                this.product = m.group(3);
            }else{
                throw new UnsolvablePuzzleException();
            }
        }
    }

    public Map<Character, Integer> solve () throws UnsolvablePuzzleException{
        this.validateCharacterMap();
        this.initCharacterMap();

        if (solve(map.keySet().toArray(new Character[]{}), 0)){
            logger.debug("characterMap on Finish - cm:{}",map);
            return map;

        }else {
            logger.debug("characterMap on Exception- cm:{}",map);
            throw new UnsolvablePuzzleException();
        }
    }

    private Boolean solve(Character[] arr, Integer posit ){

        Boolean result = Boolean.FALSE;

        for (int i=0; i<10 ;i++){
            
            map.put(arr[posit], i);

            if(Collections.frequency(map.values(), i) > 1)continue;

            if(posit+1 < arr.length){

                result = solve(arr,posit+1);

            }else {
                try {
                    result = Integer.valueOf(calc(factors)).equals(calc(product));

                }catch(NumberFormatException e){

                    continue;
                }
            }

            if(result)break;
        }

        if(! result ){

            map.put(arr[posit], null);
        }
        return result;
    }

    protected void initCharacterMap(){

        List<String> tempList = new ArrayList<>(factors);
        
        tempList.add(product);

        for (String str : tempList){
            for (Character c : str.toCharArray() ){
                this.map.put(c,null);
            }
        }
    }

    protected Integer calc(List<String> list){

        Integer result = Integer.valueOf(0);

        for (String str : list ){
            result += calc(str);
        }

        return result;
    }

    protected Integer calc(String str){
        return calc(new StringBuilder(str),0);
    }

    protected Integer calc(StringBuilder str, Integer posit){

        Integer result = map.get(new StringBuilder(str).reverse().charAt(posit));

        if(Integer.valueOf(posit+1).equals(str.length()) && Integer.valueOf(0).equals(result)){

            throw new NumberFormatException("0 não pode ser posicionado a esquerda");
        }

        result = result * Double.valueOf(Math.pow(10, posit)).intValue();

        if(++posit < str.length()){

            result += calc( str, posit);
        }
        return result;
    }

    protected void validateCharacterMap() throws UnsolvablePuzzleException{

        Set<Character> set = new HashSet<Character>();

        for (String f: factors) {
            for (Character c : f.toCharArray()){
                set.add(c);
            }
        }
        for (Character c : product.toCharArray()){
            set.add(c);
        }

        if(set.size() > 10){
            throw new UnsolvablePuzzleException();
        }
    }
}
class UnsolvablePuzzleException extends Exception {

	private static final long serialVersionUID = 1L;
}