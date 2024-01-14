package saffy.a형기출문제집;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CastleDefense {
	static int n;
	static int m;

	static int[][] map;
	static int distanceLimit;

	static final int LIMITED_ARCHER_COUNT = 3;
	static int[] archerPositions;
	static int answer;

	private static class Node {
		private int y;
		private int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getDistance(int y, int x) {
			return Math.abs(this.y - y) + Math.abs(this.x - x);
		}

		@Override
		public boolean equals(Object o) {
			Node other = (Node)o;
			return this.y == other.y && this.x == other.x;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.y, this.x);
		}

	}

	public static void main(String[] args) {
		requestInput();
		pickArcherPosition(0, 0);
		System.out.println(answer);
	}

	private static void requestInput() {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		archerPositions = new int[LIMITED_ARCHER_COUNT];
		distanceLimit = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void pickArcherPosition(int depth, int idx) {
		if (depth == LIMITED_ARCHER_COUNT) {
			int removingEnemies = startGame();
			answer = Math.max(answer, removingEnemies);
			return;
		}

		for (int i = idx; i < m; i++) {
			archerPositions[depth] = i;
			pickArcherPosition(depth + 1, i + 1);
		}
	}

	private static int startGame() {
		int removingEnemiesCount = 0;

		int[][] copyMap = copy();
		List<Node> archers = Arrays.stream(archerPositions)
				.mapToObj(column -> new Node(n, column))
				.collect(Collectors.toList());
		for (int turn = 0; turn < n; turn++) {
			Set<Node> enemies = new HashSet<>();
			for (Node archer : archers) {
				Node enemy = search(copyMap, archer);

				if (enemy == null)
					continue;

				enemies.add(enemy);
			}
			int removeCount=0;
			for (Node enemy : enemies) {
				copyMap[enemy.y][enemy.x]=0;
				removeCount++;
			}

			removingEnemiesCount += removeCount;

			moveEnemies(copyMap);
		}

		return removingEnemiesCount;
	}

	private static void moveEnemies(int[][] copyMap) {
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < m; j++) {
				copyMap[i][j] = copyMap[i - 1][j];
			}
		}

		Arrays.fill(copyMap[0], 0);
	}

	private static Node search(int[][] copyMap, Node archer) {
		int minimumDistance = Integer.MAX_VALUE;
		Node enemy = null;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == 1) {
					int distance = archer.getDistance(i, j);

					if (isOutOfRange(distance)) {
						continue;
					}

					if (distance < minimumDistance) {
						enemy = new Node(i, j);
						minimumDistance = distance;
					} else if (distance == minimumDistance) {
						boolean isGraterThanLeftPosition = enemy != null && enemy.x > j;
						if (isGraterThanLeftPosition) {
							enemy = new Node(i, j);
						}
					}
				}
			}
		}

		return enemy;
	}

	private static boolean isOutOfRange(int distance) {
		return distance > distanceLimit;
	}

	private static int[][] copy() {
		int[][] copyMap = new int[n][m];

		for (int i = 0; i < n; i++) {
			copyMap[i] = map[i].clone();
		}

		return copyMap;
	}

}
