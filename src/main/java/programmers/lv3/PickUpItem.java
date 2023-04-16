package programmers.lv3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PickUpItem {
	public static void main(String[] args) {
		PickUpItem acquireItem = new PickUpItem();
		int solution = acquireItem.solution(
			new int[][] {
				{1, 1, 7, 4},
				{3, 2, 5, 5},
				{4, 3, 6, 9},
				{2, 6, 8, 8},
			},
			1, 3, 7, 8
		);
		System.out.println(solution);
	}

	class Rectangle {
		int x1, x2, y1, y2;

		public Rectangle(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		// 안쪽 범위라면 탐색 x
		public boolean isInner(int ny, int nx) {
			return x1 < nx && x2 > nx && y1 < ny && y2 > ny;
		}
	}

	int dy[] = {-1, 1, 0, 0};
	int dx[] = {0, 0, -1, 1};

	// 2차원 배열 확장하기(2배)
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;
		List<Rectangle> rects = new ArrayList<>();
		int map[][] = new int[102][102];
		boolean v[][] = new boolean[102][102];
		for (int[] r : rectangle) {
			int x1 = r[0] * 2;
			int y1 = r[1] * 2;
			int x2 = r[2] * 2;
			int y2 = r[3] * 2;

			for (int i = y1; i <= y2; i++) {
				for (int j = x1; j <= x2; j++) {
					map[i][j] = -1;
				}
			}
			rects.add(new Rectangle(x1,y1,x2,y2));
		}

		LinkedList<int[]> q = new LinkedList<>();
		characterX*=2;
		characterY*=2;
		q.offer(new int[] {characterY, characterX, 0});
		v[characterY][characterX] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == itemY * 2 && cur[1] == itemX*2) {
				return cur[2] /2;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur[0];
				int nx = dx[i] + cur[1];

				if (isOutOfRange(ny, nx) || v[ny][nx] || map[ny][nx] != -1) {
					continue;
				}

				if (isInnerRects(ny, nx, rects)) {
					continue;
				}

				v[ny][nx] = true;
				q.offer(new int[] {ny, nx, cur[2] + 1});
			}
		}

		return -1;
	}

	boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= 102 || nx >= 102;
	}

	boolean isInnerRects(int ny, int nx, List<Rectangle> rects) {
		for (Rectangle rect : rects) {
			if (rect.isInner(ny, nx)) {
				return true;
			}
		}

		return false;
	}
}
