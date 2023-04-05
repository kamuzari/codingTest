package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AAndB2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String A = reader.readLine();
		String B = reader.readLine();

		int answer = isChange(A, B) ? 1 : 0;

		System.out.println(answer);
	}

	static boolean isPossible = false;

	public static boolean isChange(String A, String B) {
		LinkedList<Character> results = new LinkedList<>();

		for (char c : A.toCharArray()) {
			results.offerLast(c);
		}

		tryAToB(B, results, true);

		return isPossible;
	}
	// AB -> BA , BAB -> BAB -> BABA

	/**
	 * 아이디어가 완전탐색밖에 생각안남 2^50. 14% TLE
	 * 무조건 마지막에 넣는 것이 아니라 이제는 앞으로 넣어줘야 한다.
	 */
	public static void tryAToB(String B, LinkedList<Character> result, boolean isStartFront) {
		if (isPossible || result.size() > B.length()) {
			return;
		}

		if (!isSimilar(B, result, isStartFront)) {
			return;
		}

		if (result.size() == B.length()) {

			if (isStartFront && isSame(B, result)) {
				isPossible = true;
			} else if (!isStartFront && isSameForTail(B, result)) {
				isPossible = true;
			}

			return;
		}

		if (isStartFront) {
			result.offerLast('A');
		} else {
			result.offerFirst('A');
		}
		tryAToB(B, result, isStartFront);
		if (isStartFront) {
			result.pollLast();
		} else {
			result.pollFirst();
		}

		if (isStartFront) {
			result.offerLast('B');
		} else {
			result.offerFirst('B');
		}
		tryAToB(B, result, !isStartFront);
		if (isStartFront) {
			result.pollLast();
		} else {
			result.pollFirst();
		}
	}

	/**
	 * 백트래킹 핵심 포인트
	 */
	public static boolean isSimilar(String B, LinkedList<Character> result, boolean isFrontStart) {
		StringBuilder sb = new StringBuilder();
		result.forEach(sb::append);

		return B.contains(sb.toString()) || B.contains(sb.reverse().toString());
	}

	private static boolean isSameForTail(String B, LinkedList<Character> result) {
		int n = result.size();
		for (int i = result.size() - 1; i >= 0; i--) {
			if (B.charAt(n - 1 - i) != result.get(i)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isSame(String B, LinkedList<Character> result) {
		for (int i = 0; i < result.size(); i++) {
			if (B.charAt(i) != result.get(i)) {
				return false;
			}
		}

		return true;
	}
}
