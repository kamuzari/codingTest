package codeTree.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BattleOfTheKnights {
	static int N, M, Q;
	static int[][] original_map = new int[55][55];
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static Knight[] knights = new Knight[40];

	static class Knight {
		int idx, r, c, h, w, k, damage;

		Knight(int idx, int r, int c, int h, int w, int k) {
			this.idx = idx;
			this.r = r;
			this.c = c;
			this.h = h;
			this.w = w;
			this.k = k;
			this.damage = 0;
		}

		void fill(int[][] map) {
			if (k <= 0)
				return;
			for (int i = r; i < r + h; i++) {
				for (int j = c; j < c + w; j++) {
					map[i][j] = idx;
				}
			}
		}

		void move(int d) {
			r += dirs[d][0];
			c += dirs[d][1];
		}

		void hurt() {
			for (int i = r; i < r + h; i++) {
				for (int j = c; j < c + w; j++) {
					if (original_map[i][j] == 1) {
						k--;
						damage++;
					}
				}
			}
		}
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				original_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			knights[i] = new Knight(i, r, c, h, w, k);
		}

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (knights[k].k <= 0) {
				continue;
			}

			move(k, d);
		}
	}

	public static void move(int k, int d) {
		int[][] knights_map = new int[55][55];
		for (int i = 1; i <= M; i++) {
			knights[i].fill(knights_map);
		}

		boolean[] moving = new boolean[55];
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(k);
		moving[k] = true;

	}

	public static void pro() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (Q-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (knights[k].k <= 0) {
				continue;
			}

			move(k, d);
		}

		int ans = 0;
		for (int i = 1; i <= M; i++) {
			if (knights[i].k >= 1) {
				ans += knights[i].damage;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		input();

		int ans = 0;
		for (int i = 1; i <= M; i++) {
			if (knights[i].k >= 1) {
				ans += knights[i].damage;
			}
		}
		System.out.println(ans);
	}
}
