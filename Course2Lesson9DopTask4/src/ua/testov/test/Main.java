package ua.testov.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		File f = new File("test.txt");

		try {
			System.out.println(maxElem(f));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Integer maxElem(File file) throws IOException {
		List<String> x = Files.lines(Paths.get(file.getAbsolutePath()))
				.collect(Collectors.toCollection(ArrayList<String>::new));
		String str = String.join(",", x);
		
		List<Integer> y = Arrays.stream(str.split(","))
				.map(String::trim)
				.filter(s -> s.matches("-?\\d+"))
				.map(Integer::valueOf)
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(y);
		
		Optional<Integer> z = Arrays.stream(str.split(",")).map(String::trim).filter(s -> s.matches("[0-32768]+"))
				.map(Integer::valueOf).max((a, b) -> a - b);
		
		return z.get();
	}
}
