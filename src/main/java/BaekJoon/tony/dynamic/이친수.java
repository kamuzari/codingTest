package BaekJoon.tony.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int row = Math.max(n+1, 3);
		long[][] dp = new long[row][2]; // [n자리][0]:= n자리의 0으로 끝나는 수의 개수, [n자리][1] := 끝이 1로 끝나는 수의 개수
		dp[1][1] = 1;
		dp[2][0] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i][0] += dp[i - 1][0];
			dp[i][1] += dp[i - 1][0];
			dp[i][0] += dp[i - 1][1];
		}

		long answer = dp[n][0] + dp[n][1];
		System.out.println(answer);
	}
}
