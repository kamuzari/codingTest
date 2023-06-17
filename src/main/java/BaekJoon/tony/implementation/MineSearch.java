package BaekJoon.tony.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class MineSearch {
	static Scanner sc = new Scanner(System.in);

	static int d[][] = {
		{-1, 0},
		{-1, -1},
		{0, -1},
		{1, -1},
		{1, 0},
		{1, 1},
		{0, 1},
		{-1, 1}
	};
	static int n;

	public static void main(String[] args) {
		n = parse(sc.nextLine());
		char[][] origin = new char[n][n];

		int repeat = n;
		while (repeat-- > 0) {
			origin[n - 1 - repeat] = sc.nextLine().toCharArray();
		}

		repeat = n;
		char[][] next = new char[n][n];
		while (repeat-- > 0) {
			next[n - 1 - repeat] = sc.nextLine().toCharArray();
		}

		char answer[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(answer[i], '.');
		}

		boolean isMine = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (next[i][j] != 'x')
					continue;

				if (origin[i][j] == '*') {
					isMine = true;
				}

				boolean isChange = false;
				for (int k = 0; k < 8; k++) {
					int ny = i + d[k][0];
					int nx = j + d[k][1];

					if (isOutOfIndex(ny, nx))
						continue;

					if (origin[ny][nx] != '*') {
						continue;
					}

					isChange = true;
					if (answer[i][j] == '.') {
						answer[i][j] = '1';
					} else {
						int val = answer[i][j] - '0';
						val++;
						answer[i][j] = String.valueOf(val).charAt(0);

					}
				}

				if (!isChange) {
					answer[i][j] = '0';
				}
			}
		}

		if (isMine) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (origin[i][j] == '*')
						answer[i][j] = '*';
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}

	static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}

	static int parse(String s) {
		return Integer.parseInt(s);
	}

}
