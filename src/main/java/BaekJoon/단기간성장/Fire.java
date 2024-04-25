package BaekJoon.단기간성장;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Fire {
	static class Node {
		int y, x, cnt = 0;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	static int r, c;
	static char[][] map;
	static final int dy[] = {-1, 1, 0, 0};
	static final int dx[] = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		Queue<Node> fires = new LinkedList<>();
		Node start = null;
		for (int i = 0; i < r; i++) {
			map[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < c; j++) {
				char val = map[i][j];
				if (val == 'J') {
					map[i][j] = '.';
					start = new Node(i, j);
				}
				if (val == 'F') {
					fires.add(new Node(i, j));
				}
			}
		}

		boolean[][] v = new boolean[r][c];
		Queue<Node> q = new LinkedList<>();
		q.offer(start);
		v[start.y][start.x] = true;
		int count = 0;
		while (true) {
			if (q.isEmpty()) {
				break;
			}
			while (!q.isEmpty() && q.peek().cnt == count) {
				Node cur = q.poll();
				if (map[cur.y][cur.x] == 'F')
					continue;

				// todo: move JoHoon
				for (int i = 0; i < 4; i++) {
					int ny = dy[i] + cur.y;
					int nx = dx[i] + cur.x;
					if (isOut(ny, nx)) {
						System.out.println(cur.cnt + 1);
						return;
					}

					if (v[ny][nx])
						continue;
					if (map[ny][nx] == '#' || map[ny][nx] == 'F')
						continue;
					v[ny][nx] = true;
					q.offer(new Node(ny, nx, cur.cnt + 1));
				}
			}

			// todo: spread fire
			int limit = fires.size();
			for (int i = 0; i < limit; i++) {
				Node fire = fires.poll();
				for (int j = 0; j < 4; j++) {
					int ny = dy[j] + fire.y;
					int nx = dx[j] + fire.x;
					if (isOut(ny, nx))
						continue;
					if (map[ny][nx] == '#' || map[ny][nx] == 'F')
						continue;

					map[ny][nx] = 'F';
					fires.add(new Node(ny, nx));
				}
			}

			count++;
		}

		System.out.println("IMPOSSIBLE");
	}

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= r || nx >= c;
	}
}
