package saffy.ssafy.homework.daily06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IntervalSummary {
	static Map<Long, Long> maps = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine());

		StringBuilder answer = new StringBuilder();
		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			long result = solve(end) - solve(start - 1);
			answer.append("#")
				.append(testCase)
				.append(" ")
				.append(result)
				.append(System.lineSeparator());
		}

		System.out.println(answer);
	}

	static long solve(long n) {
		if (maps.containsKey(n)) {
			return maps.get(n);
		}

		if (n < 10) {
			long result = n * (n + 1) / 2;
			maps.put(n, result);
			return result;
		}

		long v = 1L;
		long number = n;
		while (number >= 10) {
			v *= 10;
			number /= 10;
		}

		long result = solve(n - 1 - (n % v)) + (n / v) * (n % v + 1) + solve(n % v);
		maps.put(n, result);
		return result;
	}
}
