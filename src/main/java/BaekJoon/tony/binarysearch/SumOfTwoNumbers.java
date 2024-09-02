package BaekJoon.tony.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfTwoNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(sc.readLine());
		StringBuilder answers = new StringBuilder();
		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(sc.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] numbers = new int[n];
			st = new StringTokenizer(sc.readLine());
			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(numbers);

			int answer = 0;
			int s = 0;
			int e = n - 1;
			int minGap = Integer.MAX_VALUE;

			while (s < e) {
				int sum = numbers[s] + numbers[e];
				int gap = Math.abs(sum - k);

				if (minGap > gap) {
					minGap = gap;
					answer = 1;
				} else if (minGap == gap) {
					answer++;
				}

				if (sum > k) {
					e--;
				} else {
					s++;
				}

			}

			answers.append(answer)
				.append(System.lineSeparator());
		}

		System.out.println(answers);
	}

}
