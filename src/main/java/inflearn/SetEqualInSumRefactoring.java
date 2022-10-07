package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SetEqualInSumRefactoring {
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

		int sum = Arrays.stream(sets).sum();

		pick(0, 0, sum, 0);

		System.out.println(answer);
	}

	private static void pick(int cnt, int idx, int total, int sum) {
		if (total == sum) {
			answer = "YES";
			return;
		}

		for (int i = idx; i < n; i++) {
			if ((v & (1 << i)) > 0) {
				continue;
			}

			v = v | (1 << i);
			pick(cnt + 1, i + 1, total - sets[i], sum + sets[i]);
			v = v & ~(1 << i);
		}
	}
}
