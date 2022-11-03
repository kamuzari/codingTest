package FAST_CAMPUS.GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class WiseNight {
	static final int MAX = 250_001;
	static final int dy[] = {-2, -1, 1, 2, -2, -1, 1, 2};
	static final int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	private static int n;

	static class Night {
		private int y, x;

		public Night(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(reader.readLine());

		Night start = new Night(
			Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken())
		);

		int[][] dists = search(start);

		StringBuilder answers = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			answers.append(dists[y][x]).append(" ");
		}

		System.out.println(answers.toString());
	}

	/**
	 * note: 메모리 초과..
	 * @param start
	 * @return
	 */
	private static int[][] search(Night start) {
		int[][] dists = new int[n + 1][n + 1];

		LinkedList<Night> q = new LinkedList<>();

		q.offer(start);
		dists[start.y][start.x] = 0;

		while (!q.isEmpty()) {
			Night cur = q.poll();
			int pervDist = dists[cur.y][cur.x];

			for (int i = 0; i < 8; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfIndex(ny, nx)) {
					continue;
				}

				if (dists[ny][nx] != 0)
					continue;

				dists[ny][nx] = pervDist + 1;
				q.offer(new Night(ny, nx));
			}
		}

		return dists;
	}

	public static boolean isOutOfIndex(int ny, int nx) {
		return ny <= 0 || nx <= 0 || ny > n || nx > n;
	}
}
