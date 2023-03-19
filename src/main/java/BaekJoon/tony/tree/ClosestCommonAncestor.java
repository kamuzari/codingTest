package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class ClosestCommonAncestor {

	private static Set<Integer> v1Parents;
	private static List<Integer>[] adj;
	private static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int repeat = Integer.parseInt(reader.readLine());

		while (repeat-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			adj = new List[n + 1];

			for (int i = 1; i <= n; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < n-1; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				adj[child].add(parent); //  자식 -> 부모로만 가는 단방향
			}

			StringTokenizer st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			v1Parents = new HashSet<>();
			dfs(v1);
			searchCommonAncestor(v2);

			answer.append(result).append("\n");
		}

		System.out.println(answer);
	}

	static void dfs(int child) {
		v1Parents.add(child);

		for (Integer parent : adj[child]) {
			dfs(parent);
		}
	}

	static void searchCommonAncestor(int child) {
		if (v1Parents.contains(child)) {
			result = child;
			return;
		}

		for (Integer parent : adj[child]) {
			searchCommonAncestor(parent);
		}
	}
}
