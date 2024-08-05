package BaekJoon.tony.shotestpath;

import java.util.Scanner;
import java.util.StringTokenizer;

public class APartyThatNeverEnds {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static long[][] dists;
	static StringTokenizer st;

	public static void main(String[] args) {
		input();
		preProcess();

		StringBuilder answers = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(sc.nextLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());

			from--;
			to--;

			if (dists[from][to] <= limit) {
				answers.append("Enjoy other party");
			} else {
				answers.append("Stay here");
			}

			answers.append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static void input() {
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dists = new long[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < n; j++) {
				dists[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void preProcess() {
		for (int i = 0; i < n; i++) {
			dists[i][i] = Integer.MAX_VALUE;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
				}
			}
		}
	}
}
