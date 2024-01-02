package saffy.demotest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NumberOfChangyoungViliageGroups {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int repeatCount = toInt(sc.nextLine());
		StringBuilder answers = new StringBuilder();

		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int n = toInt(st.nextToken());
			int m = toInt(st.nextToken());
			int[] parents = initalize(n);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(sc.nextLine());
				int a = toInt(st.nextToken());
				int b = toInt(st.nextToken());

				union(a, b, parents);
			}

			cleanUp(n, parents);

			long groupCount = Arrays.stream(parents)
					.distinct()
					.count() - 1;

			String answer = String.format("#%d %d\n", testCase, groupCount);
			answers.append(answer);
		}

		System.out.println(answers);
	}

	private static void cleanUp(int n, int[] parents) {
		for (int i = 1; i <= n; i++) {
			find(i, parents);
		}
	}

	private static int[] initalize(int n) {
		int[] parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
		return parents;
	}

	private static void union(int a, int b, int[] parents) {
		a = find(a, parents);
		b = find(b, parents);

		if (a == b) {
			return;
		}

		if (a < b)
			parents[b] = a;
		else
			parents[a] = b;
	}

	private static int find(int a, int[] parents) {
		if (a == parents[a])
			return a;

		return parents[a] = find(parents[a], parents);
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
