package programmers.basic;

public class Fatigue {
	class Solution {
		int answer;
		boolean[] selections;

		public int solution(int k, int[][] dungeons) {
			selections = new boolean[dungeons.length];
			answer = 0;

			dfs(0, k, dungeons, 0);

			return answer;
		}

		public void dfs(int depth, int k, int[][] dungeons, int cnt) {
			answer = Math.max(answer, cnt);

			if (depth == dungeons.length) {
				return;
			}

			for (int i = 0; i < dungeons.length; i++) {
				if (selections[i])
					continue;
				if (dungeons[i][0] > k)
					continue;

				selections[i] = true;
				dfs(depth + 1, k - dungeons[i][1], dungeons, cnt + 1);
				selections[i] = false;
			}
		}
	}
}
