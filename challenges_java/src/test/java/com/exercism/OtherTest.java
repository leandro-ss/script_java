package com.exercism;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

public class OtherTest {

    private final static Logger logger = LoggerFactory.getLogger(OtherTest.class);

    @Test
    public void testCertification1() {

        int i = (int) Math.random();

        System.out.println(i);
    }

    @Test
    public void testCertification2() {
        int i = 1, j = -1;
        switch (i) {
        case 0:
            j = 1; /* Line 4 */
        case 2:
            j = 2;
        default:
            j = 0;
        }
    }

    @Test
    public void testCertification3() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            switch (i) {
            case 0:
                break;
            case 1:
                System.out.print("one ");
            case 2:
                System.out.print("two ");
            case 3:
                System.out.print("three ");
            }
        }
        System.out.println("done");
    }

    @Test
    public void testCertification4() {
        boolean bool = true;
        if (bool = false) /* Line 2 */  {
            System.out.println("a");
        } else if (bool) /* Line 6 */ {
            System.out.println("b");
        } else if (!bool) /* Line 10 */ {
            System.out.println("c");
            /* Line 12 */ } else {
            System.out.println("d");
        }
    }

    @Test
    public void testCertification5() {
        int x = 0;
        int y = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) && (++y > 2)) {
                x++;
            }
        }
        assertEquals("6 3", x + " " + y);
    }

    @Test
    public void basic() {

        LinkedHashMap<String, Integer> test1 = new LinkedHashMap<>();
        test1.put("key1", 1);
        test1.put("key2", 2);
        test1.put("key3", 3);

        LinkedHashMap<String, Integer> test2 = new LinkedHashMap<>();
        test2.put("key1", 1);
        test2.put("key2", 2);
        test2.put("key3", null);

        assertEquals(test1, test2);
    }

    @Test
    public void problem1() {

        Map<Character, Integer> map = new LinkedHashMap<>();

        map.put('I', null);
        map.put('B', null);
        map.put('L', null);

        for (int I = 0; I < 10; I++) {
            map.put('I', I);

            for (int B = 0; B < 10; B++) {
                map.put('B', B);

                if (map.get('B') == map.get('I'))
                    continue;

                for (int L = 0; L < 10; L++) {
                    map.put('L', L);

                    if (map.get('L') == map.get('B'))
                        continue;

                    if (I + B * Math.pow(10, 1) + B == I * Math.pow(10, 2) + L * Math.pow(10, 1)
                            + L * Math.pow(10, 0)) {

                        logger.info("marker: {}", map);
                        return;
                    }
                }
            }
        }
    }

    @Test
    public void problem2() {

        Map<Character, Integer> map = new LinkedHashMap<>();

        map.put('I', null);
        map.put('B', null);
        map.put('L', null);

        Character[] arr = map.keySet().toArray(new Character[] {});

        for (int I = 0; I < 10; I++) {
            map.put(arr[0], I);

            for (int B = 0; B < 10; B++) {
                map.put(arr[1], B);

                if (map.get(arr[1 - 1]) == map.get(arr[1]))
                    continue;

                for (int L = 0; L < 10; L++) {
                    map.put(arr[2], L);

                    if (map.get(arr[2 - 1]) == map.get(arr[2]))
                        continue;

                    if (map.get('I') + map.get('B') * Math.pow(10, 1) + map.get('B') == map.get('I') * Math.pow(10, 2)
                            + map.get('L') * Math.pow(10, 1) + map.get('L') * Math.pow(10, 0)) {

                        return;
                    }
                }
            }
        }
    }
}