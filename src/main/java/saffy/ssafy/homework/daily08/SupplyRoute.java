package saffy.ssafy.homework.daily08;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SupplyRoute {
	static final int INF = (int)1e9;
	static Scanner sc = new Scanner(System.in);

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static final int dy[] = {-1, 1, 0, 0};
	static final int dx[] = {0, 0, -1, 1};

	public static void main(String[] args) {
		int tc = Integer.parseInt(sc.nextLine());
		StringBuilder answer = new StringBuilder();
		for (int testCase = 1; testCase <= tc; testCase++) {
			int n = Integer.parseInt(sc.nextLine());
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] s = sc.nextLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}

			int[][] costs = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(costs[i], INF);
			}

			costs[0][0] = map[0][0];

			ArrayDeque<Node> q = new ArrayDeque<>();
			q.offer(new Node(0, 0));
			int result = Integer.MAX_VALUE;
			while (!q.isEmpty()) {
				Node cur = q.poll();
				if (cur.y == n - 1 && cur.x == n - 1) {
					result = Math.min(result, costs[n - 1][n - 1]);
					continue;
				}

				for (int i = 0; i < 4; i++) {
					int ny = dy[i] + cur.y;
					int nx = dx[i] + cur.x;

					if (isOut(ny, nx, n))
						continue;

					int newCost = map[ny][nx] + costs[cur.y][cur.x];
					if (costs[ny][nx] <= newCost) {
						continue;
					}

					costs[ny][nx] = newCost;
					q.offer(new Node(ny, nx));
				}
			}
			answer.append("#").append(testCase).append(" ").append(costs[n - 1][n - 1]).append(System.lineSeparator());
		}
		System.out.println(answer);
	}

	static boolean isOut(int ny, int nx, int n) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}
