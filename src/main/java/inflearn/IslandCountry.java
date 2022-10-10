package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IslandCountry {
	private static final int ISLAND = 1;
	private static final boolean NOT_YET = false;
	private static final int dx[] = {0, 0, -1, 1, -1, 1, 1, -1};
	private static final int dy[] = {-1, 1, 0, 0, -1, -1, 1, 1};
	private static int n;
	private static int[][] land;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());

		land = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		boolean[][] v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (land[i][j] == ISLAND && v[i][j] == NOT_YET) {
					search(i, j, v);
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	public static void search(int y, int x, boolean[][] v) {
		for (int i = 0; i < 8; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (isOutOfIndex(ny, nx))
				continue;

			if (v[ny][nx])
				continue;

			if (land[ny][nx] == ISLAND) {
				v[ny][nx] = true;
				search(ny, nx, v);
			}
		}
	}

	public static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}
