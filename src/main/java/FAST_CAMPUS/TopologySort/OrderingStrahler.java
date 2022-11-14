package FAST_CAMPUS.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class OrderingStrahler {
	/**
	 * note: 어떻게 레벨을 나눌 수 있을 까?
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answers = new StringBuilder();

		int test = Integer.parseInt(reader.readLine());

		for (int testCase = 0; testCase < test; testCase++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

			int k = Integer.parseInt(tokenizer.nextToken());
			int n = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());

			int[] indegrees = new int[n + 1];
			List<Integer>[] adjList = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				tokenizer = new StringTokenizer(reader.readLine());

				int from = Integer.parseInt(tokenizer.nextToken());
				int to = Integer.parseInt(tokenizer.nextToken());

				adjList[from].add(to);
				indegrees[to]++;
			}

			LinkedList<Integer> q = new LinkedList<>();
			int[] orders = new int[n + 1];
			int[] maxCnts = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				if (indegrees[i] == 0) {
					q.offer(i);
					orders[i] = 1;
					maxCnts[i] = 1;
				}
			}

			int answer = 0;

			while (!q.isEmpty()) {
				Integer cur = q.poll();

				if (maxCnts[cur] >= 2)
					orders[cur]++;

				answer = Math.max(answer, orders[cur]);

				for (Integer next : adjList[cur]) {
					indegrees[next]--;

					if (indegrees[next] == 0)
						q.offer(next);

					if (orders[cur] == orders[next]) // 동일 순서에서 또 방문
						maxCnts[next]++;
					else if (orders[next] < orders[cur]) {
						orders[next] = orders[cur];
						maxCnts[next] = 1;
					}
				}
			}

			answers.append(k).append(" ").append(answer).append("\n");
		}

		System.out.println(answers);
	}
}
