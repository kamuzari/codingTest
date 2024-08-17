package BaekJoon.tony.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PointOnLine {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] dots = new int[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			dots[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(dots);

		StringBuilder answers = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int count = upperBound(dots, e) - lowerBound(dots, s);
			answers.append(count)
				.append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static int lowerBound(int[] candidates, int target) {
		int s = 0;
		int e = candidates.length;

		while (s < e) {
			int mid = (s + e) >> 1;
			int middleValue = candidates[mid];

			if (middleValue >= target) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}

		return e;
	}

	private static int upperBound(int[] candidates, int target) {
		int s = 0;
		int e = candidates.length;

		while (s < e) {
			int mid = (s + e) >> 1;
			int middleValue = candidates[mid];

			if (middleValue > target) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}

		return e;
	}
}
