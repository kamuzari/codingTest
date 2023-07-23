package BaekJoon._자료구조구현.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retire {
	static class Consalt {
		private int time;
		private int proft;

		public Consalt(int time, int profit) {
			this.time = time;
			this.proft = profit;
		}

		public int getTime() {
			return time;
		}

		public int getProft() {
			return proft;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		Consalt[] consalts = new Consalt[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			consalts[i] = new Consalt(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int[] dp = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			int nextDay = i + consalts[i].getTime();
			if (nextDay > n) {
				dp[i] = dp[i + 1];
				continue;
			}

			dp[i] = Math.max(dp[i + 1], dp[nextDay] + consalts[i].getProft());
		}

		System.out.println(dp[0]);
	}

	// 꼭 다음 거를 연이어 받을 필요는 없구나
	// 1일후에는 10원을 그후에는 3일기다려야한다, 하지만 2일 후에는 40을 얻을 수 있다.
	// 일단 뒤로 유효한것 꼭 fit한 날이 아니여도 된다? dp[next] 에서 next가 n+1작은데
	// 7 -> 8로 가도된다. 9로도 갈 수 있는거 아인가? 그지?
	// 그래서 dp[i] = Math.max(dp[i],dp[nextDay]) + profit이 아님.
	// dp[i+1] 과 다음 릴레이할 dp + 현재 지점의 수익을 더해야함.
}
