package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexNumbering {
	static int n;
	static char[][] map;
	static boolean[][] v;
	static List<Integer> answers;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());
		map = new char[n][n];
		v = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = reader.readLine().toCharArray();
		}

		answers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '0')
					continue;
				if (v[i][j])
					continue;

				int count = connectNearBy(i, j);
				answers.add(count);
			}
		}

		Collections.sort(answers);
		String answer = answers.size() + "\n" + answers.stream()
			.map(String::valueOf)
			.collect(Collectors.joining("\n"));

		System.out.println(answer);
	}

	static class Node {
		private int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[][] dirs = {
		{-1, 0},
		{0, -1},
		{1, 0},
		{0, 1}
	};

	static int connectNearBy(int i, int j) {
		int count = 1;
		LinkedList<Node> q = new LinkedList<>();
		v[i][j] = true;
		q.offer(new Node(i, j));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int k = 0; k < 4; k++) {
				int ny = dirs[k][0] + cur.y;
				int nx = dirs[k][1] + cur.x;

				if (isOutOfRange(ny, nx))
					continue;
				if (map[ny][nx] == '0')
					continue;
				if (v[ny][nx])
					continue;

				v[ny][nx] = true;
				count++;
				q.offer(new Node(ny, nx));
			}
		}

		return count;
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}

