package saffy.ssafy.homework.daily01;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지오잉 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringBuilder ansewr = new StringBuilder();
		int testCase = 1;
		while (true) {
			n = Integer.parseInt(sc.nextLine());
			if (n == 0) {
				break;
			}
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = solution();
			ansewr.append("Problem " + testCase + ": " + result).append(System.lineSeparator());
			testCase++;
		}
		System.out.println(ansewr);
	}

	static int n;
	static int map[][];

	static class Node implements Comparable<Node> {
		int y, x, cnt;

		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		public int compareTo(Node o) {
			return cnt - o.cnt;
		}
	}

	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	static int solution() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] v = new boolean[n][n];
		pq.offer(new Node(0, 0, map[0][0]));
		v[0][0] = true;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.y == n - 1 && cur.x == n - 1) {
				return cur.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;
				if (isOut(ny, nx) || v[ny][nx])
					continue;

				v[ny][nx] = true;
				pq.offer(new Node(ny, nx, cur.cnt + map[ny][nx]));
			}
		}

		throw new RuntimeException("fatal error");
	}

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}

