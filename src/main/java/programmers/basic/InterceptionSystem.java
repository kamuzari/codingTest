package programmers.basic;

import java.util.Arrays;
import java.util.Comparator;

public class InterceptionSystem {
	public int solution(int[][] targets) {
		int answer = 0;
		Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));
		int prev = 0;

		for (int i = 0; i < targets.length; i++) {
			if (prev <= targets[i][0]) {
				answer++;
				prev = targets[i][1];
			}
		}

		return answer;
	}
}
