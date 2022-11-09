package FAST_CAMPUS.GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ACMCraft {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());
		StringBuilder buildAnswers = new StringBuilder();

		for (int testCase = 0; testCase < test; testCase++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] buildingTimes = new int[n + 1];

			st = new StringTokenizer(reader.readLine());

			for (int i = 1; i <= n; i++) {
				buildingTimes[i] = Integer.parseInt(st.nextToken());
			}

			List<Integer>[] adjList = new List[n + 1];

			for (int i = 1; i <= n; i++) {
				adjList[i] = new ArrayList<>();
			}

			int[] inDegrees = new int[n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(reader.readLine());

				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				adjList[v1].add(v2);
				inDegrees[v2]++;
			}

			LinkedList<Integer> q = new LinkedList<>();

			for (int i = 1; i <= n; i++) {
				if (inDegrees[i] == 0) {
					q.offer(i);
				}
			}

			int target = Integer.parseInt(reader.readLine());
			int[] dp = buildingTimes.clone();

			while (!q.isEmpty()) {
				Integer cur = q.poll();

				if (target == cur) {
					break;
				}

				for (Integer next : adjList[cur]) {
					dp[next] = Math.max(dp[next], dp[cur] + buildingTimes[next]);
					inDegrees[next]--;

					if (inDegrees[next] == 0) {
						q.offer(next);
					}
				}
			}

			buildAnswers.append(dp[target]).append("\n");
		}

		System.out.println(buildAnswers);
	}
}
