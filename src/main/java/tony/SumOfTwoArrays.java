package tony;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SumOfTwoArrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int targetValue = toInt(sc.nextLine());

		int n = Integer.parseInt(sc.nextLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < n; i++) {
			a[i] = toInt(st.nextToken());
		}

		int m = Integer.parseInt(sc.nextLine());
		int[] b = new int[m];
		st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < m; i++) {
			b[i] = toInt(st.nextToken());
		}

		Map<Integer, Integer> countAContainer = getSubSummaries(n, a);
		Map<Integer, Integer> countBContainer = getSubSummaries(m, b);

		long answer = 0;
		for (int v : countAContainer.keySet()) {
			int target = targetValue - v;
			if (!countBContainer.containsKey(target)) {
				continue;
			}

			int countA = countAContainer.get(v);
			int countB = countBContainer.get(target);
			long result = (long)countA * countB;
			answer += result;
		}

		System.out.println(answer);
	}

	private static Map<Integer, Integer> getSubSummaries(int n, int[] a) {
		Map<Integer, Integer> countContainer = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				int key = sum;
				countContainer.put(key, countContainer.getOrDefault(key, 0) + 1);
			}
		}

		return countContainer;
	}

	static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
