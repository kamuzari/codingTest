package programmers.basic;

import java.util.Stack;

public class FindTheBigNumberBehind {
	public int[] solution(int[] numbers) {
		int n = numbers.length;
		int[] answer = new int[n];
		Stack<Integer> s = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && s.peek() <= numbers[i]) {
				s.pop();
			}

			if (s.isEmpty()) {
				answer[i] = -1;
			} else {
				answer[i] = s.peek();
			}

			s.push(numbers[i]);
		}

		return answer;
	}
}
