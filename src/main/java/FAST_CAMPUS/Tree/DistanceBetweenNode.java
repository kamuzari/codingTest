package FAST_CAMPUS.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DistanceBetweenNode {

	private static final int INF = 100_000_000;

	static class Node {
		private int v1;
		private int dist;

		public Node(int v1, int dist) {
			this.v1 = v1;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int matrix[][] = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(matrix[i], INF);
			matrix[i][i] = 0;
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			matrix[v1][v2] = Math.min(matrix[v1][v2], cost);
			matrix[v2][v1] = Math.min(matrix[v2][v1], cost);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			answer.append(matrix[v1][v2]).append("\n");
		}

		System.out.println(answer.toString());
	}
}
