package BaekJoon.tony.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemBundle {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] indegrees = new int[n + 1];

		List<Integer> adj[] = new List[n + 1];

		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			indegrees[to]++;
		}

		PriorityQueue<Integer> q = new PriorityQueue<>(); // 일반 큐로 하면 3,4,1,2 | (3,4) -> 진입차수 0인거 넣고
		for (int i = 1; i <= n; i++) {
			if (indegrees[i] == 0)
				q.offer(i);
		}

		StringBuilder answer = new StringBuilder();
		while (!q.isEmpty()) {
			Integer cur = q.poll();
			answer.append(cur+" ");
			for (Integer next : adj[cur]) {
				indegrees[next]--;

				if(indegrees[next]==0){
					q.offer(next);
				}
			}
		}

		System.out.println(answer);
	}

}
