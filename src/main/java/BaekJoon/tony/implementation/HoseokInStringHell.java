package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HoseokInStringHell {

	private static int n;
	private static int m;
	private static char[][] map;
	private static int[][] directions = {
		{-1, 0},
		{-1, -1},
		{0, -1},
		{1, -1},
		{1, 0},
		{1, 1},
		{0, 1},
		{-1, 1},
	};
	private static int MAX_LENGTH;
	private static Map<String, Integer> words;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] input = reader.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		map = new char[n][m];
		int k = Integer.parseInt(input[2]);

		for (int i = 0; i < n; i++) {
			map[i] = reader.readLine().toCharArray();
		}

		words = new LinkedHashMap<>();

		for (int i = 0; i < k; i++) {
			String word = reader.readLine();
			words.put(word, 0);
			MAX_LENGTH = Math.max(MAX_LENGTH, word.length());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				search(i, j, 0, Character.toString(map[i][j]));
			}
		}

		String answer = words.values().stream().map(String::valueOf).collect(Collectors.joining("\n"));
		System.out.println(answer);
	}

	private static void search(int r, int c, int cnt, String result) {
		if (cnt == MAX_LENGTH) {
			return;
		}

		if (words.containsKey(result)) {
			words.put(result, words.get(result) + 1);
		}

		for (int i = 0; i < 8; i++) {
			int ny = (directions[i][0] + r + n) % n;
			int nx = (directions[i][1] + c + m) % m;

			search(ny, nx, cnt + 1, result + map[ny][nx]);
		}
	}
}
