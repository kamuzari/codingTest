package hoseokCT.weekly1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * note: 신이 좋아하는 문자열은 중복될 수도 있다.
 *  - 키가 중복되어 linked hash의 순서가 달라질 수 있다. 조심해야한다.
 */
public class HellString_BFS {
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int n;
	private static int m;
	private static int MAX_LENGTH = 5;

	static class Node {
		private int y, x;
		private String results = "";

		public Node(int y, int x, char ch) {
			this.y = y;
			this.x = x;
			results += ch;
		}

		public Node(int y, int x, String ch) {
			this.y = y;
			this.x = x;
			results += ch;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());

		char[][] grid = new char[n][m];

		for (int i = 0; i < n; i++) {
			grid[i] = reader.readLine().toCharArray();
		}

		Map<String, Integer> conditions = new HashMap<>();
		List<String> keys = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			String word = reader.readLine();

			keys.add(word);
			conditions.put(word, 0);
		}

		LinkedList<Node> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				q.offer(new Node(i, j, grid[i][j]));
			}
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (conditions.containsKey(cur.results)) {
				conditions.put(
					cur.results,
					conditions.getOrDefault(cur.results, 0) + 1
				);
			}

			if (cur.results.length() > MAX_LENGTH) {
				continue;
			}

			for (int i = 0; i < 8; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (isOutOfIndex(ny, nx)) {
					ny = (ny + n) % n;
					nx = (nx + m) % m;
				}

				q.offer(
					new Node(ny, nx, cur.results + grid[ny][nx])
				);
			}
		}

		System.out.println(
			keys.stream()
				.map(key -> String.valueOf(conditions.get(key)))
				.collect(Collectors.joining("\n"))
		);
	}

	private static boolean isOutOfIndex(int y, int x) {
		return x < 0 || y < 0 || y >= n || x >= m;
	}
}
