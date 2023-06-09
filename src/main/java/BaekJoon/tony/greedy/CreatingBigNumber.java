package BaekJoon.tony.greedy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreatingBigNumber {
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	public static void main(String[] args) {
		st = token();
		int n = parse(next());
		int k = parse(next());
		st = token();
		String number = next();
		print(createBigNumber(n, k, number));
	}

	static String createBigNumber(int n, int k, String number) {
		Deque<Integer> s = new LinkedList<>() {
		};
		int capacity = n - k;
		for (int i = 0; i < number.length(); i++) {
			int val = number.charAt(i) - '0';

			if (s.isEmpty()) {
				s.offerLast(val);
			} else {
				boolean isValid = s.size() + (n - i) > capacity; // 현재 위치에서 앞자리를 버려도 n-k개 만큼의 숫자를 만들 수 있는가?
				while (!s.isEmpty() && isValid && s.peekLast() < val) {
					s.removeLast();
				}

				s.offerLast(val);
			}
		}

		int cnt = 0;
		StringBuilder answer = new StringBuilder();
		while (cnt < capacity) {
			answer.append(s.pollFirst());
			cnt++;
		}

		return answer.toString();
	}

	static int parse(String s) {
		return Integer.parseInt(s);
	}

	static void print(String s) {
		System.out.println(s);
	}

	static StringTokenizer token() {
		return new StringTokenizer(sc.nextLine());
	}

	static String next() {
		return st.nextToken();
	}
}
