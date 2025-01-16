package programmers.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HotelShortTimeRoom {
	class Time {
		int start;
		int end;

		public Time(String[] input) {
			start = toMinute(input[0].split(":"));
			end = toMinute(input[1].split(":")) + 10;
		}

		int toMinute(String[] s) {
			return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
		}
	}

	public int solution(String[][] book_time) {
		int answer = 0;
		List<Time> times = new ArrayList<>();
		for (String[] time : book_time) {
			times.add(new Time(time));
		}

		times.sort((a, b) -> {
			if (a.start == b.start) {
				return a.end - b.end;
			}

			return a.start - b.start;
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Time t : times) {
			if (!pq.isEmpty() && pq.peek() <= t.start) {
				pq.poll();
			}

			pq.offer(t.end);

			answer = Math.max(answer, pq.size());
		}

		return answer;
	}

}
