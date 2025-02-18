package programmers.basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lifeboat {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		Arrays.sort(people);
		for (int val : people) {
			dq.offer(val);
		}

		while (!dq.isEmpty()) {
			int maxVal = dq.pollLast();
			if (!dq.isEmpty() && maxVal + dq.peekFirst() <= limit) {
				dq.pollFirst();
			}
			answer++;
		}

		return answer;
	}
}
