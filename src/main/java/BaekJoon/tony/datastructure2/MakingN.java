package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MakingN {

	private static char[] digits;
	private static int n;
	private static boolean[] v;
	private static String original;
	private static int answer;
	private static Set<String> histories;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		original = reader.readLine();
		digits = original.toCharArray();
		n = digits.length;
		v = new boolean[n];
		histories = new HashSet<>();
		for (int i = 0; i < n; i++) {
			v[i] = true;
			create(1, "" + digits[i], "" + digits[i]);
			v[i] = false;
		}

		System.out.println(histories.size());
	}

	private static void create(int cnt, String s, String order) {
		boolean isEndPoint = cnt == n;

		if (isEndPoint) {
			if (original.equals(s)) {
				histories.add(order);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;

			v[i] = true;
			String next = digits[i] + s;
			create(cnt + 1, next, order + " " + next);
			v[i] = false;

			v[i] = true;
			next = s + digits[i];
			create(cnt + 1, next, order + " " + next);
			v[i] = false;
		}

	}
}
