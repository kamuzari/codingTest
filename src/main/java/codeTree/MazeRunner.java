package codeTree;

import java.util.*;

public class MazeRunner {
	static final int HUMAN = 100;
	static final Scanner sc = new Scanner(System.in);
	static final int dirs[][] = {
		{-1, 0},
		{0, -1},
		{1, 0},
		{0, 1}
	};

	static final class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Node getCloserNodeFrom(Node exit) {
			Node answer = null;
			List<int[]> candidates = new ArrayList<>();
			for (int d = 0; d < 4; d++) {
				int ny = dirs[d][0] + y;
				int nx = dirs[d][1] + x;

				if (isOut(ny, nx))
					continue;
				int diffDist = Math.abs(exit.y - ny) + Math.abs(exit.x - nx);
				candidates.add(new int[] {ny, nx, diffDist});
			}

			if (candidates.isEmpty()) {
				return null;
			}
			// y,x,dist
			Collections.sort(candidates, (a, b) -> {
				if (a[2] == b[2]) {
					if (a[0] == b[0]) {
						return a[1] - a[0];
					}

					return a[0] - b[0];
				}

				return a[2] - b[2];
			});
			int[] result = candidates.get(0);
			answer = new Node(result[0], result[1]);
			return answer;
		}
	}

	static boolean isWall(int y, int x) {
		return map[y][x] >= 1 && map[y][x] <= 9;
	}

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}

	static int exitDirs[][] = {
		{-1, -1},
		{-1, 1},
		{1, -1},
		{1, 1}
	};

	static int n, m, k;
	static int[][] map; // 100: 사람, [1-9]: 벽
	static Map<Integer, Node> humans;
	static Node exit;

	public static void main(String[] args) {
		requestInput();
		int totalMovingCount = 0;
		while (k-- > 0) {
			List<Integer> removals = new ArrayList<>();
			for (int humanId : humans.keySet()) {
				Node humanPos = humans.get(humanId);
				Node closerNode = humanPos.getCloserNodeFrom(exit);

				if (closerNode == null || isWall(closerNode.y, closerNode.x)) {
					continue;
				}

				totalMovingCount++;
				map[humanPos.y][humanPos.x] = 0;
				if (closerNode.y == exit.y && closerNode.x == exit.x) {
					removals.add(humanId);
					continue;
				}

				map[closerNode.y][closerNode.x] = HUMAN;
				humans.put(humanId, closerNode);
			}
			removals.forEach(humanId -> humans.remove(humanId));
			if (humans.keySet().isEmpty()) {
				break;
			}
			int[] yxsize = findSquare();
			rotate(yxsize[0], yxsize[1], yxsize[2]);
		}

		// 이동거리합과 출구좌표 구하기
		System.out.println(totalMovingCount);
		System.out.println((exit.y + 1) + " " + (exit.x + 1));
	}

	static int[] findSquare() throws RuntimeException {
		for (int size = 1; size <= n; size++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (isOut(i + size, j + size))
						continue;
					if (isValid(i, j, size)) {
						return new int[] {i, j, size};
					}
				}
			}
		}

		throw new RuntimeException("fatal error");
	}

	static boolean isValid(int y, int x, int size) {
		boolean isContainHuman = false;
		boolean isContainExit = false;
		for (int i = y; i <= y + size; i++) {
			for (int j = x; j <= x + size; j++) {
				if (map[i][j] == HUMAN) {
					isContainHuman = true;
				} else if (map[i][j] == -1) {
					isContainExit = true;
				}
			}
		}

		return isContainExit && isContainHuman;
	}

	static void rotate(int sy, int sx, int size) {
		LinkedList<int[]> q = new LinkedList<>();

		for (int i = sy; i <= sy + size; i++) {
			for (int j = sx; j <= sx + size; j++) {
				q.offer(new int[] {i, j, map[i][j]});
			}
		}

		for (int j = sx + size; j >= sx; j--) {
			for (int i = sy; i <= sy + size; i++) {
				int[] yxValue = q.poll();
				map[i][j] = yxValue[2];
				if (map[i][j] == HUMAN) {
					for (int key : humans.keySet()) {
						Node node = humans.get(key);
						if (node.y == yxValue[0] && node.x == yxValue[1]) {
							humans.put(key, new Node(i, j));
						}
					}
				} else if (isWall(i, j)) {
					map[i][j]--;
				} else if (map[i][j] == -1) {
					exit = new Node(i, j);
				}
			}
		}

	}

	static void requestInput() {
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = toInt(st.nextToken());
		m = toInt(st.nextToken());
		k = toInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = toInt(st.nextToken());
			}
		}

		humans = new HashMap<>();
		int humanId = 1;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(sc.nextLine());
			Node positon = new Node(
				toInt(st.nextToken()) - 1,
				toInt(st.nextToken()) - 1
			);

			humans.put(humanId++, positon);
			map[positon.y][positon.x] = HUMAN;
		}

		st = new StringTokenizer(sc.nextLine());
		exit = new Node(
			toInt(st.nextToken()) - 1,
			toInt(st.nextToken()) - 1
		);
		map[exit.y][exit.x] = -1;
	}

	static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
