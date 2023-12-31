package saffy.demotest;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TwoNumberArray {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringBuilder answers = new StringBuilder();
		int repeatCount = toInt(sc.nextLine());

		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int n = toInt(st.nextToken());
			int m = toInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];

			st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < n; i++) {
				a[i] = toInt(st.nextToken());
			}

			st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < m; i++) {
				b[i] = toInt(st.nextToken());
			}

			if (a.length < b.length) {
				int[] clone = a.clone();
				a = b;
				b = clone;
			}

			int result = 0;
			for (int i = 0; i <= a.length - b.length; i++) {
				int partResult = 0;
				for (int j = 0; j < b.length; j++) {
					partResult += (a[i + j] * b[j]);
				}

				result = Math.max(result, partResult);
			}

			String answer = String.format("#%d %d", testCase, result);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	// note: 두개의 배열이 교환이 안되네!!
	private static void preprocess(int[] a, int[] b) {
		if (a.length > b.length) {
			return;
		}

		int[] clone = a.clone();
		a = b;
		b = clone;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
