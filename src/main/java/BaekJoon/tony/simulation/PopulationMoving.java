package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PopulationMoving {

	private static int[][] map;
	private static int n;
	private static int right;
	private static int left;
	private static boolean isMove;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		left = Integer.parseInt(st.nextToken());
		right = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int move = -1;

		do {
			isMove = false;
			int id = 1;
			int sections[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (sections[i][j] == 0) {
						search(i, j, id++, sections);
					}
				}
			}
			move++;
		} while (isMove);

		System.out.println(move);
	}

	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	static class Node {
		private int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	private static void search(int y, int x, int id, int[][] sections) {
		LinkedList<Node> q = new LinkedList<>();

		Node start = new Node(y, x);
		q.offer(start);

		ArrayList<Node> paths = new ArrayList<>();
		paths.add(start);

		sections[y][x] = id;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int k = 0; k < 4; k++) {
				int ny = dy[k] + cur.y;
				int nx = dx[k] + cur.x;

				if (isOutOfRange(ny, nx))
					continue;
				if (sections[ny][nx] != 0)
					continue;

				int diff = Math.abs(map[ny][nx] - map[cur.y][cur.x]);

				if (isValidCondition(diff)) {
					Node next = new Node(ny, nx);
					q.offer(next);
					paths.add(next);
					sections[ny][nx] = id;
				}
			}
		}

		if (paths.size() == 1) { // 인구이동 없음.
			return;
		}

		isMove = true;

		// 인구이동 가능한 색션
		Integer total = paths.stream().map(a -> map[a.y][a.x]).reduce(Integer::sum).get();
		int localCnt = paths.size();

		// 인구이동 마무리
		int val = total / localCnt;
		paths.stream().forEach(node -> map[node.y][node.x] = val);

	}

	private static boolean isValidCondition(int diff) {
		return left <= diff && right >= diff;
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}
