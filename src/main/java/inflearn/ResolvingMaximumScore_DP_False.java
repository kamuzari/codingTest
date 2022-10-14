package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ResolvingMaximumScore_DP_False {
	/**
	 * note : 한 유형당 1문제만 풀 수 있다. (no idea)
	 */
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

		Arrays.sort(problems, (a, b) -> {
			if (a.time == b.time) {
				return a.score - b.score;
			}

			return a.time - b.time;
		});

		int[] scores = new int[m + 1];
		Set<Integer>[] resovled = new Set[m+1];

		Arrays.fill(resovled, new HashSet<>());

		for (int i = 0; i < n; i++) {
			Problem criteria = problems[i];
			for (int j = criteria.time; j <= m; j++) {
				if (scores[j] < scores[j - criteria.time] + criteria.score && !resovled[j - criteria.time].contains(i) ) {
					scores[j] = scores[j - criteria.time] + criteria.score;
					resovled[j] = new HashSet<>(resovled[j - criteria.time]);
					resovled[j].add(i);
				}
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
