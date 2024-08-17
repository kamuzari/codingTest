package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calendar {

	static class Interval {
		int s, e;

		public Interval(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int n = Integer.parseInt(reader.readLine());
		int[] cells = new int[367];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			cells[start]++;
			cells[end + 1]--;
		}

		Stack<Integer> pairs = new Stack<>();
		List<Interval> intervals = new ArrayList<>();
		for (int i = 1; i <= 366; i++) {
			cells[i] += cells[i - 1];
			if (cells[i] > 0) {
				if (pairs.isEmpty()) {
					pairs.push(i);
				}
			} else {
				if (!pairs.isEmpty()) {
					Integer start = pairs.pop();
					int end = i - 1;
					intervals.add(new Interval(start, end));
				}
			}
		}

		for (Interval interval : intervals) {
			int maxH = 0;
			for (int i = interval.s; i <= interval.e; i++) {
				maxH = Math.max(maxH, cells[i]);
			}
			int width = interval.e - interval.s + 1;
			int height = maxH;

			answer += (width * height);
		}

		System.out.println(answer);
	}
}
