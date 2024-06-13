package BaekJoon.SolvedAC3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NeedAFriend {
	static int n, m;
	static char[][] map;

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static Node start;

	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().toCharArray();

			for (int j = 0; j < m; j++) {
				boolean isDoYeon = map[i][j] == 'I';
				if (isDoYeon) {
					start = new Node(i, j);
				}
			}
		}

		Deque<Node> q = new ArrayDeque<>();
		boolean[][] v = new boolean[n][m];
		q.offer(start);
		v[start.y][start.x] = true;
		int friendCount = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfRange(ny, nx))
					continue;
				if (v[ny][nx])
					continue;
				if (map[ny][nx] == 'X')
					continue;

				if (map[ny][nx] == 'P')
					friendCount++;

				v[ny][nx] = true;
				q.offer(new Node(ny, nx));
			}
		}

		if (friendCount == 0) {
			System.out.println("TT");
			return;
		}
		System.out.println(friendCount);

	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
