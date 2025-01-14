package programmers.basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RicochetRobot {
	private static final int INF = (int)1e9;
	public static final int NOT_REACH_OUT = -1;

	private class Node {
		private int y;
		private int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	private int[][] dirs = {
		{-1, 0},
		{1, 0},
		{0, -1},
		{0, 1}
	};

	public int solution(String[] board) {
		int answer = 0;
		int n = board.length;
		int m = board[0].length();
		int[][] dists = new int[n][m];
		char[][] b = new char[n][m];

		for (int i = 0; i < n; i++) {
			b[i] = board[i].toCharArray();
		}

		Deque<Node> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			Arrays.fill(dists[i], INF);
			for (int j = 0; j < m; j++) {
				if (b[i][j] == 'R') {
					q.offer(new Node(i, j));
					dists[i][j] = 0;
				}
			}
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (b[cur.y][cur.x] == 'G') {
				return dists[cur.y][cur.x];
			}

			for (int i = 0; i < 4; i++) {
				int ny = cur.y;
				int nx = cur.x;
				while (!isOutOf(ny, nx, n, m) && b[ny][nx] != 'D') {
					ny += dirs[i][0];
					nx += dirs[i][1];
				}

				ny -= dirs[i][0];
				nx -= dirs[i][1];

				if (dists[ny][nx] < dists[cur.y][cur.x] + 1)
					continue;

				dists[ny][nx] = dists[cur.y][cur.x] + 1;
				q.offer(new Node(ny, nx));
			}
		}

		return NOT_REACH_OUT;
	}

	boolean isOutOf(int ny, int nx, int n, int m) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}

}
