package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TwoSolution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] solutions = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(solutions);

		int left = 0;
		int right = n - 1;

		int gap = 2_000_000_000;

		int answer[] = new int[2];

		while (left < right) {
			int sum = solutions[left] + solutions[right];
			int absoluteValue = Math.abs(sum);

			if (absoluteValue < gap) {
				gap = absoluteValue;
				answer[0] = solutions[left];
				answer[1] = solutions[right];
			}

			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(
			Arrays.stream(answer).mapToObj(String::valueOf)
				.collect(Collectors.joining(" "))
		);

	}
}
