package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
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
			create(1, container, String.valueOf(digits[i]));
			v[i] = false;
		}

		System.out.println(answer);
	}

	/**
	 * todo: 중복을 제거해야 한다.
	 * @param pickCount
	 * @param candidates
	 */
	static Set<String> his = new HashSet<>();

	private static void create(int pickCount, Deque<Integer> candidates, String path) {
		if (pickCount != n && his.contains(path)) {
			return;
		}

		his.add(path);

		if (pickCount == n) {
			String result = candidates.stream().map(String::valueOf).collect(Collectors.joining());

			if (number.equals(result)) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;

			v[i] = true;
			candidates.addFirst(digits[i]);
			create(pickCount + 1, candidates, path + "F" + digits[i]);
			candidates.pollFirst();
			v[i] = false;

			v[i] = true;
			candidates.addLast(digits[i]);
			create(pickCount + 1, candidates, path + "B" + digits[i]);
			candidates.pollLast();
			v[i] = false;
		}

	}

	private static int toInt(char a) {
		return a - '0';
	}
}
