package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class WizardSharkAndRain {

	private static int n;
	private static int grid[][];
	private static boolean v[][];

	static int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		grid = new int[n][n];
		v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// init
		List<Node> nodes = List.of(
			new Node(n - 2, 0),
			new Node(n - 2, 1),
			new Node(n - 1, 0),
			new Node(n - 1, 1)
		);
		LinkedList<Node> clouds = new LinkedList<>(nodes);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int dist = Integer.parseInt(st.nextToken());
			// 1. 이동
			clouds = move(clouds, dir, dist);
			// 2.구름이 있는 곳 물의양 증가
			clouds.forEach(node -> grid[node.y][node.x]++);
			// 3. 물복사 버그
			bug(clouds);
			// 4. 구름이 있던 칸 제외 나머지 칸 중 물의 양이 2이상인 곳에 구름이 생기며 물의 양이 2만큼 줄어든다
			decrease(clouds);
		}

		int sum = Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();

		System.out.println(sum);
	}

	private static void decrease(LinkedList<Node> clouds) {
		clouds.clear();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (v[i][j]) {
					v[i][j] = false;
					continue; // 구름이 있는 칸

				}

				if (grid[i][j] >= 2) {
					grid[i][j] -= 2;
					clouds.add(new Node(i, j));
				}
			}
		}
	}

	static int bugDy[] = {-1, 1, 1, -1};
	static int bugDx[] = {-1, -1, 1, 1};

	private static void bug(LinkedList<Node> clouds) {
		for (Node cloud : clouds) {
			Node cur = cloud;
			int increment = 0;
			v[cur.y][cur.x] = true;
			for (int i = 0; i < 4; i++) {
				int ny = bugDy[i] + cur.y;
				int nx = bugDx[i] + cur.x;

				if (isOutOfRange(ny, nx)) {
					continue;
				}
				if (grid[ny][nx] == 0)
					continue;

				increment++;
			}

			grid[cur.y][cur.x] += increment;
		}
	}

	private static LinkedList<Node> move(LinkedList<Node> clouds, int dir, int dist) {
		LinkedList<Node> newClouds = new LinkedList<>();
		int size = clouds.size();

		for (int i = 0; i < size; i++) {
			Node cur = clouds.poll();

			int ny = dy[dir] * (dist % n) + cur.y;
			int nx = dx[dir] * (dist % n) + cur.x;

			ny = adjust(ny);
			nx = adjust(nx);
			newClouds.add(new Node(ny, nx));
		}

		return newClouds;
	}

	private static int adjust(int val) {
		if (val < 0 || val >= n) {
			return (val + n) % n;
		}

		return val;
	}

	public static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}
