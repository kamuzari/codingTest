package FAST_CAMPUS.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EnterpriseCulture {

	private static int[] compliances;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer>[] adjList = new List[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		st = new StringTokenizer(reader.readLine());
		int root = 1;

		for (int node = 0; node < n; node++) {
			int parent = Integer.parseInt(st.nextToken());

			if (parent == -1) {
				continue;
			}

			adjList[parent].add(node+1);
		}

		compliances = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());

			int employee = Integer.parseInt(st.nextToken());
			int compliance = Integer.parseInt(st.nextToken());

			compliances[employee] += compliance;
		}

		dfs(1, adjList);

		for (int i = 1; i <= n; i++) {
			System.out.print(compliances[i] + " ");
		}

	}

	private static void dfs(int parent, List<Integer>[] adjList) {
		for (Integer next : adjList[parent]) {
			compliances[next] += compliances[parent];
			dfs(next, adjList);
		}
	}
}
