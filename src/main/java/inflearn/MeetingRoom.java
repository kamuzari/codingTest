package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoom {
	static class Conference implements Comparable<Conference> {
		private int start;
		private int end;

		public Conference(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Conference o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}

			return this.end - o.end;
		}

		public boolean isPossibleNext(int end) {
			return this.start >= end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		Conference[] conferences = new Conference[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			conferences[i] = new Conference(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			);
		}

		Arrays.sort(conferences);

		int answer = 1;
		int criteriaEndTime = conferences[0].end;

		for (int i = 1; i < n; i++) {
			Conference next = conferences[i];

			if (next.isPossibleNext(criteriaEndTime)) {
				answer++;
				criteriaEndTime = conferences[i].end;
			}
		}

		System.out.println(answer);
	}
}
