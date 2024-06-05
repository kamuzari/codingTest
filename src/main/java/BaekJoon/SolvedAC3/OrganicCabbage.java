package BaekJoon.SolvedAC3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class OrganicCabbage {

	static boolean[][] isCabbage;
	static boolean[][] isVisited;
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder answer = new StringBuilder();
		int tc = Integer.parseInt(sc.nextLine());

		for (int testCase = 0; testCase < tc; testCase++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			isCabbage = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(sc.nextLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				isCabbage[y][x] = true;
			}

			isVisited = new boolean[n][m];
			int need = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (isVisited[i][j] || !isCabbage[i][j])
						continue;

					spread(i, j);
					need++;
				}
			}

			answer.append(need).append(System.lineSeparator());
		}

		System.out.println(answer);
	}

	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	private static void spread(int y, int x) {
		isVisited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (ny < 0 || nx < 0 || ny >= n || nx >= m)
				continue;
			if (!isCabbage[ny][nx])
				continue;
			if (isVisited[ny][nx])
				continue;

			spread(ny, nx);
		}
	}

}
