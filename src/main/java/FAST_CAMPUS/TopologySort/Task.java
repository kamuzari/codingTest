package FAST_CAMPUS.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Task {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		List<Integer>[] adjList = new List[n + 1];
		int[] indegrees = new int[n + 1];
		int[] times = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

			int time = Integer.parseInt(tokenizer.nextToken());
			int task = Integer.parseInt(tokenizer.nextToken());

			times[i] = time;

			for (int j = 0; j < task; j++) {
				int preCondition = Integer.parseInt(tokenizer.nextToken());

				adjList[preCondition].add(i);
				indegrees[i]++;
			}
		}

		LinkedList<Integer> q = new LinkedList<>();
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (indegrees[i] == 0) {
				q.offer(i);
				dp[i] = times[i];
			}
		}

		while (!q.isEmpty()) {
			Integer cur = q.poll();

			for (Integer next : adjList[cur]) {
				indegrees[next]--;

				dp[next] = Math.max(dp[next], dp[cur] + times[next]);

				if (indegrees[next] == 0) {
					q.offer(next);
				}
			}
		}

		System.out.println(
			Arrays.stream(dp).max().orElseGet(() -> 0)
		);
	}
}
