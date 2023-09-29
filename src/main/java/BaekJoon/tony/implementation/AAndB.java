package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AAndB {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String S = reader.readLine();
		String T = reader.readLine();

		boolean isPossible = isChangeAtoB(S, T);
		int answer = isPossible ? 1 : 0;
		System.out.println(answer);
	}

	private static boolean isChangeAtoB(String S, String T) {
		// 완전탐색하면 2^10000승으로 안됨//
		StringBuilder copyT = copy(T);
		while (copyT.length() != S.length()) {
			int lastIndex = copyT.length() - 1;

			if (copyT.charAt(lastIndex) == 'A') {
				removeTail(copyT, lastIndex);
			} else if (copyT.charAt(lastIndex) == 'B') {
				removeTail(copyT, lastIndex);
				copyT.reverse();
			}
		}

		return copyT.toString().equals(S);
	}

	private static void removeTail(StringBuilder copyT, int lastIndex) {
		copyT.deleteCharAt(lastIndex);
	}

	private static StringBuilder copy(String T) {
		StringBuilder sb = new StringBuilder();

		for (char ch : T.toCharArray()) {
			sb.append(ch);
		}

		return sb;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
