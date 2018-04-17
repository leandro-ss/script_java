package com.hackerranck;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DetectEmailAddresses {

    private static final String rgx =  "([a-zA-Z0-9]\\S+@[a-zA-Z0-9]\\S+\\.[a-z]+)";

    public List<String> solution(Path filepath) throws IOException {

        List<String> result = new ArrayList<String>();
        
        try (Scanner scanner = new Scanner(filepath)) {
            
            SortedSet<String> mMatches = new TreeSet<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                Matcher m = Pattern.compile(rgx).matcher(line);
                
                while (m.find()) {

                    if ( m.group() != null) {

                        mMatches.add(m.group());
                    }
                }
            }

            result.add(mMatches.stream().map(n -> n.toString()).collect(Collectors.joining(";")));
        }

        return result;
    }
}