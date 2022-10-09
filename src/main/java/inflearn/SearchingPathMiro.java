package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchingPathMiro {
	private static final int WALL = 1;
	private static final int N = 7;
	private static int dy[] = {-1, 1, 0, 0};
	private static int dx[] = {0, 0, -1, 1};
	private static int answer;
	private static int[][] grid;
	private static boolean[][] v;

	private static class Node {
		private int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		v[0][0] = true;
		dfs(0, 0);

		System.out.println(answer);
	}

	private static void dfs(int y, int x) {
		if (y == N - 1 && x == N - 1) {
			answer++;
		}

		for (int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (isOutOfIndex(ny, nx)) {
				continue;
			}

			if (grid[ny][nx] == WALL) {
				continue;
			}

			if (v[ny][nx]) {
				continue;
			}

			v[ny][nx] = true;
			dfs(ny, nx);
			v[ny][nx] = false;
		}

	}

	private static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= N || nx >= N;
	}
}
