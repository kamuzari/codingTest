package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExchangingCoin {

	private static final int MAX_COIN = 501;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int coins[] = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		int target = Integer.parseInt(reader.readLine());
		int dp[] = new int[target + 1];
		Arrays.fill(dp, MAX_COIN);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			int coin = coins[i];

			for (int j = coin; j <= target; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin] + 1);
			}
		}

		System.out.println(dp[target]);

	}
}
