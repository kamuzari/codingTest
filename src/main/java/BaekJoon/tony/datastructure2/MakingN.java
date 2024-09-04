package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MakingN {

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
			Deque<Integer> container = new LinkedList<>();
			v[i] = true;
			container.offer(digits[i]);
			System.out.println("------------> " + digits[i]);
			create(0, container);
			v[i] = false;
		}

		System.out.println(answer);
	}

	/**
	 * todo: 중복을 제거해야 한다.
	 * @param cnt
	 * @param candidates
	 */
	private static void create(int cnt, Deque<Integer> candidates) {
		System.out.println(candidates);
		if (cnt == n - 1) {
			String result = candidates.stream()
				.map(String::valueOf).collect(Collectors.joining());

			if (number.equals(result)) {
				System.out.println("------------- 정답 ----------- :" + candidates.toString());
				answer++;
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;

			v[i] = true;
			candidates.addFirst(digits[i]);
			create(cnt + 1, candidates);
			candidates.pollFirst();
			v[i] = false;

			v[i] = true;
			candidates.addLast(digits[i]);
			create(cnt + 1, candidates);
			candidates.pollLast();
			v[i] = false;
		}

	}

	private static int toInt(char a) {
		return a - '0';
	}
}
