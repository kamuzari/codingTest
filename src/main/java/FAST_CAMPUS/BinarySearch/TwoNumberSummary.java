package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoNumberSummary {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int[] numbers = new int[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		int targetSummary = Integer.parseInt(reader.readLine());

		int finding = 0;

		for (int i = 0; i < n; i++) {
			int target = targetSummary - numbers[i];

			if (isExist(numbers, target, i)) {
				finding++;
			}
		}

		System.out.println(sliding(numbers, targetSummary));
		System.out.println(finding);
	}

	/**
	 * note: 이분 탐색
	 */
	private static boolean isExist(int[] numbers, int target, int pivot) {
		int l = pivot + 1;
		int r = numbers.length - 1;

		while (l <= r) {
			int mid = (l + r) >> 1;

			if (numbers[mid] < target) {
				l = mid + 1;
			} else if (numbers[mid] == target) {
				return true;
			} else {
				r = mid - 1;
			}
		}

		return false;
	}

	private static int sliding(int[] numbers, int target) {
		int pairCount = 0;
		int l = 0;
		int r = numbers.length - 1;

		while (l < r) {
			int sum = numbers[l] + numbers[r];

			if (sum == target) {
				pairCount++;
				l++;
			} else if (sum > target) {
				r--;
			} else {
				l++;
			}
		}

		return pairCount;
	}
}
