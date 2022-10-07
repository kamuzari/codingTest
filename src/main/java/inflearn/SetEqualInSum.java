package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SetEqualInSum {

	private static int n;
	private static int[] sets;
	private static int v;
	private static String answer = "NO";

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());

		StringTokenizer st = new StringTokenizer(reader.readLine());
		sets = new int[n];
		v = 0;

		for (int i = 0; i < n; i++) {
			sets[i] = Integer.parseInt(st.nextToken());
		}

		for (int target = 1; target < n; target++) {
			pick(0, target);
		}

		System.out.println(answer);
	}

	private static void pick(int cnt, int target) {
		if (cnt == target) {
			int sumA = 0;
			int sumB = 0;

			for (int i = 0; i < n; i++) {
				if ((v & (1 << i)) > 0) {
					sumA += sets[i];
				} else {
					sumB += sets[i];
				}
			}

			if (sumA == sumB) {
				answer = "YES";
			}

			return;
		}

		for (int i = 0; i < n; i++) {
			if ((v & (1 << i)) > 0) {
				continue;
			}
			v = v | (1 << i);
			pick(cnt + 1, target);
			v = v & ~(1 << i);
		}
	}
}
