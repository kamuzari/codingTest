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
			PriorityQueue<Long> pq = new PriorityQueue<>();
			Arrays.stream(arr).mapToLong(v -> v).forEach(pq::offer);
			long result = 0;
			while (pq.size() != 1) {
				long a = pq.poll();
				long b = pq.poll();
				long sum = a + b;
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
