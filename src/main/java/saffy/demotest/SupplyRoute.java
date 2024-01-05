package saffy.demotest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SupplyRoute {
	static class Node {
		private int y;
		private int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	private static int[][] dircetions = {
			{-1, 0},
			{0, -1},
			{1, 0},
			{0, 1}
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder answers = new StringBuilder();
		int repeatCount = Integer.parseInt(sc.nextLine());
		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			int n = Integer.parseInt(sc.nextLine());

			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] rows = sc.nextLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(rows[j]);
				}
			}

			int minimumRecovery = getMinimumRecovery(n, map);
			String answer = String.format("#%d %d", testCase, minimumRecovery);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static int getMinimumRecovery(int limit, int[][] map) {
		int[][] costs = new int[limit][limit];
		for (int i = 0; i < limit; i++) {
			Arrays.fill(costs[i], Integer.MAX_VALUE);
		}
		costs[0][0] = 0;
		LinkedList<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = dircetions[i][0] + cur.y;
				int nx = dircetions[i][1] + cur.x;

				if (isOutOfRange(ny, nx, limit))
					continue;
				int newCost = costs[cur.y][cur.x] + map[ny][nx];
				if (costs[ny][nx] <= newCost)
					continue;

				costs[ny][nx] = newCost;
				q.offer(new Node(ny, nx));
			}
		}

		return costs[limit - 1][limit - 1];
	}

	private static boolean isOutOfRange(int ny, int nx, int n) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}
