package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class AttachSticker {
	static int autoIncrement = 1;
	private static int[][] grid;
	private static int n;
	private static int m;

	static class Shape {
		int idx = autoIncrement++;
		int n, m;
		int map[][];

		public Shape(int n, int m, int[][] map) {
			this.n = n;
			this.m = m;
			this.map = map;
		}

		/**
		 * 주의 : 90도가 순서대로 돌아가야한다! (다른 회전방향이 먼저 껴지면 정답과 멀어진다.)
		 * @return
		 */
		public int[][] rotate() {
			int cp[][] = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					cp[i][j]=map[n-1-j][i];
				}
			}

			int temp = n;
			this.n = this.m;
			this.m = temp;
			map = new int[n][m];

			return this.map = cp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Shape> shapes = new ArrayList<>();

		for (int sticker = 0; sticker < k; sticker++) {
			st = new StringTokenizer(reader.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int map[][] = new int[r][c];

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(reader.readLine());
				for (int j = 0; j < c; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			shapes.add(new Shape(r, c, map));
		}

		grid = new int[n][m];
		for (Shape shape : shapes) {
			int repeat = 4;
			while (repeat-- > 0) {

				if (isFit(shape)) {
					break;
				}
				shape.rotate();
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] != 0) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean isFit(Shape shape) {
		for (int i = 0; i <= n - shape.n; i++) {
			for (int j = 0; j <= m - shape.m; j++) {
				if (isAttach(shape, i, j)) {
					write(shape, i, j);
					return true;
				}
			}
		}

		return false;
	}

	private static boolean isAttach(Shape shape, int startY, int startX) {
		for (int i = startY; i < startY + shape.n; i++) {
			for (int j = startX; j < startX + shape.m; j++) {
				// 이미 칸을 차지하고 있다면
				if (shape.map[i - startY][j - startX] == 1 && grid[i][j] != 0) {
					return false;
				}
			}
		}

		return true;
	}

	private static void write(Shape shape, int startY, int startX) {

		for (int i = startY; i < startY + shape.n; i++) {
			for (int j = startX; j < startX + shape.m; j++) {
				if (shape.map[i - startY][j - startX] == 1) {
					grid[i][j] = shape.idx;
				}
			}
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		;
	}

	public static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
