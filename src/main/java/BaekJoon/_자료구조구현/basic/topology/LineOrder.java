package BaekJoon._자료구조구현.basic.topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class LineOrder {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		int[] indegrees = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			indegrees[to]++;
		}

		LinkedList<Integer> q = new LinkedList<>();
		StringBuilder answer = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			if (indegrees[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			Integer cur = q.poll();
			answer.append(cur).append(" ");

			for (Integer next : list[cur]) {
				indegrees[next]--;

				if (indegrees[next] == 0) {
					q.offer(next);
				}
			}
		}

		System.out.println(answer);
	}
}
