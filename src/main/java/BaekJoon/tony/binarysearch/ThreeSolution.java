package BaekJoon.tony.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ThreeSolution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		StringTokenizer st = new StringTokenizer(sc.nextLine());

		List<Integer> solutions = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			solutions.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(solutions);

		solve(n, solutions);
	}

	static void solve(int n, List<Integer> solutions) {
		String answer = "";
		int s = 0;
		int e = n - 1;
		int result = 2_000_000_000;
		while (s < e) {
			if (e >= n) {
				break;
			}

			int diff = Math.abs(solutions.get(s) + solutions.get(e));
			if (diff < result) {
				result = diff;
				answer = solutions.get(s) + " " + solutions.get(e);
			}

			if (Math.abs(solutions.get(s)) > Math.abs(solutions.get(e))) {
				s++;
			} else {
				e--;
			}
		}

		System.out.println(answer);
	}
}
