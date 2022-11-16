package FAST_CAMPUS.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class DevelopGame {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		List<Integer>[] adjList = new List[n + 1];
		int[] indegrees = new int[n + 1];
		int[] buildTime = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int building = 1; building <= n; building++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

			int time = Integer.parseInt(tokenizer.nextToken());
			buildTime[building] = time;

			while (tokenizer.hasMoreTokens()) {
				int preCondition = Integer.parseInt(tokenizer.nextToken());

				if (preCondition == -1)
					break;

				adjList[preCondition].add(building);
				indegrees[building]++;
			}
		}

		LinkedList<Integer> q = new LinkedList<>();
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (indegrees[i] == 0) {
				q.offer(i);
				dp[i]=buildTime[i];
			}
		}

		while (!q.isEmpty()) {
			Integer cur = q.poll();

			for (Integer next : adjList[cur]) {
				indegrees[next]--;

				dp[next] = Math.max(dp[next], dp[cur] + buildTime[next]);

				if (indegrees[next] == 0) {
					q.offer(next);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(dp[i]);
		}
	}
}
