package com.exercism;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class OtherTest {

    private final static Logger logger = LoggerFactory.getLogger(OtherTest.class);

    //@Test
    public void basic() {

        LinkedHashMap<String,Integer> test1 = new LinkedHashMap<>();
        test1.put("key1", 1);
        test1.put("key2", 2);
        test1.put("key3", 3);


        LinkedHashMap<String,Integer> test2 = new LinkedHashMap<>();
        test2.put("key1", 1);
        test2.put("key2", 2);
        test2.put("key3", null);

        assertEquals(test1, test2);        
    }
    Map<Character, Integer> map = new LinkedHashMap<>();
    
    //@Test
    public void problem1 (){

        map.put('I', null);
        map.put('B', null);
        map.put('L', null);

        for (int I=0; I<10 ; I++){
            map.put('I', I);

            for (int B=0; B<10 ; B++){
                map.put('B', B);

                if(map.get('B') == map.get('I') )continue;

                for (int L=0; L<10 ; L++){
                    map.put('L', L);

                    if(map.get('L') == map.get('B') )continue;

                    if (I + B*Math.pow(10, 1) + B == I*Math.pow(10, 2) + L*Math.pow(10, 1) + L*Math.pow(10, 0)) {

                        logger.info("marker: {}", map);
                        return;
                    }
                }
            }
        }
    }

    //@Test
    public void problem2 (){

        map.put('I', null);
        map.put('B', null);
        map.put('L', null);

        Character[] arr =  map.keySet().toArray(new Character[]{});

        for (int I=0; I<10 ; I++){
            map.put(arr[0], I);

            for (int B=0; B<10 ; B++){
                map.put(arr[1], B);

                if(map.get(arr[1-1]) == map.get(arr[1]) )continue;

                for (int L=0; L<10 ; L++){
                    map.put(arr[2], L);

                    if(map.get(arr[2-1]) == map.get(arr[2]) )continue;

                    if (map.get('I') + map.get('B')*Math.pow(10, 1) + map.get('B') 
                    == map.get('I')*Math.pow(10, 2) + map.get('L')*Math.pow(10, 1) + map.get('L')*Math.pow(10, 0)) {

                        logger.info("iteration:{}, match: {}",count, map);
                        return;
                    }
                    logger.info("iteration:{}, iterate: {}",++count, map);
                }
            }
        }
    }

    int count;

    //@Test
    public void problem3 (){

        map.put('I', null);
        map.put('B', null);
        map.put('L', null);

        assertTrue(problem3(map.keySet().toArray(new Character[]{}), 0));
    }

    private Boolean problem3(Character[] arr, Integer posit ){

        Boolean result = Boolean.FALSE;

        for (int i=0; i<10 ;i++){
            
            map.put(arr[posit], i);

            if(Collections.frequency(map.values(), i) > 1)continue;

            if(posit+1 < arr.length){

                result = problem3(arr,posit+1);

            }else {

                result = validate();
            }

            if(result)break;
        }

        if( ! result ){

            map.put(arr[posit], null);
        }

        return result;
    }

    private Boolean validate(){
        if (map.get('I') + map.get('B')*Math.pow(10, 1) + map.get('B') 
        == map.get('I')*Math.pow(10, 2) + map.get('L')*Math.pow(10, 1) + map.get('L')*Math.pow(10, 0)) {

            logger.info("iteration:{}, iterate: {}",++count, map);
            return true;
        }
        return false;
    }

    @Test
    public void test (){

        StringBuilder t = new StringBuilder("ABC");
        StringBuilder t2 = new StringBuilder(t);
        
        t = t.reverse();

        
        assertEquals(new StringBuilder("ABC"), t2);
    }
}

