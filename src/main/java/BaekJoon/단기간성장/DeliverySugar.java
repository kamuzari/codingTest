package BaekJoon.단기간성장;

import java.util.Arrays;
import java.util.Scanner;

public class DeliverySugar {
	private static final int INF = (int)1e9;

	public static void main(String[] args) {
		int n = Integer.parseInt(new Scanner(System.in).nextLine());
		int[] dp = new int[n + 1];
		Arrays.fill(dp, INF);
		dp[3] = 1;
		if (n >= 5) {
			dp[5] = 1;
		}

		for (int i = 3; i < n + 1; i++) {
			dp[i] = Math.min(dp[i - 3] + 1, dp[i]);
			if (i >= 5) {
				dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
			}
		}

		int answer = dp[n] >= INF ? -1 : dp[n];
		System.out.println(answer);
	}
}
