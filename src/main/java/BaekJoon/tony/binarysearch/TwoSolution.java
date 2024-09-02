package BaekJoon.tony.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TwoSolution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		long[] solutions = new long[n];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < n; i++) {
			solutions[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(solutions);
		int start = 0;
		int end = n - 1;
		long answer = Long.MAX_VALUE;
		List<Long> answers = new ArrayList<>();
		while (start < end) {
			long sum = Math.abs(solutions[start] + solutions[end]);
			if (answer >= sum) {
				answer = sum;
				answers = List.of(solutions[start], solutions[end]);
			}

			sum = solutions[start] + solutions[end];
			if (sum > 0) {
				end--;
			} else if (sum < 0) {
				start++;
			}
		}

		System.out.println(answers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
