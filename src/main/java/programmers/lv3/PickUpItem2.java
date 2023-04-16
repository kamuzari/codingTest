package programmers.lv3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 예외 못잡음 tc5번..
 */
public class PickUpItem2 {
	public static void main(String[] args) {
		PickUpItem2 acquireItem = new PickUpItem2();
		// System.out.println(acquireItem.solution(
		// 	new int[][] {
		// 		{1, 1, 7, 4},
		// 		{3, 2, 5, 5},
		// 		{4, 3, 6, 9},
		// 		{2, 6, 8, 8},
		// 	},
		// 	1, 3, 7, 8
		// ));
		System.out.println(acquireItem.solution(
			new int[][] {
				{2, 2, 5, 5},
				{1, 3, 6, 4},
				{3, 1, 4, 6},
			},
			1, 4, 6, 3
		));
	}

	final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	int dy[] = {-1, 1, 0, 0};
	int dx[] = {0, 0, -1, 1};

	class Node {
		int y, x, cnt;

		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}

	class Rectangle {
		int y1, x1, y2, x2;

		public Rectangle(int y1, int x1, int y2, int x2) {
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
		}

		public boolean isInner(int ny, int nx) {
			return y1 < ny && y2 > ny && x1 < nx && x2 > nx;
		}
	}

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		Set<Integer>[][] path = new Set[51][51];
		boolean[][] v = new boolean[51][51];

		for(int i=0; i<51; i++){
			for(int j=0; j<51; j++){
				path[i][j]=new HashSet<>();
			}
		}

		List<Rectangle> rects = new ArrayList<>();

		for (int[] r : rectangle) {
			int y1 = r[1];
			int x1 = r[0];
			int y2 = r[3];
			int x2 = r[2];

			// 시계
			path[y1][x1].add(RIGHT);
			path[y1][x2].add(DOWN);
			path[y2][x2].add(RIGHT);
			path[y2][x1].add(UP);
			// 반시계
			path[y1][x1].add(DOWN);
			path[y1][x2].add(LEFT);
			path[y2][x2].add(UP);
			path[y2][x1].add(RIGHT);

			for (int i = x1 + 1; i < x2; i++) {
				path[y1][i].add(RIGHT);
				path[y1][i].add(LEFT);
			}

			for (int i = y1 + 1; i < y2; i++) {
				path[i][x2].add(DOWN);
				path[i][x2].add(UP);
			}

			for (int i = x2 - 1; i > x1; i--) {
				path[y2][i].add(LEFT);
				path[y2][i].add(RIGHT);
			}

			for (int i = y2 - 1; i > y1; i--) {
				path[i][x1].add(UP);
				path[i][x1].add(DOWN);
			}

			rects.add(new Rectangle(y1, x1, y2, x2));
		}

		LinkedList<Node> q = new LinkedList<>();
		q.offer(new Node(characterY, characterX, 0));
		v[characterY][characterX] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			System.out.println(cur.y + ", " + cur.x + " - " + cur.cnt);
			if (cur.y == itemY && cur.x == itemX) {
				return cur.cnt;
			}


			for (int dir : path[cur.y][cur.x]) {
				int ny = dy[dir] + cur.y;
				int nx = dx[dir] + cur.x;

				if (v[ny][nx])
					continue;

				if (isInnerRects(ny, nx, rects))
					continue;
				v[ny][nx] = true;
				q.offer(new Node(ny, nx, cur.cnt + 1));
			}

		}

		return -1;
	}

	boolean isInnerRects(int ny, int nx, List<Rectangle> rects) {
		for (Rectangle r : rects) {
			if (r.isInner(ny, nx)) {
				return true;
			}
		}

		return false;
	}
}
