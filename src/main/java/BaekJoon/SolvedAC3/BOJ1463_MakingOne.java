package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1463_MakingOne {

	static final int MAX_VALUE = 1_000_001;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(reader.readLine());

		dp = new int[MAX_VALUE];
		Arrays.fill(dp, MAX_VALUE);
		dp[1] = 0;

		for (int i = 2; i <= x; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
		}

		System.out.println(dp[x]);
	}

}
