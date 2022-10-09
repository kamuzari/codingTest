package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SearchingShortestDistance {
	private static final int WALL = 1;
	private static final int NOT_YET = -1;
	private static final int N = 7;
	private static int dy[] = {-1, 1, 0, 0};
	private static int dx[] = {0, 0, -1, 1};

	private static class Node {
		private int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] grid = new int[N][N];
		int[][] dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs(0, 0, grid, dist));

	}

	private static int bfs(int startY, int startX, int[][] grid, int[][] dist) {
		Node start = new Node(startY, startX);
		LinkedList<Node> q = new LinkedList<>();

		q.offer(start);
		dist[startY][startX] = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.y == N - 1 && cur.x == N - 1) {
				return dist[N - 1][N - 1];
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfIndex(ny, nx))
					continue;

				if (grid[ny][nx] == WALL)
					continue;

				if (dist[ny][nx] != NOT_YET)
					continue;

				q.offer(new Node(ny, nx));
				dist[ny][nx] = dist[cur.y][cur.x] + 1;
			}

		}

		return -1;
	}

	private static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= N || nx >= N;
	}
}
