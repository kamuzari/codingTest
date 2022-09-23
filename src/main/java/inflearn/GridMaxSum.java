package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class GridMaxSum {
	static final int DIRECTION = 8;
	private static int[][] grid;
	private static int n;
	static int dy[] = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int dx[] = {0, 0, -1, 1, -1, -1, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		grid = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] inputRow = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(inputRow[j]);
			}
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int dir = 0; dir < DIRECTION; dir++) {
					answer = Math.max(answer, getAnswer(i, j, dir));
				}
			}
		}

		System.out.println(answer);
	}

	static class Node {
		int y;
		int x;
		int direction;

		public Node(int y, int x, int direction) {
			this.y = y;
			this.x = x;
			this.direction = direction;
		}
	}

	private static int getAnswer(int startY, int startX, int dir) {
		int result = grid[startY][startX];
		boolean[][] v = new boolean[n][n];
		v[startY][startX] = true;

		LinkedList<Node> q = new LinkedList<>();

		q.offer(new Node(startY, startX, dir));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			int ny = dy[cur.direction] + cur.y;
			int nx = dx[cur.direction] + cur.x;

			if (isOutOfIndex(ny, nx))
				continue;

			if (v[ny][nx])
				continue;

			v[ny][nx] = true;
			result += grid[ny][nx];

			q.offer(new Node(ny, nx, cur.direction));
		}

		return result;
	}

	private static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}
