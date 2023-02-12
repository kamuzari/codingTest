package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14501_Retire {
	static class Node {
		private int day;
		private int profit;

		public Node(int day, int profit) {
			this.day = day;
			this.profit = profit;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			nodes.add(new Node(
				Integer.parseInt(tokenizer.nextToken()),
				Integer.parseInt(tokenizer.nextToken())
			));
		}

		int answer = solution(n, nodes);

		System.out.println(answer);
	}

	/**
	 * note: 주어진 N일 동안 가장 돈을 많이 벌려고 한다.
	 *  - n+1일날은 무조건 퇴사할 거다. =: n일 까지는 일할 수 있다.
	 * @param n : 퇴사날
	 * @param nodes : 처리기간과 수익이 담은 데이터
	 * @return : 최대 수익률
	 */
	static int solution(int n, List<Node> nodes) {
		int dp[] = new int[n + 1];
		int maxValue = 0;

		for (int i = nodes.size() - 1; i >= 0; i--) {
			int endDay = nodes.get(i).day + i;

			if (endDay <= n) {
				dp[i] = Math.max(nodes.get(i).profit + dp[endDay], maxValue);
				maxValue = dp[i];
			} else {
				dp[i] = maxValue;
			}
		}

		return dp[0];
	}
}
