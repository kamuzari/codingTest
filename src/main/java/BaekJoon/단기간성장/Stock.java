package BaekJoon.단기간성장;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Stock {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringBuilder answer = new StringBuilder();
		int tc = Integer.parseInt(sc.nextLine());
		for (int testCase = 0; testCase < tc; testCase++) {
			long result = 0L;
			int n = Integer.parseInt(sc.nextLine());
			int[] prices = new int[n];
			int[] max = new int[n];
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < n; i++) {
				max[i] = prices[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = n - 2; i >= 0; i--) {
				max[i] = Math.max(max[i], max[i + 1]);
			}

			for (int i = 0; i < n; i++) {
				if (max[i] - prices[i] > 0) {
					result += (long)max[i] - prices[i];
				}
			}

			answer.append(result).append(System.lineSeparator());
		}
		System.out.println(answer);
	}
}
