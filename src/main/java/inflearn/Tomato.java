package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Tomato {
	private static final int TOMATO = 1;
	private static int dy[] = {-1, 1, 0, 0};
	private static int dx[] = {0, 0, -1, 1};
	private static int m;
	private static int n;

	static class Node {
		private int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		// Your Program Goes Here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		int[][] grid = new int[n][m];

		List<Node> tomatos = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				int value = grid[i][j] = Integer.parseInt(st.nextToken());

				if (value == TOMATO) {
					tomatos.add(new Node(i, j));
				}
			}
		}

		LinkedList<Node> q = new LinkedList<>();

		for (Node tomato : tomatos) {
			q.offer(tomato);
		}

		int completionDate = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfIndex(ny, nx))
					continue;

				if (grid[ny][nx] == 0) {
					grid[ny][nx] = grid[cur.y][cur.x] + 1;
					q.offer(new Node(ny, nx));
					completionDate = Math.max(completionDate, grid[ny][nx]);
				}
			}
		}

		if (isAllRipe(grid)) {
			System.out.println(completionDate - 1);
		} else {
			System.out.println(-1);
		}

	}

	private static boolean isAllRipe(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0)
					return false;
			}
		}

		return true;
	}

	public static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
