package programmers.lv2;

import java.util.Arrays;

public class InterceptionSystem {
	public int solution(int[][] targets) {
		Arrays.sort(targets, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}

			return a[0] - b[0];
		});

		int answer = 1;
		int end = targets[0][1];
		for (int i = 1; i < targets.length; i++) {
			int nextStart = targets[i][0];
			int nextEnd = targets[i][1];

			if (nextStart < end) {
				end = Math.min(end, nextEnd);
				continue;
			}

			answer++;
			end = nextEnd;
		}
		return answer;
	}
}
