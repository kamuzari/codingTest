package BaekJoon.tony.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SectionDivision2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int LMITED_INTERVAL = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = Arrays.stream(arr).max().getAsInt();
		// 왜 lowerBound
		int answer = Integer.MAX_VALUE;
		while (start < end) {
			int diffValue = (start + end) >> 1;

			int interval = countInterval(diffValue, arr);
			if (interval <= LMITED_INTERVAL) {
				end = diffValue;
			} else {
				start = diffValue + 1;
			}
		}

		System.out.println(end);
	}

	private static int countInterval(int diffValue, int[] arr) {
		int MIN = Integer.MAX_VALUE;
		int MAX = -Integer.MAX_VALUE;
		int interval = 1;
		for (int i = 0; i < arr.length; i++) {
			MIN = Math.min(MIN, arr[i]);
			MAX = Math.max(MAX, arr[i]);
			if (MAX - MIN > diffValue) {
				interval++;
				MIN = Integer.MAX_VALUE;
				MAX = -Integer.MAX_VALUE;
				i--;
			}
		}

		return interval;
	}
}
