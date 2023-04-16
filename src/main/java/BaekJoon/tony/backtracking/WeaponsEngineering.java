package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WeaponsEngineering {

	private static int n, m, answer;
	private static int[][] tree;
	static int dy[][] = {{0, 1}, {-1, 0}, {-1, 0}, {1, 0}};
	static int dx[][] = {{-1, 0}, {0, -1}, {0, 1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution());
	}

	static boolean v[][];

	// 부매랑들의 강도 합의 최댓값을 출력하시오
	public static int solution() {
		v = new boolean[n][m];
		pick(0, 0);
		return answer;
	}

	public static void pick(int cnt, int sum) {
		if (n * m <= cnt) {
			answer = Math.max(sum, answer);
			return;
		}
		// core
		int y = cnt / m;
		int x = cnt % m;

		if (v[y][x]) {
			pick(cnt + 1, sum);
		} else {
			v[y][x] = true;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i][0];
				int nx = x + dx[i][0];

				if (isOutOfRange(ny, nx) || v[ny][nx])
					continue;

				int nny = y + dy[i][1];
				int nnx = x + dx[i][1];

				if (isOutOfRange(nny, nnx) || v[nny][nnx])
					continue;

				v[ny][nx] = true;
				v[nny][nnx] = true;

				pick(cnt + 1, sum + (tree[y][x] * 2) + tree[ny][nx] + tree[nny][nnx]);
				v[ny][nx] = false;
				v[nny][nnx] = false;
			}

			v[y][x] = false;
			pick(cnt + 1, sum);
		}

	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
