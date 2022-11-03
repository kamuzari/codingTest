package FAST_CAMPUS.GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sheep {
	private static final char SHEEP = 'o';
	private static final char WOLF = 'v';
	private static final char FENCE = '#';
	private static final char EMPTY = '.';

	static int sheepCnt = 0;
	static int wolfCnt = 0;
	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 이걸 어떻게 짜야되니? 완탐인데 코드 시물레이션이 안되는데.

		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		boolean v[][] = new boolean[n][m];
		char map[][] = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = reader.readLine().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == FENCE || map[i][j] == '.')
					continue;
				if (v[i][j])
					continue;
				bfs(i, j, map, v);
			}
		}

		System.out.println(sheepCnt + " " + wolfCnt);
	}

	static class Node {
		private int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static final int dy[] = {-1, 1, 0, 0};
	static final int dx[] = {0, 0, -1, 1};

	private static void bfs(int y, int x, char[][] map, boolean[][] v) {
		int sheep = map[y][x] == SHEEP ? 1 : 0;
		int wolf = map[y][x] == WOLF ? 1 : 0;

		LinkedList<Node> q = new LinkedList<>();

		q.offer(new Node(y, x));
		v[y][x] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (outOfIndex(ny, nx)) {
					continue;
				}

				if (map[ny][nx] == FENCE) {
					continue;
				}

				if (v[ny][nx]) {
					continue;
				}

				if (map[ny][nx] == SHEEP) {
					sheep++;
				} else if (map[ny][nx] == WOLF) {
					wolf++;
				}

				v[ny][nx] = true;
				q.offer(new Node(ny, nx));
			}
		}

		if (sheep > wolf) {
			sheepCnt += sheep;
		} else {
			wolfCnt += wolf;
		}
	}

	private static boolean outOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
