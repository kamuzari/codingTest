package saffy.a형기출문제집;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MovingPipe {
	private static int n;
	private static int[][] map;
	private static int answwer;
	private static int CHECK = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		requestInput();

		map[1][1] = CHECK;
		map[1][2] = CHECK;
		dfs(1, 2);
		System.out.println(answwer);
	}

	private static void dfs(int y, int x) {
		if (y == n && x == n) {
			answwer++;
			return;
		}
		boolean isRowStatus = map[y][x - 1] == CHECK;
		if (isRowStatus) {
			if (canRight(y, x)) {
				map[y][x - 1] = EMPTY;
				map[y][x + 1] = CHECK;
				dfs(y, x + 1);
				map[y][x - 1] = CHECK;
				map[y][x + 1] = EMPTY;
			}

			if (canDiagonals(y, x)) {
				map[y][x - 1] = EMPTY;
				map[y + 1][x + 1] = CHECK;
				dfs(y + 1, x + 1);
				map[y][x - 1] = CHECK;
				map[y + 1][x + 1] = EMPTY;
			}
		}

		boolean isColStatus = map[y - 1][x] == CHECK;
		if (isColStatus) {

			if (canDown(y, x)) {
				map[y - 1][x] = EMPTY;
				map[y + 1][x] = CHECK;
				dfs(y + 1, x);
				map[y - 1][x] = CHECK;
				map[y + 1][x] = EMPTY;
			}

			if (canDiagonals(y, x)) {
				map[y - 1][x] = EMPTY;
				map[y + 1][x + 1] = CHECK;
				dfs(y + 1, x + 1);
				map[y - 1][x] = CHECK;
				map[y + 1][x + 1] = EMPTY;
			}
		}

		boolean isDiagonalStatus = map[y - 1][x - 1] == CHECK;
		if (isDiagonalStatus) {
			if (canRight(y, x)) {
				map[y - 1][x - 1] = EMPTY;
				map[y][x + 1] = CHECK;
				dfs(y, x + 1);
				map[y - 1][x - 1] = CHECK;
				map[y][x + 1] = EMPTY;
			}

			if (canDown(y, x)) {
				map[y - 1][x - 1] = EMPTY;
				map[y + 1][x] = CHECK;
				dfs(y + 1, x);
				map[y - 1][x - 1] = CHECK;
				map[y + 1][x] = EMPTY;
			}

			if (canDiagonals(y, x)) {
				map[y - 1][x - 1] = EMPTY;
				map[y + 1][x + 1] = CHECK;
				dfs(y + 1, x + 1);
				map[y - 1][x - 1] = CHECK;
				map[y + 1][x + 1] = EMPTY;
			}
		}

	}

	private static boolean canDiagonals(int y, int x) {
		return map[y + 1][x + 1] == EMPTY && map[y + 1][x] == EMPTY && map[y][x + 1] == EMPTY;
	}

	private static boolean canRight(int y, int x) {
		return map[y][x + 1] == EMPTY;
	}

	private static boolean canDown(int y, int x) {
		return map[y + 1][x] == EMPTY;
	}

	private static final int EMPTY = 2;

	private static void requestInput() {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		map = new int[n + 2][n + 2];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0) {
					map[i][j] = EMPTY;
				}
			}

		}
	}
}
