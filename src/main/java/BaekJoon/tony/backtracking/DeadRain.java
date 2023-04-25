package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DeadRain {

	static int n, UMBRELLA, answer = Integer.MAX_VALUE;
	static char map[][];
	static int v[][];
	static int dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1};

	static class Node {
		int y, x, health, umbrella, cnt;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Node(int y, int x, int health, int umbrella, int cnt) {
			this.y = y;
			this.x = x;
			this.health = health;
			this.umbrella = umbrella;
			this.cnt = cnt;
		}

		public boolean hasUmbrella() {
			return this.umbrella > 0;
		}

		public boolean hasHealth() {
			return this.health > 0;
		}

		public void decreaseUmbrella() {
			this.umbrella -= 1;
		}

		public void decreaseHealth() {
			this.health -= 1;
		}

		public void replaceUmbrella() {
			this.umbrella = UMBRELLA;
		}

	}

	/**
	 * 멚헤튼 거리로 판명한다면 거리가 가까운 순으로 갈텐데 그때 더 멀어질 수 도 있어 도착못할 수도 있다.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		int health = Integer.parseInt(st.nextToken());
		UMBRELLA = Integer.parseInt(st.nextToken());

		Node start = null;
		map = new char[n][n];
		v = new int[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = reader.readLine().toCharArray();

			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'S') {
					start = new Node(i, j, health, 0, 0);
				}
			}
		}

		LinkedList<Node> q = new LinkedList();
		q.offer(start);
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (map[cur.y][cur.x] == 'E') {
				answer = cur.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfRange(ny, nx))
					continue;
				if (cur.umbrella <= 0 && cur.health <= 0)
					continue;
				if (v[ny][nx] >= cur.health + cur.umbrella)
					continue;

				Node next = new Node(ny, nx, cur.health, cur.umbrella, cur.cnt + 1);

				if (map[ny][nx] == 'U') {
					next.replaceUmbrella();
				}

				if (next.hasUmbrella()) {
					next.decreaseUmbrella();
				} else if (next.hasHealth()) {
					next.decreaseHealth();
				}

				v[ny][nx] = cur.health + cur.umbrella;
				q.offer(next);
			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}
