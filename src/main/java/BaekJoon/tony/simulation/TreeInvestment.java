package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 2차원 배열 순회 100
 * k번 1000
 * 각 칸에 노드가 최대 있으려면 100,000
 * -> 10,000,000,000
 */
public class TreeInvestment {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int n, m, k;
	static int[][] land; // 땅에 양분
	static int a[][]; // S2D2가 땅에 줄 양분들
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};

	static class Tree implements Comparable<Tree> {
		int y, x, age;

		public Tree(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
		}

		public boolean isDead(int landVal) {
			return landVal < age;
		}

		public boolean isBreeding() {
			return this.age % 5 == 0;
		}

		public Tree getGrowTree() {
			return new Tree(this.y, this.x, this.age + 1);
		}

		public Tree copy() {
			return new Tree(this.y, this.x, this.age);
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(reader.readLine());

		// n개의 땅.
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		land = new int[n][n];
		// 처음 땅의 기본 양분 설정
		for (int i = 0; i < n; i++) {
			Arrays.fill(land[i], 5);
		}

		// 기계가 양분을 줄 양 설정
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<Tree> trees = new PriorityQueue<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());

			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());

			trees.offer(new Tree(y, x, age));
		}

		while (k-- > 0) {
			// 봄: 자신의 나이만큼 양분을 먹는다, 못먹으면 죽는다.

			LinkedList<Tree> deads = new LinkedList<>();
			PriorityQueue<Tree> lives = new PriorityQueue<>();
			LinkedList<Tree> breedings = new LinkedList<>();
			while (!trees.isEmpty()) {
				Tree cur = trees.poll();

				if (cur.isDead(land[cur.y][cur.x])) {
					deads.offer(cur.copy());
				} else {
					land[cur.y][cur.x] -= cur.age;
					Tree newTree = cur.getGrowTree();

					if (newTree.isBreeding()) {
						breedings.offer(newTree);
					}

					lives.offer(newTree);
				}
			}

			// 여름: 죽은 나무가 양분이 된다.
			while (!deads.isEmpty()) {
				Tree dead = deads.poll();

				land[dead.y][dead.x] += dead.age / 2;
			}

			// 가을: 번식
			while (!breedings.isEmpty()) {
				Tree cur = breedings.poll();

				for (int i = 0; i < 8; i++) {
					int ny = dy[i] + cur.y;
					int nx = dx[i] + cur.x;

					if (isOutOfIndex(ny, nx))
						continue;

					lives.add(new Tree(ny, nx, 1));
				}
			}

			trees = lives;

			// 겨울: 양분 충전
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					land[i][j] += a[i][j];
				}
			}
		}

		System.out.println(trees.size());
	}

	public static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}
