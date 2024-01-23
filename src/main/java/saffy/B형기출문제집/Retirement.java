package saffy.B형기출문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Retirement {
	static class Performance {
		private int day;
		private int profit;

		public Performance(int day, int profit) {
			this.day = day;
			this.profit = profit;
		}

		public boolean isInLimitDay(int limit, int plusDay) {
			int endDay = calculate(plusDay);

			return endDay <= limit;
		}

		public int calculate(int plusDay) {
			return this.day + plusDay;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		List<Performance> performances = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			performances.add(new Performance(
					Integer.parseInt(tokenizer.nextToken()),
					Integer.parseInt(tokenizer.nextToken())
			));
		}
		int dp[] = new int[n + 1];
		int maxProfit = 0;

		for (int i = performances.size() - 1; i >= 0; i--) {
			Performance currentPerformance = performances.get(i);

			if (currentPerformance.isInLimitDay(n,i)) {
				int prviousWorkDay = currentPerformance.calculate(i);
				dp[i] = Math.max(maxProfit,performances.get(i).profit + dp[prviousWorkDay]);
				maxProfit = dp[i];
			} else {
				dp[i] = maxProfit;
			}
		}

		System.out.println(dp[0]);
	}
}
