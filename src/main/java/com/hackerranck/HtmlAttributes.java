package com.hackerranck;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HtmlAttributes {

    private static final String rgx =  "(<([a-z0-9]+)|([a-z]+)=(\"|'))";

    public List<String> solution(File file) throws IOException {

        List<String> result = new ArrayList<String>();
        
        try (Scanner scanner = new Scanner(file)) {
            
            SortedMap<String,SortedSet<String>> mMatches = new TreeMap<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                Matcher m = Pattern.compile(rgx).matcher(line);

                Set<String> set = null;
                
                while (m.find()) {

                    if ( m.group(2) != null) {

                        if ( ! mMatches.containsKey(m.group(2)) )

                            mMatches.put(m.group(2), new TreeSet<>());
                            set = mMatches.get(m.group(2));

                    }else {
                        set.add(m.group(3));
                    }
                }
            }

            for (String key  : mMatches.keySet()){

                result.add(key+":"+mMatches.get(key).stream().map(n -> n.toString()).collect(Collectors.joining(",")));
            }
        }    

        return result;
    }
}