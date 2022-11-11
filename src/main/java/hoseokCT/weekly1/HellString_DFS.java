package hoseokCT.weekly1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class HellString_DFS {
	static int MAX_LENGTH;
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int n;
	private static int m;
	private static char[][] grid;
	private static Map<String, Integer> conditions;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());

		grid = new char[n][m];

		for (int i = 0; i < n; i++) {
			grid[i] = reader.readLine().toCharArray();
		}

		conditions = new HashMap<>();
		List<String> keys = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			String key = reader.readLine();
			conditions.put(key, 0);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(0, i, j, Character.toString(grid[i][j]));
			}
		}

		System.out.println(
			keys.stream()
				.map(key -> String.valueOf(conditions.get(key)))
				.collect(Collectors.joining("\n"))
		);

	}

	public static void dfs(int depth, int y, int x, String result) {
		if (depth >= MAX_LENGTH) {
			return;
		}

		if (conditions.containsKey(result)) { // aaa, aaab도 답이 될 수 있는 경우가 있지 않은가? 왜버리니?
			conditions.put(
				result,
				conditions.getOrDefault(result, 0) + 1
			);
		}

		for (int i = 0; i < 8; i++) {
			int ny = (y + dy[i] + n) % n;
			int nx = (x + dx[i] + m) % m;

			dfs(depth + 1, ny, nx, result + grid[ny][nx]);
		}
	}
}
