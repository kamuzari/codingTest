package BaekJoon.단기간성장;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백조의호수 {
	static final Scanner sc = new Scanner(System.in);
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};
	static int n, m;
	static char[][] map;

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		LinkedList<Node> swans = new LinkedList<>();
		LinkedList<Node> waters = new LinkedList<>();
		boolean[][] v = new boolean[n][m];
		Node src = null, dest = null;
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'X') {
					continue;
				}

				if (map[i][j] == 'L') {
					map[i][j] = '.';
					if (src == null) {
						src = new Node(i, j);
					} else {
						dest = new Node(i, j);
					}

				}

				waters.add(new Node(i, j));
			}
		}
		int seconds = 0;
		swans.add(src);
		v[src.y][src.x] = true;

		while (true) {
			LinkedList<Node> newSwans = new LinkedList<>();
			boolean isMeet = false;
			while (!swans.isEmpty()) {
				Node cur = swans.poll();
				if (cur.y == dest.y && cur.x == dest.x) {
					isMeet = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int ny = dy[i] + cur.y;
					int nx = dx[i] + cur.x;

					if (isOut(ny, nx))
						continue;
					if (v[ny][nx])
						continue;

					v[ny][nx] = true;
					if (map[ny][nx] == 'X') {
						newSwans.add(new Node(ny, nx));
						continue;
					}

					swans.offer(new Node(ny, nx));
				}
			}

			if (isMeet) {
				break;
			}
			swans = newSwans;
			int repeat = waters.size();
			for (int i = 0; i < repeat; i++) {
				Node water = waters.poll();
				for (int d = 0; d < 4; d++) {
					int ny = dy[d] + water.y;
					int nx = dx[d] + water.x;

					if (isOut(ny, nx))
						continue;

					if (map[ny][nx] == 'X') {
						waters.offer(new Node(ny, nx));
						map[ny][nx] = '.';
					}
				}
			}

			seconds++;
		}

		System.out.println(seconds);
	}

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
