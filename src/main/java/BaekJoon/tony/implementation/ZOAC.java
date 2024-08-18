package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZOAC {
	static StringBuilder answers = new StringBuilder();
	static boolean[] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		isUsed = new boolean[s.length()];

		resolve(s, 0, s.length() - 1);
		System.out.println(answers);
	}

	private static void resolve(String s, int start, int end) {
		if (start > end) {
			return;
		}

		char ch = ' ';
		int selectIdx = -1;
		for (int i = start; i <= end; i++) {
			if (isUsed[i])
				continue;
			boolean isInitialize = ch == ' ' && selectIdx == -1;
			if (isInitialize) {
				ch = s.charAt(i);
				selectIdx = i;
				isUsed[i] = true;
			}

			if (Character.compare(ch, s.charAt(i)) > 0) {
				ch = s.charAt(i);
				isUsed[selectIdx] = false;
				isUsed[i] = true;
				selectIdx = i;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (isUsed[i]) {
				answers.append(s.charAt(i));
			}
		}

		answers.append(System.lineSeparator());
		resolve(s, selectIdx + 1, end);
		resolve(s, start, selectIdx - 1);
	}

}
