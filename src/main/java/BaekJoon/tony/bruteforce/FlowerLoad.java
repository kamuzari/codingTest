package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class FlowerLoad {
	static final int INF = (int)1e9;
	static int answer = INF, n;
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	private static int[][] map;

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Node node = (Node)o;

			return y == node.y && x == node.x;
		}

		@Override
		public int hashCode() {
			return Objects.hash(y, x);
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
			}
		}
		pick(0, 0, new Stack<>());

		System.out.println(answer);
	}

	static void pick(int cnt, int idx, Stack<Integer> position) {
		if (cnt == 3) {
			// 죽는 꽃있는지 확인

			Set<Node> lands = new LinkedHashSet<>();
			for (Integer number : position) {
				int y = number / n;
				int x = number % n;

				if (!isValidScope(y, x)) {
					return;
				}

				if (!isOverlap(y, x, lands)) {
					return;
				}

			}

			// 비용 계산
			int cost = 0;
			for (Node land : lands) {
				cost += map[land.y][land.x];
			}

			answer = Math.min(cost, answer);
			return;
		}

		for (int i = idx; i < n * n; i++) {
			position.push(i);
			pick(cnt + 1, i + 1, position);
			position.pop();
		}

	}

	static boolean isValidScope(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (isOutOfRange(ny, nx))
				return false;
		}

		return true;
	}

	static boolean isOverlap(int y, int x, Set<Node> lands) {
		Node cur = new Node(y, x);
		if (lands.contains(cur)) {
			return false;
		}

		lands.add(cur);

		for (int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;
			Node next = new Node(ny, nx);

			if (lands.contains(next)) {
				return false;
			}

			lands.add(next);
		}

		return true;
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}

}
