package programmers.basic;

import java.util.Arrays;

public class Budget {
	public int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);

		for (int i = 0; i < d.length; i++) {
			budget -= d[i];
			if (budget < 0) {
				return answer;
			}
			answer++;
		}
		return answer;
	}
}
