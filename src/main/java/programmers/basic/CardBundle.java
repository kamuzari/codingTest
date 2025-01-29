package programmers.basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CardBundle {
	public String solution(String[] cards1, String[] cards2, String[] goal) {
		Deque<String> q1 = new ArrayDeque<>();
		Deque<String> q2 = new ArrayDeque<>();
		Arrays.stream(cards1).forEach(q1::add);
		Arrays.stream(cards2).forEach(q2::add);

		for (String word : goal) {
			if (!q1.isEmpty() && word.equals(q1.peek())) {
				q1.poll();
			} else if (!q2.isEmpty() && word.equals(q2.peek())) {
				q2.poll();
			} else {
				return "No";
			}
		}

		return "Yes";
	}
}
