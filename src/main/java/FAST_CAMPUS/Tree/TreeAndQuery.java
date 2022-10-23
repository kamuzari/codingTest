package FAST_CAMPUS.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class TreeAndQuery {

	private static int[] subtrees;
	private static boolean[] v;
	private static List<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int root = Integer.parseInt(st.nextToken());
		int query = Integer.parseInt(st.nextToken());

		adjList = new List[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(reader.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjList[u].add(v);
			adjList[v].add(u);
		}

		subtrees = new int[n + 1];
		Arrays.fill(subtrees, 1);

		dfs(root);

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < query; i++) {
			int node = Integer.parseInt(reader.readLine());
			answer.append(subtrees[node]).append("\n");
		}

		System.out.println(answer);
	}

	private static int dfs(int cur) {
		if (v[cur])
			return subtrees[cur];

		v[cur] = true;

		for (Integer next : adjList[cur]) {
			if (v[next])
				continue;

			subtrees[cur] += dfs(next);
		}

		return subtrees[cur];
	}
}
