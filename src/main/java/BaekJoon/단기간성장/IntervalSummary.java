package BaekJoon.단기간성장;

import java.util.Scanner;
import java.util.StringTokenizer;

public class IntervalSummary {
	private static final int UPDATE = 1;
	private static final int GET_INTERVAL_SUMMARY = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(sc.nextLine());
		}
		summaries = new long[n * 4];
		init(1, n, 1);

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(sc.nextLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == UPDATE) {
				int idx = Integer.parseInt(st.nextToken());
				long toValue = Long.parseLong(st.nextToken());
				long diffValue = toValue - arr[idx];
				arr[idx] = toValue;
				update(1, n, 1, idx, diffValue);
			} else if (command == GET_INTERVAL_SUMMARY) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				// todo: segment resolve
				long summary = getSum(1, n, 1, from, to);
				answer.append(summary).append(System.lineSeparator());
			}
		}

		System.out.print(answer);
	}

	static long[] arr;
	static long[] summaries;

	static long init(int start, int end, int idx) {
		if (start == end) {
			return summaries[idx] = arr[start];
		}

		int midIdx = (start + end) >> 1;
		return summaries[idx] = init(start, midIdx, idx * 2) + init(midIdx + 1, end, idx * 2 + 1);
	}

	static long getSum(int start, int end, int idx, int from, int to) {
		if (from > end || to < start)
			return 0L;

		if (start >= from && end <= to) {
			return summaries[idx];
		}

		int mid = (start + end) >> 1;

		return getSum(start, mid, idx * 2, from, to) + getSum(mid + 1, end, idx * 2 + 1, from, to);
	}

	static void update(int start, int end, int node, int idx, long diffValue) {
		if (idx < start || idx > end)
			return;

		summaries[node] += diffValue;
		if (start == end)
			return;

		int midIdx = (start + end) >> 1;

		update(start, midIdx, node * 2, idx, diffValue);
		update(midIdx + 1, end, node * 2 + 1, idx, diffValue);
	}
}
