package FAST_CAMPUS.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BuilingLine {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer>[] adjList = new List[n + 1];

		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		int[] indegree = new int[n + 1];

		// note: 작은 쪽  -> 큰쪽으로 진입차수를 정하고 StringBuilder에 작은 순서대로 넣고 reverse 해줬는데.. 틀렸다고 나오네.. 이유를 모르겠당..
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int higher = Integer.parseInt(st.nextToken());
			int lower = Integer.parseInt(st.nextToken());

			adjList[higher].add(lower);
			indegree[lower]++;
		}

		LinkedList<Integer> q = new LinkedList<>();
		StringBuilder answer = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			Integer cur = q.poll();
			answer.append(cur).append(" ");

			for (Integer next : adjList[cur]) {
				indegree[next]--;

				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}

		System.out.println(answer);
	}
}
