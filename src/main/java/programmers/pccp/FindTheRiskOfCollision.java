package programmers.pccp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheRiskOfCollision {
	class Node {
		private int y;
		private int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	Map<Integer, Node> positions = new HashMap<>();
	Map<Integer, Set<Integer>> seconds = new HashMap<>();
	boolean[] isBreakPositions = new boolean[100_001];

	public int solution(int[][] points, int[][] routes) {
		initialize(points, routes);
		
		for (int i = 0; i < routes.length; i++) {
			int startId = routes[i][0];
			for (int j = 1; j < routes[i].length; j++) {
				int nextId = routes[i][j];
				write(startId, nextId);
				startId = routes[i][j];
			}
		}

		return countCollision();
	}

	private int countCollision() {
		int count = 0;
		for (int i = 1; i <= 100_000; i++) {
			if (isBreakPositions[i]) {
				count++;
			}
		}

		return count;
	}

	private void write(int startId, int nextId) {
		Node start = positions.get(startId);
		Node next = positions.get(nextId);
		int sy = start.y;
		int sx = start.x;
		int second = 1;

		while (sy != next.y) {
			int weight = sy < next.y ? 1 : -1;
			sy += weight;

			boolean isAdd = seconds.get(second).add(toKey(sy, sx));

			if (!isAdd) {
				isBreakPositions[toKey(sy, sx)] = true;
			}

			second++;
		}

		while (sx != next.x) {
			int weight = sx < next.x ? 1 : -1;
			sx += weight;

			boolean isAdd = seconds.get(second).add(toKey(sy, sx));

			if (!isAdd) {
				isBreakPositions[toKey(sy, sx)] = true;
			}
			second++;
		}
	}

	private int toKey(int y, int x) {
		return y * 100 + x;
	}

	private void initialize(int[][] points, int[][] routes) {
		for (int i = 0; i < points.length; i++) {
			int y = points[i][0];
			int x = points[i][1];

			positions.put(i, new Node(y, x));
		}

		for (int i = 1; i <= 100_000; i++) {
			seconds.put(i, new HashSet<>());
		}
	}
}
