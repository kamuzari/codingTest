package saffy.demotest;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchMine {
	private static final int INF = (int)1e9;
	private static final int directions[][] = {
			{-1, 0},
			{-1, -1},
			{0, -1},
			{1, -1},
			{1, 0},
			{1, 1},
			{0, 1},
			{-1, 1}
	};

	private static class Node {
		private int y;
		private int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	/**
	 * ideation : 지뢰 주변 먼저 돈다 어차피
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeatCount = toInt(sc.nextLine());
		StringBuilder answers = new StringBuilder();

		for (int testCase = 1; testCase <= repeatCount; testCase++) {

			int n = toInt(sc.nextLine());
			char[][] map = new char[n][n];

			for (int i = 0; i < n; i++) {
				map[i] = sc.nextLine().toCharArray();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != '*')
						continue;
					for (int k = 0; k < directions.length; k++) {
						int ny = directions[k][0] + i;
						int nx = directions[k][1] + j;

						if (isOutOfRange(ny, nx, n))
							continue;
						if (map[ny][nx] == '.') {
							map[ny][nx] = '1';
						}
					}
				}
			}

			boolean[][] v = new boolean[n][n];
			int clickCount = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != '.' || v[i][j]) {
						continue;
					}

					click(map, new Node(i, j), v);
					clickCount++;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '1' && !v[i][j]) {
						clickCount++;
					}
				}
			}

			String answer = String.format("#%d %d", testCase, clickCount);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static void click(char[][] map, Node source, boolean[][] v) {
		int n = map.length;

		LinkedList<Node> q = new LinkedList<>();
		q.offer(source);

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (map[cur.y][cur.x] == '.') {
				map[cur.y][cur.x] = 'V';
			}

			if (map[cur.y][cur.x] == '1') {
				v[cur.y][cur.x] = true;
				continue;
			}

			for (int i = 0; i < directions.length; i++) {
				int ny = directions[i][0] + cur.y;
				int nx = directions[i][1] + cur.x;

				if (isOutOfRange(ny, nx, n))
					continue;
				if(v[ny][nx]) continue;
				if (map[ny][nx] == '*') {
					continue;
				}

				v[ny][nx]=true;
				q.offer(new Node(ny, nx));
			}

		}
	}

	public static boolean isOutOfRange(int ny, int nx, int limit) {
		return ny < 0 || nx < 0 || ny >= limit || nx >= limit;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
