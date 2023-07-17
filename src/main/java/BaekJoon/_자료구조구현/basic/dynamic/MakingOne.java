package BaekJoon._자료구조구현.basic.dynamic;

import java.util.Scanner;

public class MakingOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		int[] dp = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			}

			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
		}

		System.out.println(dp[n]);
	}
}
