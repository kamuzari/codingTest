package FAST_CAMPUS.CompleteSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CleanUpFile {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		Map<String, Integer> files = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			String[] split = reader.readLine().split("\\.");
			String extension = split[1];
			files.put(extension, files.getOrDefault(extension, 0) + 1);
		}

		String answer = files.entrySet().stream()
			.map(entry -> entry.getKey() + " " + entry.getValue())
			.collect(Collectors.joining("\n"));

		System.out.println(answer);
	}
}
