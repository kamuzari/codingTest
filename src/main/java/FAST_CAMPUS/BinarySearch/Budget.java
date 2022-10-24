package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Budget {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		int[] requirements = new int[n];

		StringTokenizer st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			requirements[i] = Integer.parseInt(st.nextToken());
		}

		int target = Integer.parseInt(reader.readLine());

		long answer = 0;
		int l = 0;
		int r = Arrays.stream(requirements).max().orElseGet(() -> 0);

		while (l <= r) {
			int upperBound = (l + r) >> 1;

			if (target < upperBound) {
				r = upperBound - 1;
			} else {
				long totalBudget = getTotalBudget(requirements, upperBound);

				if (totalBudget <= target) {
					answer = Math.max(upperBound, answer);
					l = upperBound + 1;
				} else {
					r = upperBound - 1;
				}
			}
		}

		System.out.println(answer);
	}

	private static long getTotalBudget(int[] requirements, int promising) {
		return Arrays.stream(requirements)
			.map(requirement -> {
				if (requirement < promising) {
					return requirement;
				}

				return promising;
			})
			.sum();
	}

}
