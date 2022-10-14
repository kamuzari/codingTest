package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ResolvingMaximumScore_DP {
	static class Problem {
		private int score;
		private int time;

		public Problem(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Problem[] problems = new Problem[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());

			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			problems[i] = new Problem(score, time);
		}

		int[] scores = new int[m + 1];

		for (int i = 0; i < n; i++) {
			Problem criteria = problems[i];
			// hint - 순차적으로 접근하면 j<=m 똑같은 문제를 또 푸는 문제가 발생한다!
			for (int j = m; j >= criteria.time; j--) {
				scores[j] = Math.max(scores[j], scores[j - criteria.time] + criteria.score);
			}
		}

		System.out.println(scores[m]);
	}
}

/**
 6 3
 7 4
 10 5
 15 8
 25 12
 */
