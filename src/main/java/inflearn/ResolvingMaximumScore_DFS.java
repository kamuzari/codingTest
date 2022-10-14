package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ResolvingMaximumScore_DFS {

	private static int n;
	private static int m;

	private static int answer;
	private static Problem[] problems;

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

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		problems = new Problem[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());

			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			problems[i] = new Problem(score, time);
		}

		dfs(0, 0, 0);

		System.out.println(answer);
	}

	public static void dfs(int cnt, int totalScore, int time) {
		if (time > m) {
			return;
		}

		if (cnt == n) {
			answer = Math.max(answer, totalScore);
			return;
		}

		dfs(cnt + 1, totalScore + problems[cnt].score, time + problems[cnt].time);
		dfs(cnt + 1, totalScore, time);
	}
}
