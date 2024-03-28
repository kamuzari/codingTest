package saffy.ssafy.homework.daily03;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Escape {
	private static final String FAIL = "KAKTUS";
	static final Scanner sc = new Scanner(System.in);
	static int n, m;
	static char[][] map;

	static class Node {
		int y, x, cnt;

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

	static LinkedList<Node> starts;
	static LinkedList<Node> waters;

	static int answer = -1;

	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	static boolean[][] waterV;
	static boolean[][] startV;

	public static void main(String[] args) {
		String s[] = sc.nextLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		map = new char[n][m];
		starts = new LinkedList<>();
		waters = new LinkedList<>();
		waterV = new boolean[n][m];
		startV = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'S') {
					starts.add(new Node(i, j, 0));
					startV[i][j] = true;
				} else if (map[i][j] == '*') {
					waters.add(new Node(i, j));
					waterV[i][j] = true;
				}
			}
		}

		while (starts.size() > 0) {
			go();
			spreadWater();
			if (answer != -1) {
				break;
			}
		}

		if (answer != -1) {
			System.out.println(answer);
		} else {
			System.out.println(FAIL);
		}

	}

	static void go() {
		int repeatCount = starts.size();
		while (repeatCount-- > 0) {
			Node cur = starts.poll();
			if (map[cur.y][cur.x] == '*') {
				continue;
			}

			map[cur.y][cur.x] = '.';
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOut(ny, nx))
					continue;
				if (startV[ny][nx])
					continue;
				if (map[ny][nx] == 'X') {
					continue;
				}
				if (map[ny][nx] == '*') {
					continue;
				}

				if (map[ny][nx] == 'D') {
					answer = cur.cnt + 1;
					return;
				}

				if (map[ny][nx] == '.') {
					startV[ny][nx] = true;
					map[ny][nx] = 'S';
					starts.add(new Node(ny, nx, cur.cnt + 1));
				}

			}
		}
	}

	static void spreadWater() {
		int repeatCount = waters.size();
		while (repeatCount-- > 0) {
			Node cur = waters.poll();
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOut(ny, nx))
					continue;
				if (waterV[ny][nx])
					continue;
				if (map[ny][nx] == 'X' || map[ny][nx] == 'D') {
					continue;
				}
				waterV[ny][nx] = true;
				map[ny][nx] = '*';
				waters.add(new Node(ny, nx));
			}
		}
	}

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
