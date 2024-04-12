package BaekJoon.단기간성장;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LaserCommunication {
	static Scanner sc = new Scanner(System.in);

	static class Node implements Comparable<Node> {
		int y, x, dir, mirror;

		public Node(int y, int x, int dir, int mirror) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.mirror = mirror;
		}

		public int compareTo(Node o) {
			return mirror - o.mirror;
		}

	}

	// 북동남서
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};

	/**
	 * 그냥 방향이 바뀌면 거울이 있는 걸로 간주하면 된다!
	 *
	 * @param args
	 */
	static int n, m;
	static char[][] map;
	static int[][] installed;

	// todo: distance 배열도 있어야 함.. 저격 테케에서 무한루프 빠짐!!!
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		installed = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(installed[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Node> q = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			map[i] = st.nextToken().toCharArray();
		}
 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'C') {
					if (!q.isEmpty()) {
						continue;
					}
					map[i][j] = '.';
					for (int dir = 0; dir < 4; dir++) {
						int ny = dy[dir] + i;
						int nx = dx[dir] + j;
						if (isOut(ny, nx)) {
							continue;
						}
						if (map[ny][nx] == '*')
							continue;

						installed[ny][nx] = 0;
						q.offer(new Node(ny, nx, dir, 0));
					}

					installed[i][j] = 0;
				}
			}
		}

		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (map[cur.y][cur.x] == 'C') {
				answer = installed[cur.y][cur.x];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOut(ny, nx)) {
					continue;
				}
				if (map[ny][nx] == '*')
					continue;

				boolean isReverse = (cur.dir + 2) % 4 == i;
				if (isReverse) {
					continue;
				}

				boolean isTurn = (cur.dir + 1) % 4 == i || (cur.dir + 3) % 4 == i;
				if (isTurn) {
					if (installed[ny][nx] < cur.mirror + 1) {
						continue;
					}

					installed[ny][nx] = cur.mirror + 1;
					q.offer(new Node(ny, nx, i, cur.mirror + 1));
				} else {
					if (installed[ny][nx] <= cur.mirror) {
						continue;
					}

					installed[ny][nx] = cur.mirror;
					q.offer(new Node(ny, nx, i, cur.mirror));
				}
			}
		}

		System.out.println(answer);
	}

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
	/**
	 * review: edge case
	 *   - 0,2 지점에서 왼쪽방향으로 가는 노드가 0,0에서 아래로 향하는 가운데, 이미 0,2지점에서 아래 방향으로 향하다가 왼쪽으로
	 *   향하는 노드가 먼저 도착해 installed 배열에 1로 갱신하므로 같은 값을 가지는 전자노드가 진입을 못하고 최솟값을 갱신하지 못한다.
	 *
	 * 3 4
	 * ..C
	 * ...
	 * ...
	 * C*.
	 *
	 * 5 5
	 * C..**
	 * .*.**
	 * .*...
	 * .***C
	 * .....
	 */

}
