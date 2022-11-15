package FAST_CAMPUS.TopologySort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class YoungWooIsCheater {
	enum Message {
		TRUE("King-God-Emperor"),
		FALSE("Lier!");

		private String answer;

		Message(String answer) {
			this.answer = answer;
		}

		public String getAnswer() {
			return answer;
		}
	}

	private static final int BUILD = 1;
	private static final int DESTROY = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());

		List<Integer>[] adjList = new List[n + 1];
		Set<Integer>[] removals = new Set[n + 1];
		int[] indegrees = new int[n + 1];
		int[] buildCounting = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
			removals[i] = new HashSet<>();
		}

		for (int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int from = Integer.parseInt(tokenizer.nextToken());
			int to = Integer.parseInt(tokenizer.nextToken());

			adjList[from].add(to);
			indegrees[to]++;
		}

		for (int i = 0; i < k; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int cmd = Integer.parseInt(tokenizer.nextToken());
			int building = Integer.parseInt(tokenizer.nextToken());

			if (cmd == BUILD) {
				if (indegrees[building] != 0) {
					lie();
					return;
				}

				buildCounting[building]++;

				for (Integer next : adjList[building]) {
					if (!removals[next].contains(building)) {
						removals[next].add(building);

						if (indegrees[next] != 0) {
							indegrees[next]--;
						}
					}
				}

			} else if (cmd == DESTROY) {
				if (buildCounting[building] == 0) {
					lie();
					return;
				}

				buildCounting[building]--;

				if (buildCounting[building] == 0) {
					for (Integer next : adjList[building]) {
						removals[next].clear();
						indegrees[next]++;
					}
				}
			}
		}

		System.out.println(Message.TRUE.getAnswer());

	}

	public static void lie() {
		System.out.println(Message.FALSE.getAnswer());
	}
}
