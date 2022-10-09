package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination {

	private static int[][] combinations;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		combinations = new int[n + 1][n + 1];
		combinations[0][0] = 1;
		// dynamic(n);
		dfs(n, r);

		System.out.println(combinations[n][r]);
	}

	private static void dynamic(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					combinations[i][j] = 1;
					continue;
				}

				combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
			}
		}
	}

	public static int dfs(int n, int r) {
		if (n == r || r == 0)
			return 1;

		if (combinations[n][r] != 0)
			return combinations[n][r];

		combinations[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);

		return combinations[n][r];
	}
}
