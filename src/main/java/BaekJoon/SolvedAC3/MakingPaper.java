package BaekJoon.SolvedAC3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MakingPaper {
	static int[][] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		paper = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		split(0, 0, n);

		System.out.println(whiteCount);
		System.out.println(blueCount);
	}

	static int whiteCount;
	static int blueCount;

	static void split(int y, int x, int size) {
		if (size == 1) {
			count(y, x);
			return;
		}

		if (!isAllSame(y, x, size)) {
			split(y, x, size / 2);
			split(y, x + size / 2, size / 2);
			split(y + size / 2, x, size / 2);
			split(y + size / 2, x + size / 2, size / 2);
		} else {
			count(y, x);
		}

	}

	private static void count(int y, int x) {
		int standard = paper[y][x];

		if (standard == 0) {
			whiteCount++;
		} else {
			blueCount++;
		}
	}

	private static boolean isAllSame(int y, int x, int size) {
		int standard = paper[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (paper[i][j] != standard) {
					return false;
				}
			}
		}

		return true;
	}
}
