package com.hackerranck;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HtmlAttributes {

    public void main(File file) {

		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(file.toPath())) {

			list = stream
					.filter(line -> !line.startsWith("line3"))
					.map(String::toUpperCase)
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);
    }

}