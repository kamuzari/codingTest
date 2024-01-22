package saffy.a형기출문제집;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreatingBridge2 {
	private static final int IMPOSSIBLE_CREATING_BRIDGE = -1;
	private static int m;
	private static int n;
	private static int map[][];
	private static int dy[] = {-1, 1, 0, 0};
	private static int dx[] = {0, 0, -1, 1};
	private static boolean[][] v;
	private static int parent[];
	private static PriorityQueue<Bridge> bridges = new PriorityQueue<>();
	private static LinkedList<Node> areas = new LinkedList<>();

	static class Bridge implements Comparable<Bridge> {
		private int v1;
		private int v2;
		private int distance;

		public Bridge(int v1, int v2, int distance) {
			this.v1 = v1;
			this.v2 = v2;
			this.distance = distance;
		}

		@Override
		public int compareTo(Bridge bridge) {
			return this.distance - bridge.distance;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}

		// 영역 나누기
		int areaIdentifier = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -1) {
					writeArea(areaIdentifier, i, j);
					areaIdentifier++;
				}
			}
		}

		createBridge();

		// union-find 초기화
		parent = new int[areaIdentifier];
		for (int i = 1; i < areaIdentifier; i++) {
			parent[i] = i;
		}

		int minimumTotalDistance = getMinimumTotalDistance();
		// 재정비
		for (int i = 1; i < areaIdentifier; i++) {
			find(i);
		}

		// 모든 점들이 연결되있는지 판단.
		minimumTotalDistance = determineAnswer(areaIdentifier, minimumTotalDistance);
		System.out.println(minimumTotalDistance);
	}

	private static int determineAnswer(int areaIdentifier, int minimumTotalDistance) {
		int criteria = parent[1];
		for (int i = 2; i < areaIdentifier; i++) {
			if (criteria == parent[i])
				continue;

			return IMPOSSIBLE_CREATING_BRIDGE;
		}

		return minimumTotalDistance;
	}

	private static int getMinimumTotalDistance() {
		// MST
		int minimumTotalDistance = 0;
		while (!bridges.isEmpty()) {
			Bridge bridge = bridges.poll();
			if (find(bridge.v1) != find(bridge.v2)) {
				union(bridge.v1, bridge.v2);
				minimumTotalDistance += bridge.distance;
			}
		}

		return minimumTotalDistance;
	}

	private static void createBridge() {
		while (!areas.isEmpty()) {
			Node cur = areas.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				int distance = 0;
				while (isInRange(ny, nx)) {
					boolean isNotEmptyBlock = map[ny][nx] != 0;
					if (isNotEmptyBlock) {
						boolean isDifferentArea = map[cur.y][cur.x] != map[ny][nx];
						if (isDifferentArea) {
							boolean isRequireBridgeLength = distance != 1;
							if (isRequireBridgeLength) {
								bridges.offer(new Bridge(map[cur.y][cur.x], map[ny][nx], distance));
							}
						}
						break;
					}
					ny += dy[i];
					nx += dx[i];
					distance++;
				}
			}
		}
	}

	private static void writeArea(int number, int y, int x) {
		Queue<Node> q = new LinkedList<>();
		v[y][x] = true;
		map[y][x] = number;
		areas.add(new Node(y, x));
		q.offer(new Node(y, x));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;
				if (isOutOfRange(ny, nx) || v[ny][nx] || map[ny][nx] > -1)
					continue;

				v[ny][nx] = true;
				map[ny][nx] = number;
				q.offer(new Node(ny, nx));
				areas.add(new Node(ny, nx));
			}

		}
	}

	private static boolean isInRange(int ny, int nx) {
		return ny >= 0 && ny < n && nx >= 0 && nx < m;
	}

	private static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}

	static class Node {
		private int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) {
			parent[b] = a;
		} else
			parent[a] = b;
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;

		return parent[a] = find(parent[a]);
	}
}
