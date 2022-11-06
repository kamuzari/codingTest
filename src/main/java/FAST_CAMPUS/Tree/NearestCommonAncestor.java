package FAST_CAMPUS.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class NearestCommonAncestor {
	private static int commonAncestor = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int testCount = Integer.parseInt(reader.readLine());

		for (int testCase = 0; testCase < testCount; testCase++) {
			int n = Integer.parseInt(reader.readLine());

			List<Integer>[] adjList = new List[n + 1];

			for (int i = 1; i <= n; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < n - 1; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				adjList[v2].add(v1);
			}

			StringTokenizer st = new StringTokenizer(reader.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			Set<Integer> parents = new HashSet<>();
			parents.add(v1);
			search(v1, new boolean[n + 1], parents, adjList);

			if (parents.contains(v2)) { // v2가 v1보다 상위에 있다면!
				System.out.println(v2);
			} else {
				searchCommonParent(v2, new boolean[n + 1], parents, adjList);
				System.out.println(commonAncestor);
			}

		}
	}

	/**
	 * note : 일반적인 dfs 탐색에서는 어디가 부모인지 어디가 자식인지 알 수 없다.
	 *   - 그러면 자식에서 부모노드인 단방향으로 구성하면 어떤가? 어차피 끝에서 찾을건데?
	 * @param parent
	 * @param v
	 * @param parents
	 * @param adjList
	 */
	public static void search(int parent, boolean v[], Set<Integer> parents, List<Integer>[] adjList) {
		v[parent] = true;

		for (Integer next : adjList[parent]) {
			if (v[next])
				continue;

			parents.add(next);
			search(next, v, parents, adjList);
		}
	}

	public static void searchCommonParent(int parent, boolean v[], Set<Integer> prevAncestors,
		List<Integer>[] adjList) {
		v[parent] = true;

		if (prevAncestors.contains(parent)) {
			commonAncestor = parent;
			return;
		}

		for (Integer next : adjList[parent]) {
			if (v[next])
				continue;

			searchCommonParent(next, v, prevAncestors, adjList);
		}
	}
}
