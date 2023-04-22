package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SudoKoo {
	static final int N = 9;
	static int[][] grids;

	public static void main(String[] args) throws IOException {
		grids = new int[N][N];

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				grids[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		fill(0);
	}

	static void fill(int cnt) {
		if (cnt == N * N) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(grids[i][j]+" ");
				}
				System.out.println();
			}

			System.exit(0);
			return;
		}

		int r = cnt / N;
		int c = cnt % N;

		if (grids[r][c] != 0) {
			fill(cnt + 1);
		} else {
			for (int number = 1; number <= N; number++) {
				if (isPossible(r, c, number)) {
					grids[r][c] = number;
					fill(cnt + 1);
					grids[r][c] = 0;
				}
			}
		}
	}

	static boolean isPossible(int y, int x, int val) {
		for (int i = 0; i < N; i++) {
			if (grids[i][x] == val || grids[y][i] == val)//가로 세로 전체 탐색
				return false;
		}

		int sr = (y / 3) * 3;
		int sc = (x / 3) * 3;

		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (grids[i][j] == val)
					return false;
			}
		}

		return true;
	}
}
