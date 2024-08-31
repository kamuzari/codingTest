package BaekJoon.tony.binarysearch;

import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CutString {
	static int n, m;
	private static char[][] table;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		table = new char[n][m];
		for (int i = 0; i < n; i++) {
			table[i] = sc.nextLine().toCharArray();
		}

		int s = 0;
		int e = n - 1;
		int answer = 0;

		while (s <= e) {
			int mid = (s + e) >> 1;

			if (isPossible(mid)) {
				answer = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}

		System.out.println(answer);
	}

	private static boolean isPossible(int startRow) {
		HashSet<String> set = new HashSet<>();
		for (int col = 0; col < m; col++) {
			StringBuilder result = read(startRow, col);

			if (set.contains(result.toString())) {
				return false;
			}

			set.add(result.toString());
		}

		return true;
	}

	private static StringBuilder read(int startRow, int fixedCol) {
		StringBuilder result = new StringBuilder();

		for (int row = startRow; row < n; row++) {
			result.append(table[row][fixedCol]);
		}
		return result;
	}
}
