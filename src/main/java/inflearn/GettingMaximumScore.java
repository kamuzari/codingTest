package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GettingMaximumScore {

	static private int limitTime;
	static private int n;
	static private int maxScore;
	static private Problem[] problems;

	static class Problem {
		private int score;
		private int time;

		public Problem(int score, int time) {
			this.score = score;
			this.time = time;
		}

		public int getScore() {
			return score;
		}

		public int getTime() {
			return time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		limitTime = Integer.parseInt(st.nextToken());

		problems = new Problem[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			problems[i] = new Problem(score, time);
		}

		resolveProblems(0, 0, 0);

		System.out.println(maxScore);
	}

	private static void resolveProblems(int depth, int earningScore, int timeSpent) {
		if (timeSpent > limitTime) {
			return;
		}

		if (depth >= n) {
			maxScore = Math.max(maxScore, earningScore);
			return;
		}

		resolveProblems(
			depth + 1,
			earningScore + problems[depth].getScore(),
			timeSpent + problems[depth].getTime()
		);

		resolveProblems(
			depth + 1, earningScore, timeSpent
		);
	}
}
