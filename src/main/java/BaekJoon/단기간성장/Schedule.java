package BaekJoon.단기간성장;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Schedule {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] times = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			times[i] = Integer.parseInt(sc.nextLine());
		}

		int dp[] = new int[n + 1];
		dp[1] = times[1];
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.max(dp[i], dp[i - 2] + times[i]);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
		/*
8
30
30
60
90
60
15
15
60

3
45
15
30
		 */

	}
}
