package BaekJoon._자료구조구현.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int n = Integer.parseInt(reader.readLine());
		int myCards[] = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			myCards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(myCards);

		int m = Integer.parseInt(reader.readLine());
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());

			int lowerIndex = lowerBound(myCards, target);
			int upperIndex = upperBound(myCards, target);

			int number = upperIndex - lowerIndex;
			answer.append(number).append(" ");
		}

		System.out.println(answer);
	}

	private static int lowerBound(int[] arr, int target) {
		int start = 0;
		int end = arr.length;

		while (start < end) {
			int mid = (start + end) >> 1;

			if (arr[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}

	private static int upperBound(int[] arr, int target) {
		int start = 0;
		int end = arr.length;

		while (start < end) {
			int mid = (start + end) >> 1;

			if (arr[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}
}
