package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Peaks {

	private static int n;
	private static int dy[] = {-1, 1, 0, 0};
	private static int dx[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());

		int[][] grid = new int[n + 2][n + 2];

		for (int i = 1; i <= n; i++) {
			String[] rows = reader.readLine().split(" ");

			for (int j = 1; j <= n; j++) {
				grid[i][j] = Integer.parseInt(rows[j - 1]);
			}
		}

		boolean[][] peaks = new boolean[n + 2][n + 2];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int myValue = grid[i][j];
				int lowerThanCount = 0;

				for (int dir = 0; dir < 4; dir++) {
					int ny = i + dy[dir];
					int nx = j + dx[dir];

					if (myValue > grid[ny][nx]) {
						lowerThanCount++;
					}

				}

				if (lowerThanCount == 4) {
					peaks[i][j] = true;
				}
			}
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (peaks[i][j]) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}

