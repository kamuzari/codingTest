package BaekJoon._자료구조구현.basic.dynamic;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NormalBackPack {
	static class Thing {
		private int weight;
		private int worth;

		public Thing(int weight, int worth) {
			this.weight = weight;
			this.worth = worth;
		}

		public int getWeight() {
			return weight;
		}

		public int getWorth() {
			return worth;
		}

		public boolean isGraterThanOrEqual(int weight) {
			return this.weight >= weight;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());

		int n = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());

		Thing[] things = new Thing[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(sc.nextLine());
			int weight = Integer.parseInt(st.nextToken());
			int worth = Integer.parseInt(st.nextToken());

			things[i] = new Thing(weight, worth);
		}
		things[0] = new Thing(0, 0);

		int[][] dp = new int[n + 1][limit + 1];
		Arrays.sort(things, (a, b) -> a.weight - b.weight);
		for (int i = 1; i <= n; i++) {
			Thing current = things[i];
			for (int weight = 1; weight <= limit; weight++) {
				dp[i][weight] = Math.max(dp[i - 1][weight], dp[i][weight - 1]);

				if (weight >= current.getWeight()) {
					dp[i][weight] = Math.max(dp[i][weight],
						dp[i - 1][weight- current.getWeight()] + current.getWorth());
				}

			}
		}

		System.out.println(dp[n][limit]);

	}
}
