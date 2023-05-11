package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Detecting {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n, m, arr));
	}

	static class Node {
		int idx, y, x, dir;

		public Node(int idx, int y, int x) {
			this.idx = idx;
			this.y = y;
			this.x = x;
			this.dir = -1;
		}

		public Node(int idx, int y, int x, int dir) {
			this.idx = idx;
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		public String toString() {
			return String.format("idx: %d, y:%d , x:%d, dir -- %d", idx, y, x, dir);
		}

	}

	static int N, M;
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static int answer = Integer.MAX_VALUE;
	static List<Node> cctvs;

	static int solution(int n, int m, int[][] map) {
		N = n;
		M = m;
		cctvs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					cctvs.add(new Node(map[i][j], i, j));
				}
			}
		}

		dfs(0, map);

		return answer;
	}

	static void dfs(int cnt, int[][] map) {
		if (cnt == cctvs.size()) {
			// 사각지대 크기 구하기
			int zero = getSize(map);
			answer = Math.min(zero, answer);
			return;
		}

		int[][] temp;
		Node cctv = cctvs.get(cnt);

		switch (cctv.idx) {
			case 1:
				for (int i = 0; i < 4; i++) {
					Node cur = new Node(cctv.idx, cctv.y, cctv.x, i);
					temp = copyMap(map);
					write(List.of(cur), temp);
					dfs(cnt + 1, temp);
				}
				break;
			case 2:
				for (int i = 0; i <= 1; i++) {
					Node cur1 = new Node(cctv.idx, cctv.y, cctv.x, i * 2);
					Node cur2 = new Node(cctv.idx, cctv.y, cctv.x, i * 2 + 1);
					List<Node> nexts = List.of(cur1, cur2);
					temp = copyMap(map);
					write(nexts, temp);
					dfs(cnt + 1, temp);
				}
				break;
			case 3:
				Node cur1 = new Node(cctv.idx, cctv.y, cctv.x, 0);
				Node cur2 = new Node(cctv.idx, cctv.y, cctv.x, 3);
				List<Node> nexts = List.of(cur1, cur2);

				temp = copyMap(map);
				write(nexts, temp);
				dfs(cnt + 1, temp);

				cur1 = new Node(cctv.idx, cctv.y, cctv.x, 3);
				cur2 = new Node(cctv.idx, cctv.y, cctv.x, 1);
				nexts = List.of(cur1, cur2);

				temp = copyMap(map);
				write(nexts, temp);
				dfs(cnt + 1, temp);

				cur1 = new Node(cctv.idx, cctv.y, cctv.x, 1);
				cur2 = new Node(cctv.idx, cctv.y, cctv.x, 2);
				nexts = List.of(cur1, cur2);

				temp = copyMap(map);
				write(nexts, temp);
				dfs(cnt + 1, temp);

				cur1 = new Node(cctv.idx, cctv.y, cctv.x, 2);
				cur2 = new Node(cctv.idx, cctv.y, cctv.x, 0);
				nexts = List.of(cur1, cur2);

				temp = copyMap(map);
				write(nexts, temp);
				dfs(cnt + 1, temp);
				break;
			case 4:
				cur1 = new Node(cctv.idx, cctv.y, cctv.x, 2);
				cur2 = new Node(cctv.idx, cctv.y, cctv.x, 0);
				Node cur3 = new Node(cctv.idx, cctv.y, cctv.x, 3);
				nexts = List.of(cur1, cur2, cur3);

				temp = copyMap(map);
				write(nexts, temp);
				dfs(cnt + 1, temp);

				cur1 = new Node(cctv.idx, cctv.y, cctv.x, 0);
				cur2 = new Node(cctv.idx, cctv.y, cctv.x, 3);
				cur3 = new Node(cctv.idx, cctv.y, cctv.x, 1);
				nexts = List.of(cur1, cur2, cur3);

				temp = copyMap(map);
				write(nexts, temp);
				dfs(cnt + 1, temp);

				cur1 = new Node(cctv.idx, cctv.y, cctv.x, 3);
				cur2 = new Node(cctv.idx, cctv.y, cctv.x, 1);
				cur3 = new Node(cctv.idx, cctv.y, cctv.x, 2);
				nexts = List.of(cur1, cur2, cur3);

				temp = copyMap(map);
				write(nexts, temp);
				dfs(cnt + 1, temp);

				cur1 = new Node(cctv.idx, cctv.y, cctv.x, 1);
				cur2 = new Node(cctv.idx, cctv.y, cctv.x, 2);
				cur3 = new Node(cctv.idx, cctv.y, cctv.x, 0);
				nexts = List.of(cur1, cur2, cur3);

				temp = copyMap(map);
				write(nexts, temp);
				dfs(cnt + 1, temp);
				break;
			case 5:
				cur1 = new Node(cctv.idx, cctv.y, cctv.x, 0);
				cur2 = new Node(cctv.idx, cctv.y, cctv.x, 1);
				cur3 = new Node(cctv.idx, cctv.y, cctv.x, 2);
				Node cur4 = new Node(cctv.idx, cctv.y, cctv.x, 3);
				nexts = List.of(cur1, cur2, cur3, cur4);

				temp = copyMap(map);
				write(nexts, temp);
				dfs(cnt + 1, temp);
				break;
		}
	}

	static int[][] copyMap(int[][] original) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp[i] = original[i].clone();
		}

		return temp;
	}

	static void write(List<Node> cctvs, int[][] copyMap) {
		LinkedList<Node> q = new LinkedList<>();

		for (Node cctv : cctvs) {
			q.offer(cctv);
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();

			int ny = cur.y + dy[cur.dir];
			int nx = cur.x + dx[cur.dir];
			if (isOutOfRange(ny, nx))
				continue;
			if (copyMap[ny][nx] == 6)
				continue;

			copyMap[ny][nx] = 7;
			q.offer(new Node(cur.idx, ny, nx, cur.dir));
		}
	}

	static int getSize(int[][] copyMap) {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= N || nx >= M;
	}
}
