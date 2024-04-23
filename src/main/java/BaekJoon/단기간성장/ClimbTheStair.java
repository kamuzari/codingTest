package BaekJoon.단기간성장;

import java.util.Scanner;

public class ClimbTheStair {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// dp[i] = dp[i-1] +
		int n = Integer.parseInt(sc.nextLine());
		int[] scores = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			scores[i] = Integer.parseInt(sc.nextLine());
		}
		if (n == 1) {
			System.out.println(scores[n]);
			return;
		} else if (n == 2) {
			System.out.println(scores[n] + scores[n - 1]);
			return;
		}
		int dp[] = new int[n + 1];
		dp[1] = scores[1];
		dp[2] = scores[1] + scores[2];
		dp[3] = Math.max(scores[1] + scores[3], scores[2] + scores[3]);

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + scores[i - 1], dp[i - 2]) + scores[i];
		}

		System.out.println(dp[n]);
	}
}
