package BaekJoon.tony.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FilSummary3 {
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	public static void main(String[] args) {
		st = token();
		int testCase = parse(next());
		StringBuilder answer = new StringBuilder();

		while (testCase-- > 0) {
			st = token();
			int n = parse(next());
			int[] arr = new int[n];
			st = token();
			for (int i = 0; i < n; i++) {
				arr[i] = parse(next());
			}

			//logic
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			Arrays.stream(arr).forEach(pq::offer);
			int result = 0;
			while (pq.size() != 1) {
				int a = pq.poll();
				int b = pq.poll();
				int sum = a + b;
				result += sum;
				pq.offer(sum);
			}

			answer.append(result).append("\n");
		}
		print(answer.toString());
	}

	static void print(String s) {
		System.out.println(s);
	}

	static int parse(String s) {
		return Integer.parseInt(s);
	}

	static String line() {
		return sc.nextLine();
	}

	static StringTokenizer token() {
		return new StringTokenizer(line());
	}

	static String next() {
		return st.nextToken();
	}
}
