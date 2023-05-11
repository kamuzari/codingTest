package BaekJoon.tony.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GlobalWarming {
	static int minR = Integer.MAX_VALUE,
		minC = Integer.MAX_VALUE,
		maxR = Integer.MIN_VALUE,
		maxC = Integer.MIN_VALUE; // 결과 출력을 위한 r,c최대 최소
	static Scanner sc = new Scanner(System.in);
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	public static void main(String[] args) {

		String str[] = sc.nextLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		char[][] map = new char[n][m];
		List<int[]> nodes = new ArrayList<>();
		boolean[][] seas = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'X') {
					nodes.add(new int[] {i, j});
				}
			}
		}

		for (int[] node : nodes) {
			int repeat = 4;
			int sea = 0;
			while (repeat-- > 0) {
				int ny = dy[repeat] + node[0];
				int nx = dx[repeat] + node[1];

				if (isOutOfRange(ny, nx, n, m)) {
					sea++;
					continue;
				}
				if (map[ny][nx] == '.')
					sea++;
			}

			if (sea >= 3) {
				seas[node[0]][node[1]] = true;
			} else {
				minR = Math.min(minR, node[0]);
				minC = Math.min(minC, node[1]);
				maxR = Math.max(maxR, node[0]);
				maxC = Math.max(maxC, node[1]);
			}

		}

		n = maxR - minR + 1;
		m = maxC - minC + 1;
		char[][] answer = new char[n][m];
		int idx = 0;
		for (int i = minR; i <= maxR; i++) {
			for (int j = minC; j <= maxC; j++) {
				int r = idx / m;
				int c = idx % m;

				if (seas[i][j]) {
					answer[r][c] = '.';
				} else {
					answer[r][c] = map[i][j];
				}
				idx++;
			}
		}

		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}

	}

	static boolean isOutOfRange(int ny, int nx, int n, int m) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
