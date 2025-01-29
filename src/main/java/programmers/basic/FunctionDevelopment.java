package programmers.basic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FunctionDevelopment {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answers = new ArrayList<>();
		int n = progresses.length;

		Deque<Integer> works = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			int end = calcualteEndTime(progresses[i], speeds[i]);
			works.add(end);
		}

		while (!works.isEmpty()) {
			int endTime = works.poll();
			int count = 1;
			while (!works.isEmpty() && endTime >= works.peek()) {
				works.poll();
				count++;
			}
			answers.add(count);
		}

		return answers.stream().mapToInt(v -> v).toArray();
	}

	public int calcualteEndTime(int progress, int speed) {
		int restWorkload = (100 - progress);
		int quote = restWorkload / speed;

		if (restWorkload > quote * speed) {
			quote++;
		}

		return quote;
	}
}
