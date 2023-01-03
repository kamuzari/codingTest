package FAST_CAMPUS.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ToyAssembly {

	static class Assembly {
		private int id;
		private int quantity;

		public Assembly(int id, int quantity) {
			this.id = id;
			this.quantity = quantity;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());

		List<Assembly> adj[] = new List[n + 1];
		int inDegrees[] = new int[n + 1];
		int cnt[][] = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int target = Integer.parseInt(tokenizer.nextToken());
			int from = Integer.parseInt(tokenizer.nextToken());
			int need = Integer.parseInt(tokenizer.nextToken());

			adj[from].add(new Assembly(target, need));
			inDegrees[target]++;
		}

		LinkedList<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (inDegrees[i] == 0) {
				q.add(i);
				cnt[i][i] = 1;
			}
		}

		while (!q.isEmpty()) {
			Integer cur = q.poll();

			for (Assembly next : adj[cur]) {
				inDegrees[next.id]--;

				for (int i = 1; i <= n; i++) {
					cnt[next.id][i] += cnt[cur][i] * next.quantity;
				}

				if (inDegrees[next.id] == 0) {
					q.add(next.id);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (cnt[n][i] != 0) {
				System.out.println(i+" "+cnt[n][i]);
			}
		}

	}
}
