package FAST_CAMPUS.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * note : 반레케이스 어떤 것은 사이클을 갖지만 따른 트리가 주어질 경우도 고려해야함.
 * 6 7
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 * 5 6
 * 0 0
 */
public class Tree4803 {
	private static final int NO_PARENT = -1;
	private static boolean isValidTree;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int sequence = 0;

		while (true) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			if (v == 0 && e == 0) {
				break;
			}
			List<Integer>[] adjList = new List[v + 1];

			for (int i = 0; i < v + 1; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(reader.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				adjList[v1].add(v2);
				adjList[v2].add(v1);
			}

			boolean visit[] = new boolean[v + 1];
			int tree = 0;
			sequence++;

			for (int i = 1; i <= v; i++) {
				if (visit[i])
					continue;

				isValidTree = true;

				dfs(NO_PARENT, i, visit, adjList);

				if (isValidTree) {
					tree++;
				}
			}

			answer.append(Message.print(tree, sequence)).append("\n");
		}

		System.out.println(answer);
	}

	private static void dfs(int prev, int parent, boolean[] visit, List<Integer>[] adjList) {
		if (!isValidTree) {
			return;
		}

		visit[parent] = true;

		for (Integer next : adjList[parent]) {
			if (prev != next && visit[next]) {
				isValidTree = false;
				return;
			}

			if (prev == next) {
				continue;
			}

			dfs(parent, next, visit, adjList);
		}
	}

	//
	enum Message {
		NO_TREE("Case %d: No trees."),
		ONE_TREE("Case %d: There is one tree."),
		OVER("Case %d: A forest of %d trees.");

		private String message;

		Message(String message) {
			this.message = message;
		}

		public static String print(int tree, int count) {
			if (tree == 0) {
				return String.format(NO_TREE.message, count);
			} else if (tree == 1) {
				return String.format(ONE_TREE.message, count);
			} else {
				return String.format(OVER.message, count, tree);
			}
		}

	}
}
