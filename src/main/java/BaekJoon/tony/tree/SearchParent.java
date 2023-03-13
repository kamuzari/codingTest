package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SearchParent {
	static boolean v[];
	static List<Integer>[] adj;
	static TreeMap<Integer, Integer> map;    // 자식 번호, 부모 번호

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		final int root = 1;
		map = new TreeMap<>();

		int n = Integer.parseInt(reader.readLine());
		adj = new List[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			adj[v1].add(v2);
			adj[v2].add(v1);
		}

		// dfs(root);
		bfs(root);
		map.keySet().forEach(child -> System.out.println(map.get(child)));
	}

	public static void dfs(int parent) {
		v[parent] = true;

		for (Integer next : adj[parent]) {
			if (v[next])
				continue;

			map.put(next, parent);
			dfs(next);
		}
	}

	public static void bfs(int root) {
		LinkedList<Integer> q = new LinkedList<>();

		q.offer(root);
		v[root] = true;

		while (!q.isEmpty()) {
			Integer parent = q.poll();

			for (Integer next : adj[parent]) {
				if (v[next])
					continue;

				v[next] = true;
				map.put(next, parent);
				q.offer(next);
			}
		}
	}
}
