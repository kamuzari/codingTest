package programmers.lv2;

import java.util.LinkedList;

public class MiroEscaping {
	public static void main(String[] args) {
		MiroEscaping miroEscaping = new MiroEscaping();
		int solution = miroEscaping.solution(new String[] {"SLX", "X0X", "XOE"});
		System.out.println(solution);
	}

	/**
	 - 미로를 빠져나가기 위해서는 레버가 필요하다.
	 -
	 */
	class Node {
		int y, x, dist;
		int lever;

		public Node(int y, int x, int dist, int lever) {
			y = y;
			x = x;
			dist = dist;
			lever = lever;
		}
	}

	final int FAIL = -1;
	int n, m;
	char[][] map;
	int dy[] = {-1, 1, 0, 0};
	int dx[] = {0, 0, -1, 1};

	public int solution(String[] maps) {
		int answer = (int)1e9;
		n = maps.length;
		m = maps[0].length();
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = maps[i].toCharArray();
		}

		Node start = null;
		Node end = null;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'S') {
					start = new Node(i, j, 0, 0);
				}

				if (map[i][j] == 'E') {
					end = new Node(i, j, 0, 0);
				}
			}
		}

		LinkedList<Node> q = new LinkedList<>();

		q.offer(start);
		boolean[][][] v = new boolean[2][n][m];
		v[start.lever][start.y][start.x] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.lever == 1 && (cur.y == end.y && cur.x == end.x)) {
				return cur.dist;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfRange(ny, nx))
					continue;
				if (v[cur.lever][ny][nx])
					continue;
				if (map[ny][nx] == 'X')
					continue;

				if (map[ny][nx] == 'L') {
					q.offer(new Node(ny, nx, cur.dist + 1, 1));
					v[1][ny][nx] = true;
				} else {
					q.offer(new Node(ny, nx, cur.dist + 1, cur.lever));
					v[cur.lever][ny][nx] = true;
				}

			}

		}

		return FAIL;
	}

	boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
