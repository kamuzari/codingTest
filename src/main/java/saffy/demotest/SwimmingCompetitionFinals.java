package saffy.demotest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SwimmingCompetitionFinals {
	/**
	 * 문제를 제대로 봐야함 소용돌이가 한번 사라지고 끝이 아님...
	 * 2가 있는자리는 소용돌이가 있는곳으로 2초에 사라지고 다시 3초 4초에 생성되고 5초에 사라진다..
	 */
	// TLE...
	static class Node {
		private int y;
		private int x;
		private int seconds;

		public Node(int y, int x, int seconds) {
			this.y = y;
			this.x = x;
			this.seconds = seconds;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int repeatCount = toInt(reader.readLine());
		StringBuilder answers = new StringBuilder();

		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int n = toInt(st.nextToken());

			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(reader.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = toInt(st.nextToken());
				}
			}

			st = new StringTokenizer(reader.readLine());
			int startY = toInt(st.nextToken());
			int startx = toInt(st.nextToken());
			Node source = new Node(startY, startx, 0);

			st = new StringTokenizer(reader.readLine());
			int destinationY = toInt(st.nextToken());
			int destinationX = toInt(st.nextToken());
			Node destination = new Node(destinationY, destinationX, 0);

			int minimumSeconds = searchFastRoad(map, source, destination);
			String answer = String.format("#%d %d", testCase, minimumSeconds);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static final int[] dy = {-1, 1, 0, 0};
	private static final int[] dx = {0, 0, -1, 1};
	private static final int EMPTY = 0;
	private static final int OBSTACLE = 1;
	private static final int SWIRL = 2;

	private static int searchFastRoad(int[][] map, Node source, Node destination) {
		int n = map.length;
		boolean[][] v = new boolean[n][n];
		LinkedList<Node> q = new LinkedList<>();
		q.offer(source);
		v[source.y][source.x] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.y == destination.y && cur.x == destination.x) {
				return cur.seconds;
			}

			for (int i = 0; i < dy.length; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfRange(ny, nx, n))
					continue;
				if (v[ny][nx])
					continue;
				if (map[ny][nx] == OBSTACLE)
					continue;

				if (map[ny][nx] == EMPTY) {
					v[ny][nx] = true;
					q.offer(new Node(ny, nx, cur.seconds + 1));
				} else if (map[ny][nx] == SWIRL) {
					boolean isDisappear = cur.seconds % 3 == 2;
					if (isDisappear) {
						v[ny][ny] = true;
						q.offer(new Node(ny, nx, cur.seconds + 1));
					} else {
						q.offer(new Node(cur.y, cur.x, cur.seconds + 1));
					}
				}
			}
		}

		return -1;
	}

	private static boolean isOutOfRange(int ny, int nx, int n) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
