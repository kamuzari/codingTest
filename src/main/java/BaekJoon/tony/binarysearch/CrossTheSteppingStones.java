package BaekJoon.tony.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CrossTheSteppingStones {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[] dp = new long[5001];
		Arrays.fill(dp, Long.MAX_VALUE);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				long result = calculate(j, i, arr);
				dp[i] = Math.min(dp[i], result);

			}
		}

		System.out.println(dp[n - 1]);
	}

	static long calculate(int i, int j, int[] arr) {
		long power = (long)(j - i) * (1L + Math.abs(arr[i] - arr[j]));

		return power;
	}
}
