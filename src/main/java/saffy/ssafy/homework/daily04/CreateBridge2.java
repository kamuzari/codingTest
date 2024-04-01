package saffy.ssafy.homework.daily04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreateBridge2 {
	static Scanner sc = new Scanner(System.in);

	static int n, m;
	static int[][] map;

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divideArea();

		int areaCount = areaContainers.keySet().size();
		PriorityQueue<Edge> edges = new PriorityQueue<>();

		for (Integer id : areaContainers.keySet()) {
			List<Node> nodes = areaContainers.get(id);
			LinkedList<Node> q = new LinkedList<>();
			int[][] v = new int[n][m];
			for (int i = 0; i < n; i++) {
				Arrays.fill(v[i], INF);
			}
			nodes.forEach(node -> {
				for (int i = 0; i < 4; i++) {
					q.offer(new Node(node.y, node.x, i));
				}
				v[node.y][node.x] = 0;
			});

			int[] dist = new int[areaCount + 1];
			Arrays.fill(dist, INF);

			while (!q.isEmpty()) {
				Node cur = q.poll();
				if (areas[cur.y][cur.x] != 0 && areas[cur.y][cur.x] != id) {
					if (v[cur.y][cur.x] - 1 <= 1) {
						continue;
					}
					int otherId = areas[cur.y][cur.x];
					dist[otherId] = Math.min(dist[otherId], v[cur.y][cur.x] - 1);
					continue;
				}

				int ny = cur.y + dy[cur.dir];
				int nx = cur.x + dx[cur.dir];

				if (isOut(ny, nx) || v[ny][nx] < v[cur.y][cur.x] + 1)
					continue;
				if (areas[ny][nx] == id)
					continue;

				q.offer(new Node(ny, nx, cur.dir));
				v[ny][nx] = v[cur.y][cur.x] + 1;
			}

			for (int i = 0; i < areaCount + 1; i++) {
				if (dist[i] == INF)
					continue;
				if (dist[i] < 2)
					continue;
				edges.offer(new Edge(id, i, dist[i]));
			}
		}

		paresnts = new int[areaCount + 1];
		for (int i = 0; i < areaCount + 1; i++) {
			paresnts[i] = i;
		}

		int totalCost = 0;
		int connectCount = 0;
		while (!edges.isEmpty()) {
			Edge edge = edges.poll();
			if (find(edge.a) != find(edge.b)) {
				union(edge.a, edge.b);
				totalCost += edge.cost;
				connectCount++;
			}
		}

		if (connectCount == areaCount - 1) {
			System.out.println(totalCost);
		} else {
			System.out.println(-1);
		}

	}

	static int[] paresnts;

	static int find(int a) {
		if (paresnts[a] == a) {
			return a;
		}

		return paresnts[a] = find(paresnts[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) {
			return;
		}

		if (a > b) {
			paresnts[a] = b;
		} else {
			paresnts[b] = a;
		}
	}

	static final int INF = (int)1e9;

	static class Edge implements Comparable<Edge> {
		int a, b, cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}

	static class Node {
		int y, x, dir, cnt = 0;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Node(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

	static int[][] areas;
	static Map<Integer, List<Node>> areaContainers;

	static void divideArea() {
		areas = new int[n][m];
		areaContainers = new HashMap<>();
		boolean[][] v = new boolean[n][m];

		int idx = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					write(i, j, idx, v, areas);
					idx++;
				}
			}
		}

	}

	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	static void write(int y, int x, int number, boolean[][] v, int[][] areas) {
		areas[y][x] = number;
		v[y][x] = true;
		areaContainers.put(number, new ArrayList<>());
		areaContainers.get(number).add(new Node(y, x));

		LinkedList<Node> q = new LinkedList<>();
		q.offer(new Node(y, x));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int curY = cur.y;
			int curX = cur.x;
			for (int i = 0; i < 4; i++) {
				int ny = curY + dy[i];
				int nx = curX + dx[i];

				if (isOut(ny, nx) || v[ny][nx] || map[ny][nx] != 1) {
					continue;
				}

				q.offer(new Node(ny, nx));
				v[ny][nx] = true;
				areas[ny][nx] = number;
				areaContainers.get(number).add(new Node(ny, nx));
			}
		}
	}

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
