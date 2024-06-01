package BaekJoon.SolvedAC3;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RealTimeMinimumDistance {
	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static final int START_VALUE = 2;
	static final int ACCESS_VALUE = 1;
	static final int NOT_ACCESS_VALUE = -1;
	static int n, m;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		Point start = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < m; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if (value == START_VALUE) {
					start = new Point(i, j);
				}
			}
		}

		int[][] distances = displayDistance(start);
		draw(distances);
	}

	private static void draw(int[][] distances) {
		for (int i = 0; i < distances.length; i++) {
			for (int j = 0; j < distances[i].length; j++) {
				boolean isNotAccessLand = map[i][j] == ACCESS_VALUE && distances[i][j] == 0;
				if (isNotAccessLand) {
					distances[i][j] = -1;
				}

				System.out.print(distances[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	private static int[][] displayDistance(Point start) {
		int[][] distances = new int[n][m];
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.offer(start);

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfRange(ny, nx))
					continue;
				if (map[ny][nx] != ACCESS_VALUE)
					continue;
				if (distances[ny][nx] != 0)
					continue;

				int newCost = distances[cur.y][cur.x] + 1;
				distances[ny][nx] = newCost;
				q.offer(new Point(ny, nx));
			}
		}

		return distances;
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
