package saffy.demotest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ResolveMaximumFrequency {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringBuilder answers = new StringBuilder();
		int repeatCount = toInt(sc.nextLine());

		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			int testNumber = toInt(sc.nextLine());
			Map<Integer, Integer> scoreCounts = new HashMap<>();
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			while (st.hasMoreTokens()) {
				int score = toInt(st.nextToken());
				scoreCounts.put(score, scoreCounts.getOrDefault(score, 0) + 1);
			}

			Integer maximumFrequencyScore = scoreCounts.keySet()
					.stream()
					.sorted((o1, o2) -> {
						if (scoreCounts.get(o1).equals(scoreCounts.get(o2))) {
							return o2 - o1;
						}

						return scoreCounts.get(o2) - scoreCounts.get(o1);
					}).toList()
					.get(0);

			String answer = String.format("#%d %d", testCase, maximumFrequencyScore);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
