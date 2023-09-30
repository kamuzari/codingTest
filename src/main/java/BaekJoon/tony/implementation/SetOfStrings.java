package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SetOfStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> strings = new HashSet<>();
		for (int i = 0; i < n; i++) {
			strings.add(reader.readLine());
		}

		int answer = 0;
		for (int i = 0; i < m; i++) {
			if (strings.contains(reader.readLine())) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}
