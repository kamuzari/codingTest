package BaekJoon.SolvedAC3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tomato {
	static int[] dh = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, 0, -1, 1};
	static int h, n, m;
	static int[][][] box;

	static class Node {
		int h, y, x;

		public Node(int h, int y, int x) {
			this.h = h;
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		box = new int[h][n][m];
		Deque<Node> q = new ArrayDeque<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(sc.nextLine());
				for (int k = 0; k < m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						q.offer(new Node(i, j, k));
					}
				}
			}
		}
		boolean isAlreadyComplete = isFullTomato();
		if (isAlreadyComplete) {
			System.out.println(0);
			return;
		}

		int day = 1;
		while (!q.isEmpty()) {
			spread(q);
			if (isFullTomato()) {
				break;
			}
			day++;
		}

		if (isFullTomato()) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}

	}

	private static void spread(Deque<Node> q) {
		int limit = q.size();
		for (int i = 0; i < limit; i++) {
			Node cur = q.poll();

			for (int dir = 0; dir < 6; dir++) {
				int nh = dh[dir] + cur.h;
				int ny = dy[dir] + cur.y;
				int nx = dx[dir] + cur.x;

				boolean isOutOfRange = nh < 0 || ny < 0 || nx < 0 || nh >= h || ny >= n || nx >= m;
				if (isOutOfRange)
					continue;
				if (box[nh][ny][nx] == -1 || box[nh][ny][nx] == 1)
					continue;

				box[nh][ny][nx] = 1;
				q.offer(new Node(nh, ny, nx));
			}
		}
	}

	static boolean isFullTomato() {

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (box[i][j][k] == 0) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
