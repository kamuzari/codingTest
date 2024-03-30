package saffy.ssafy.homework.daily02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class 달이차오른다가자 {

	static int n, m;
	static int[][] map;

	static class Node {
		int y, x, cnt;
		int keyBit;

		public Node(int y, int x, int cnt, int keyBit) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.keyBit = keyBit;
		}
	}

	static final char toUpperCase(char c) {
		return (char)(c + 32);
	}

	static Map<Character, Integer> mappings;

	static {
		mappings = new HashMap<>();
		mappings.put('a', 1);
		mappings.put('b', 2);
		mappings.put('c', 3);
		mappings.put('d', 4);
		mappings.put('e', 5);
		mappings.put('f', 6);

		mappings.put('A', 10);
		mappings.put('B', 20);
		mappings.put('C', 30);
		mappings.put('D', 40);
		mappings.put('E', 50);
		mappings.put('F', 60);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		Node start = null;
		for (int i = 0; i < n; i++) {
			char[] charray = sc.nextLine().toCharArray();
			for (int j = 0; j < m; j++) {
				char val = charray[j];
				if (val == '0') {
					start = new Node(i, j, 0, 0);
				} else if ((val >= 'a' && val <= 'f') || (val >= 'A' && val <= 'F')) {
					map[i][j] = mappings.get(val);
				} else if (val == '#') {
					map[i][j] = -1;
				} else if (val == '.') {
					continue;
				} else if (val == '1') {
					map[i][j] = 99;
				}
			}
		}

		LinkedList<Node> q = new LinkedList<>();
		q.offer(start);
		boolean[][][] v = new boolean[257][n][m];
		v[0][start.y][start.x] = true;
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (map[cur.y][cur.x] == 99) {
				answer = cur.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOut(ny, nx)) {
					continue;
				}

				if (map[ny][nx] == -1) {
					continue;
				}

				if (map[ny][nx] >= 10 && map[ny][nx] <= 60) {
					// door
					int wantKey = map[ny][nx] / 10;
					int result = cur.keyBit & (1 << wantKey);
					boolean isGo = result > 0;
					if (isGo && !v[cur.keyBit][ny][nx]) {
						v[cur.keyBit][ny][nx] = true;
						q.offer(new Node(ny, nx, cur.cnt + 1, cur.keyBit));
					} else {
						// 못감
						continue;
					}
				} else if (map[ny][nx] >= 1 && map[ny][nx] <= 6) {
					// key
					int newBit = cur.keyBit | (1 << map[ny][nx]);
					if (v[newBit][ny][nx]) {
						continue;
					} else {
						v[newBit][ny][nx] = true;
						q.offer(new Node(ny, nx, cur.cnt + 1, newBit));
					}

				} else if (map[ny][nx] == 99 || map[ny][nx] == 0) {
					if (v[cur.keyBit][ny][nx]) {
						continue;
					}

					q.offer(new Node(ny, nx, cur.cnt + 1, cur.keyBit));
					v[cur.keyBit][ny][nx] = true;
				}
			}
		}

		answer = answer == Integer.MAX_VALUE ? -1 : answer;
		System.out.println(answer);
	}

	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	static boolean isOut(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
