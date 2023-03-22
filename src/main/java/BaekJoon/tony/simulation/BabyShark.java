package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BabyShark {
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	private static int n;
	static Shark baby;
	static int map[][];

	static class Node { // shark and fish
		int y;
		int x;
		int dist;

		public Node(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}

	static class Shark {
		int y, x, level, exp;
		Node food;

		public Shark(int y, int x) {
			this.y = y;
			this.x = x;
			this.level = 2;
			this.exp = 0;
		}

		public void setFish(Node fish) {
			if (food == null) {
				this.food = fish;
			} else {
				if (this.food.y > fish.y) {
					this.food = fish;
				} else if (this.food.y == fish.y && this.food.x > fish.x) {
					this.food = fish;
				}
			}
		}

		public boolean isLevelEqualAndGrater(int fishLevel) {
			return this.level <= fishLevel;
		}

		public boolean isExistFood() {
			return this.food != null;
		}

		public void eat() {
			Node eater = this.food;
			map[eater.y][eater.x] = 0; // 먹은 물고기 자리 제거
			this.food = null;
			setPosition(eater);
			addExp();
		}

		private void addExp() {
			this.exp++;

			if (exp == level) {
				this.exp = 0;
				this.level++;
			}
		}

		private void setPosition(Node eater) {
			this.y = eater.y;
			this.x = eater.x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j] = 0;
					baby = new Shark(i, j);
				}
			}
		}

		final int INF = (int)1e9;
		int minDistWithFish = 0;
		int seconds = 0;
		do {
			minDistWithFish = INF;
			boolean v[][] = new boolean[n][n];
			v[baby.y][baby.x] = true;
			LinkedList<Node> q = new LinkedList<>();
			q.offer(new Node(baby.y, baby.x, 0));

			while (!q.isEmpty()) {
				Node cur = q.poll();

				if (cur.dist > minDistWithFish)
					continue;

				if (map[cur.y][cur.x] != 0 && baby.isLevelEqualAndGrater(map[cur.y][cur.x])) { // 아기상어보다 레벨이 낮은 물고기이면
					if (minDistWithFish > cur.dist) {
						minDistWithFish = cur.dist;
						baby.setFish(cur);
					} else if (minDistWithFish == cur.dist) {
						baby.setFish(cur);
					}
					continue;
				}

				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (isOutOfIndex(ny, nx))
						continue;
					if (v[ny][nx] || map[ny][nx] > baby.level)
						continue;
					v[ny][nx] = true;
					q.offer(new Node(ny, nx, cur.dist + 1));
				}
			}

			if (baby.isExistFood()) {
				seconds += baby.food.dist;
				baby.eat();
			}
		} while (minDistWithFish != INF); // 다음으로 먹을 물고기의 거리측정에서 초기값이 나왔다면 먹을 것이 없는 것.

		System.out.println(seconds);
	}

	public static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny > n - 1 || nx > n - 1;
	}
}
