package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExchaingingCoin_DFS {

	private static int target;
	private static int n;
	private static int[] coins;
	private static int answer = 501;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		coins = new int[n];
		// TLE
		StringTokenizer st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		target = Integer.parseInt(reader.readLine());

		pick(0, 0);
		System.out.println(answer);
	}

	public static void pick(int cnt, int sum) {
		if (sum > target) {
			return;
		}

		if (answer < cnt) {
			return;
		}

		if (sum == target) {
			answer = Math.min(answer, cnt);
			return;
		}

		for (int i = 0; i < n; i++) {
			pick(cnt + 1, sum + coins[i]);
		}
	}
}
