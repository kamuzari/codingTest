package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18353_DeploySolider {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int soliders[] = new int[n];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			soliders[i] = Integer.parseInt(tokenizer.nextToken());
		}

		int dp[] = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 0; i < n; i++) {
			int val = soliders[i];
			for (int j = 0; j < i; j++) {
				if (soliders[i] < soliders[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int answer=Arrays.stream(dp).max().orElseGet(()->0);

		System.out.println(n-answer);
	}
}
