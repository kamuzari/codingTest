package BaekJoon.tony.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class HappyKindergarden {
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	public static void main(String[] args) throws java.lang.Exception {
		st = createToken();
		int n = parse(next());
		int m = parse(next());

		int[] arr = new int[n];
		st = createToken();
		for (int i = 0; i < n; i++) {
			arr[i] = parse(next());
		}

		// 1.그룹핑 -> 구현은 어떻게 구현하는지 모르겠다.
		// 2. 각 그룹별 최대 최소 차이를 구하라.
		// 끗.

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i < n; i++) {
			list.add(arr[i] - arr[i - 1]);
		}

		Collections.sort(list);

		int answer = 0;
		for (int i = 0; i < n - m; i++) {
			answer += list.get(i);
		}

		print(String.valueOf(answer));
	}

	public static void print(String s) {
		System.out.println(s);
	}

	public static String line() {
		return sc.nextLine();
	}

	public static StringTokenizer createToken() {
		return new StringTokenizer(line());
	}

	public static String next() {
		return st.nextToken();
	}

	public static int parse(String s) {
		return Integer.parseInt(s);
	}
}
