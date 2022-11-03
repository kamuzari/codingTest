package FAST_CAMPUS.GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class VillegerCalculation {
	private static List<Integer>[] adjList;
	private static boolean v[];
	private static int answer=-1;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(reader.readLine());

		adjList = new List[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			adjList[node1].add(node2);
			adjList[node2].add(node1);
		}

		dfs(v1, v2, 1);

		System.out.println(answer);

	}

	public static void dfs(int node, int target, int cnt) {
		v[node] = true;
		for (Integer next : adjList[node]) {

			if (v[next])
				continue;

			if (next == target) {
				answer = cnt;
			}

			dfs(next, target, cnt + 1);
		}
	}

}
