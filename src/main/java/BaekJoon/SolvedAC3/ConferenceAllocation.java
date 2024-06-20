package BaekJoon.SolvedAC3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConferenceAllocation {
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
			if (a.end == b.end) {
				return a.start - b.start;
			}

			return a.end - b.end;
		};
		conferenceis.sort(sortable);

		int count = 1;
		int prevEndTime = conferenceis.get(0).end;
		for (int i = 1; i < n; i++) {
			Conference conference = conferenceis.get(i);
			if (conference.start >= prevEndTime) {
				count++;
				prevEndTime = conference.end;
			}
		}

		System.out.println(count);
	}
}
