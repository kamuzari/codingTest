package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumIncomeSchedule {
	static class Node implements Comparable<Node> {
		private int income;
		private int day;

		public Node(int income, int day) {
			this.income = income;
			this.day = day;
		}

		@Override
		public int compareTo(Node other) {
			return other.day - this.day;
		}

	}

	/**
	 * note : 날짜가 큰 순서 대로 ordering 해야한다.
	 * why : 기간이 길면 길수록 해당 시간안에 강의를 하면 그만이기 때문이다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int maxDay = 0;
		List<Node> lectures = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] input = reader.readLine().split(" ");
			int income = Integer.parseInt(input[0]);
			int day = Integer.parseInt(input[1]);
			maxDay = Math.max(maxDay, day);
			lectures.add(new Node(income, day));
		}

		Collections.sort(lectures);
		PriorityQueue<Node> possibleSchedules = new PriorityQueue<>((a, b) -> b.income - a.income);

		int totalIncome = 0;
		int j=0;
		for (int today = maxDay; today >= 1; today--) {
			for (; j < lectures.size(); j++) { // note: 이미 했던 강의가 중복으로 선정되어 수입료에 포함될 수 있음.. [값의 중복 조심]
				if (lectures.get(j).day < today)
					break;

				Node cur = lectures.get(j);
				possibleSchedules.offer(new Node(cur.income, cur.day));
			}

			if (!possibleSchedules.isEmpty()) {
				totalIncome += possibleSchedules.poll().income;
			}
		}

		System.out.println(totalIncome);
	}
}
