package FAST_CAMPUS.GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RankingSearch {
	private static final int FOWARD = 0;
	private static final int REVERSE = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());


		List<Integer> adj[][] = new ArrayList[2][n + 1];

		for (int i = 1; i <= n; i++) {
			adj[0][i] = new ArrayList<>();
			adj[1][i] = new ArrayList<>();
		}

		int[][] questions = new int[m][2];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());

			int big = Integer.parseInt(st.nextToken());
			int small = Integer.parseInt(st.nextToken());

			adj[0][small].add(big);
			adj[1][big].add(small);
		}

		int up = bfs(x, n, adj[FOWARD]);
		int down = bfs(x, n, adj[REVERSE]);

		int bestRanking = up + 1;
		int worstRanking = n - down;

		System.out.println(bestRanking + " " + worstRanking);
	}

	public static int bfs(int start, int n, List<Integer>[] adjList) {
		LinkedList<Integer> q = new LinkedList<>();
		boolean v[] = new boolean[n + 1];

		v[start] = true;
		int count = 0;

		q.offer(start);

		while (!q.isEmpty()) {
			Integer cur = q.poll();

			for (Integer next : adjList[cur]) {
				if (v[next])
					continue;

				v[next] = true;
				q.offer(next);
				count++;
			}
		}

		return count;
	}
}
