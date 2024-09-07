package BaekJoon.tony.datastructure2.makingn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MakingN_Guide {

	private static int n;
	private static boolean[] v;
	private static int[] digits;
	private static String number;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		number = reader.readLine();
		n = number.length();
		digits = new int[n];
		v = new boolean[n];

		int idx = 0;
		for (char c : number.toCharArray()) {
			digits[idx++] = toInt(c);
		}

		for (int i = 0; i < n; i++) {
			dfs(i, i, "" + digits[i], "" + digits[i]);
		}

		System.out.println(set.size());
	}

	static Set<String> set = new HashSet<>();
	static int depth = 0;

	static void dfs(int L, int R, String s, String path) {
		System.out.println(depth++);
		System.out.println("   s = " + s);
		System.out.println("   path = " + path);
		if (L == 0 && R == digits.length - 1) {
			set.add(path);
			return;
		}

		if (L - 1 >= 0) {
			dfs(L - 1, R, digits[L - 1] + s, path + " " + digits[L - 1] + s);
		}
		if (R + 1 < digits.length) {
			dfs(L, R + 1, s + digits[R + 1], path + " " + s + digits[R + 1]);
		}
	}

	private static int toInt(char a) {
		return a - '0';
	}
}
