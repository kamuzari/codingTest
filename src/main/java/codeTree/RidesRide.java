package codeTree;

import java.util.*;

public class RidesRide {
	static final int dirs[][] = {
		{-1, 0},
		{1, 0},
		{0, -1},
		{0, 1},
	};

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static int n;
	static Set<Integer> likes[];
	static int[][] map;

	public static void main(String[] args) {
		n = Integer.parseInt(sc.nextLine());
		map = new int[n][n];
		likes = new Set[n * n + 1];
		for (int i = 1; i <= n * n; i++) {
			likes[i] = new HashSet<>();
		}
		LinkedList<Integer> orders = new LinkedList<>();
		for (int i = 0; i < n * n; i++) {
			String[] s = sc.nextLine().split(" ");
			int from = Integer.parseInt(s[0]);
			orders.add(from);
			for (int j = 1; j < s.length; j++) {
				likes[from].add(Integer.parseInt(s[j]));
			}
		}

		// 처음 위치 선정
		Node first = searchFirst();
		int firstStudent = orders.poll();
		map[first.y][first.x] = firstStudent;

		while (!orders.isEmpty()) {
			int curStu = orders.poll();
			// 넣을 곳 찾기
			Node node = searchPosition(curStu);
			map[node.y][node.x] = curStu;
		}

		int answer = calculate();
		System.out.println(answer);
	}

	static final int[] SCORE = {0, 1, 10, 100, 1000};

	static int calculate() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int likeCount = countLike(i, j);
				if (likeCount > 4) {
					likeCount = 4;
				}

				result += SCORE[likeCount];
			}
		}

		return result;
	}

	static int countLike(int y, int x) {
		int stuId = map[y][x];
		Set<Integer> prefers = likes[stuId];
		int likeCount = 0;
		for (int i = 0; i < 4; i++) {
			int ny = dirs[i][0] + y;
			int nx = dirs[i][1] + x;

			if (isOut(ny, nx))
				continue;
			if (map[ny][nx] == 0)
				continue;

			boolean isLike = prefers.contains(map[ny][nx]);

			if (isLike) {
				likeCount++;
			}
		}

		return likeCount;
	}

	static class Block implements Comparable<Block> {
		int y, x;
		int likeCount;
		int emptyCount;

		public Block(int i, int j, int lc, int ec) {
			y = i;
			x = j;
			likeCount = lc;
			emptyCount = ec;
		}

		public int compareTo(Block b) {
			if (likeCount == b.likeCount) {
				if (b.emptyCount == emptyCount) {
					if (y == b.y) {
						return x - b.x;
					}
					return y - b.y;
				}
				return b.emptyCount - emptyCount;
			}
			return b.likeCount - likeCount;
		}
	}

	static Node searchPosition(int stuId) {
		PriorityQueue<Block> pq = new PriorityQueue<>();
		Set<Integer> prefers = likes[stuId];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0)
					continue;
				Block block = createBlock(i, j, prefers);
				pq.offer(block);
			}
		}
		Block target = pq.poll();
		return new Node(target.y, target.x);
	}

	static Block createBlock(int y, int x, Set<Integer> prefers) {
		int likeCount = 0;
		int emptyCount = 0;

		for (int i = 0; i < 4; i++) {
			int ny = dirs[i][0] + y;
			int nx = dirs[i][1] + x;

			if (isOut(ny, nx))
				continue;
			if (map[ny][nx] == 0) {
				emptyCount++;
				continue;
			}

			boolean isLike = prefers.contains(map[ny][nx]);
			if (isLike) {
				likeCount++;
			}
		}

		return new Block(y, x, likeCount, emptyCount);

	}

	static Node searchFirst() {
		int maxEmptyCount = 0;
		int y = n;
		int x = n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int emptyCount = 0;
				for (int d = 0; d < 4; d++) {
					int ny = dirs[d][0] + i;
					int nx = dirs[d][1] + j;
					if (isOut(ny, nx))
						continue;
					if (map[ny][nx] == 0) {
						emptyCount++;
					}
				}

				if (emptyCount == 4) {
					return new Node(i, j);
				}
			}
		}

		throw new RuntimeException("fatal error");
	}

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}
}
