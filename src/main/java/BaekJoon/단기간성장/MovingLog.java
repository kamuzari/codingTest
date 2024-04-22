package BaekJoon.단기간성장;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MovingLog {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int result = solve();
		System.out.println(result);
	}

	/**
	 * todo: 연속적 세수의 합이 항상 고유 식별된 숫자로 변환할 수 있을까?
	 *   - 만약 그것이 가능하다면 연속된 세 칸의 번호 합으로 방문체크를 하면 된다!
	 */
	static final int HORIZON = 0;
	static final int VERTICAL = 1;
	static int dy[] = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int dx[] = {0, 0, -1, 1, -1, -1, 1, 1};
	static int n;
	static char[][] map;
	static boolean[][][] v;
	static List<Node> targets;

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}

	static int solve() {

		n = Integer.parseInt(sc.nextLine());
		map = new char[n][n];
		LinkedList<Node> q = new LinkedList<>();
		List<Node> sources = new ArrayList<>();
		targets = new ArrayList<>();
		v = new boolean[2][n][n];

		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < n; j++) {
				char val = map[i][j];
				if (val == 'B') {
					sources.add(new Node(i, j, 0, 0));
				}
			}
		}

		Node middle = sources.get(1);
		if (!isOut(middle.y, middle.x - 1) && !isOut(middle.y, middle.x + 1)) {
			boolean isHorizon = map[middle.y][middle.x - 1] == 'B' && map[middle.y][middle.x + 1] == 'B';
			if (isHorizon) {
				q.offer(new Node(middle.y, middle.x, HORIZON, 0));
			}
		}

		if (!isOut(middle.y - 1, middle.x) && !isOut(middle.y + 1, middle.x)) {
			boolean isVertical = map[middle.y - 1][middle.x] == 'B' && map[middle.y + 1][middle.x] == 'B';
			if (isVertical) {
				q.offer(new Node(middle.y, middle.x, VERTICAL, 0));
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char val = map[i][j];
				if (val == 'B') {
					map[i][j] = '0';
				}
			}
		}

		int answer = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.isArrive()) {
				return cur.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y2;
				int nx = dx[i] + cur.x2;
				if (isOut(ny, nx))
					continue;
				if (map[ny][nx] != '0' && map[ny][nx] != 'E')
					continue;

				ny = dy[i] + cur.y3;
				nx = dx[i] + cur.x3;
				if (isOut(ny, nx))
					continue;
				if (map[ny][nx] != '0' && map[ny][nx] != 'E')
					continue;

				ny = dy[i] + cur.y;
				nx = dx[i] + cur.x;
				if (isOut(ny, nx))
					continue;
				if (map[ny][nx] != '0' && map[ny][nx] != 'E')
					continue;

				if (v[cur.shape][ny][nx])
					continue;

				v[cur.shape][ny][nx] = true;
				q.offer(new Node(ny, nx, cur.shape, cur.cnt + 1));
			}

			// todo: 회전할때 8방향 모두 '0'이여야 하는 조건이 있었음..

			if (!isRotate(cur)) {
				continue;
			}
			// 회전
			if (cur.shape == HORIZON && cur.isToVertical()) {
				if (!v[VERTICAL][cur.y][cur.x]) {
					q.offer(new Node(cur.y, cur.x, VERTICAL, cur.cnt + 1));
					v[VERTICAL][cur.y][cur.x] = true;
				}
			} else if (cur.shape == VERTICAL && cur.isToHorizon()) {
				if (!v[HORIZON][cur.y][cur.x]) {
					q.offer(new Node(cur.y, cur.x, HORIZON, cur.cnt + 1));
					v[HORIZON][cur.y][cur.x] = true;
				}
			}
		}

		return answer;
	}

	private static boolean isRotate(Node cur) {
		for (int i = 0; i < 8; i++) {
			int ny = cur.y + dy[i];
			int nx = cur.x + dx[i];
			if (isOut(ny, nx)) {
				return false;
			}

			if (map[ny][nx] != '0' && map[ny][nx] != 'E') {
				return false;
			}
		}

		return true;
	}

	static class Node {
		int y, x, shape, cnt, y2, x2, y3, x3;

		public Node(int y, int x, int shape, int cnt) {
			this.y = y;
			this.x = x;
			this.shape = shape;
			this.cnt = cnt;

			if (shape == HORIZON) {
				y2 = y;
				x2 = x - 1;
				y3 = y;
				x3 = x + 1;
			} else {
				y2 = y - 1;
				x2 = x;
				y3 = y + 1;
				x3 = x;
			}
		}

		boolean isToHorizon() {
			boolean isIn = !isOut(y, x - 1) && !isOut(y, x + 1);
			if (!isIn) {
				return false;
			}

			boolean hasNext =
				(map[y][x - 1] == '0' || map[y][x - 1] == 'E') && (map[y][x + 1] == '0' || map[y][x + 1] == 'E');
			return isIn && hasNext;
		}

		boolean isToVertical() {
			boolean isIn = !isOut(y - 1, x) && !isOut(y + 1, x);
			if (!isIn) {
				return false;
			}

			boolean hasNext =
				(map[y - 1][x] == '0' || map[y - 1][x] == 'E') && (map[y + 1][x] == '0' || map[y + 1][x] == 'E');
			return isIn && hasNext;
		}

		@Override
		public String toString() {
			return "Node{" + "y=" + y + ", x=" + x + ", shape=" + shape + ", cnt=" + cnt + '}';
		}

		public boolean isArrive() {
			return map[y][x] == 'E' && map[y2][x2] == 'E' && map[y3][x3] == 'E';
		}
	}
}
