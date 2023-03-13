package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class DustHello {
	static int map[][];
	static int n, m;
	private static List<Node> cleaner;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		cleaner = new ArrayList<>();
		// 격자 구성
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1) {
					cleaner.add(new Node(i, j));
				}
			}
		}

		while (t-- > 0) {
			// 1. 미세먼지 확산 map[r][c]/5 그리고 map[r][c] - (map[r][c]/5 * 방향 수)
			spread();
			//  2. 공기청정기 작동 (반시계 방향 and 시계방향
			clean();
		}

		// 3. t초가 지난후 미세먼지의 총양 구하기
		int answer = Arrays.stream(map).flatMapToInt(Arrays::stream).sum();
		System.out.println(answer+2);
	}

	private static void clean() {
		Node top = cleaner.get(0);

		for (int i = top.y - 1; i > 0; i--) {
			map[i][top.x] = map[i - 1][top.x];
		}

		for (int i = top.x; i < m - 1; i++) {
			map[0][i] = map[0][i + 1];
		}

		for (int i = 0; i < top.y; i++) {
			map[i][m - 1] = map[i + 1][m - 1];
		}

		for (int i = m - 1; i > top.x + 1; i--) {
			map[top.y][i] = map[top.y][i - 1];
		}

		map[top.y][top.x + 1] = 0;

		Node bottom = cleaner.get(1);

		for (int i = bottom.y + 1; i < n - 1; i++) {
			map[i][bottom.x] = map[i + 1][bottom.x];
		}

		for (int i = bottom.x; i < m - 1; i++) {
			map[n - 1][i] = map[n - 1][i + 1];
		}

		for (int i = n - 1; i > bottom.y; i--) {
			map[i][m - 1] = map[i - 1][m - 1];
		}

		for (int i = m - 1; i > bottom.x + 1; i--) {
			map[bottom.y][i] = map[bottom.y][i - 1];
		}

		map[bottom.y][bottom.x + 1] = 0;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	public static void spread() {
		// 미세먼지 찾기
		LinkedList<Node> dusts = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -1 || map[i][j] == 0) // 청소기 and 빈칸
					continue;

				dusts.offer(new Node(i, j));
			}
		}

		// 확산 - map[r][c]/5 그리고 map[r][c] - (map[r][c]/5 * 방향 수)
		int[][] cpMap = new int[n][m];

		for (int i = 0; i < n; i++) {
			cpMap[i] = map[i].clone(); // 원본 더스트 필요
		}
		while (!dusts.isEmpty()) {
			Node cur = dusts.poll();
			// map[ny][nx]대로 하면 이미 이전 노드들로 영향받은 것까지 더하게 되는 이슈가 있음.
			int amount = cpMap[cur.y][cur.x] / 5;

			if (amount == 0) // 확산할 양 0이면 방향 탐색 필요없음
				continue;

			int cnt = 0;

			// 주변 확산
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (isOutOfRange(ny, nx))
					continue;
				if (map[ny][nx] == -1) // 공기 청정기
					continue;

				cnt++;
				map[ny][nx] += amount;
			}

			map[cur.y][cur.x] -= amount * cnt;
		}

	}

	public static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
