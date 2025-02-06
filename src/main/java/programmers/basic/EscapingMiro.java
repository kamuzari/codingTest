package programmers.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class EscapingMiro {
	class Node {
		private int y;
		private int x;
		private int cnt;
		private boolean hasLever;

		public Node(int y, int x, int cnt, boolean hasLever) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.hasLever = hasLever;
		}

		void activateLever() {
			this.hasLever = true;
		}

		void visit(boolean[][][] v) {
			int signal = hasLever ? 1 : 0;

			v[signal][y][x] = true;
		}

		boolean isGone(boolean[][][] v) {
			int signal = hasLever ? 1 : 0;

			return v[signal][y][x];
		}
	}

	int dy[] = {-1, 1, 0, 0};
	int dx[] = {0, 0, -1, 1};

	public int solution(String[] maps) {
		int n = maps.length;
		int m = maps[0].length();

		char[][] grid = new char[n][m];
		for (int i = 0; i < maps.length; i++) {
			grid[i] = maps[i].toCharArray();
		}

		Node start = null;
		Node end = null;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'S') {
					start = new Node(i, j, 0, false);
				} else if (grid[i][j] == 'E') {
					end = new Node(i, j, 0, false);
				}
			}
		}

		boolean[][][] v = new boolean[2][n][m];
		Deque<Node> q = new ArrayDeque<>();
		q.offer(start);
		start.visit(v);

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.y == end.y && cur.x == end.x && cur.hasLever) {
				return cur.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfRange(ny, nx, n, m))
					continue;
				if (grid[ny][nx] == 'X')
					continue;

				Node next = new Node(ny, nx, cur.cnt + 1, cur.hasLever);
				if (next.isGone(v))
					continue;
				if (grid[ny][nx] == 'L') {
					next.activateLever();
				}
				next.visit(v);
				q.add(next);
			}
		}

		return -1;
	}

	boolean isOutOfRange(int ny, int nx, int n, int m) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
