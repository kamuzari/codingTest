package BaekJoon.SolvedAC4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ResolvingMinimumConferenceRoom {
	static class Conference {
		private int start, end;

		public Conference(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<Conference> conferenceis = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			conferenceis.add(new Conference(start, end));
		}

		Comparator<Conference> sortable = (a, b) -> {
			if (a.start == b.start) {
				return a.end - b.end;
			}

			return a.start - b.start;
		};
		conferenceis.sort(sortable);
		PriorityQueue<Conference> restMeetings = new PriorityQueue<>((a, b) -> a.end - b.end);
		for (int i = 0; i < n; i++) {
			Conference next = conferenceis.get(i);
			if (restMeetings.isEmpty()) {
				restMeetings.offer(next);
				continue;
			}

			boolean enableGrouping = restMeetings.peek().end <= next.start;
			if (enableGrouping) {
				restMeetings.poll();
			}

			restMeetings.offer(next);
		}

		System.out.println(restMeetings.size());
	}
}
