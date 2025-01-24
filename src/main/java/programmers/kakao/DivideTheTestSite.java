package programmers.kakao;

import java.util.Arrays;

public class DivideTheTestSite {
	public static final int NOT_FOUND = -1;
	public static final int INF = 10_001;

	int[] populations;
	int[][] edges;
	int groupCondition;
	int root;

	public int solution(int k, int[] num, int[][] links) {
		populations = num;
		edges = links;
		groupCondition = k;
		root = findRoot();

		int totalPopulation = Arrays.stream(num).sum();
		int s = totalPopulation / k;
		int e = totalPopulation;
		int answer = INF;

		while (s <= e) {
			int populationCondition = (s + e) >> 1;

			if (isPossible(populationCondition, groupCondition)) {
				e = populationCondition - 1;
				answer = Math.min(answer, populationCondition);
			} else {
				s = populationCondition + 1;
			}
		}

		return answer;
	}

	int dfsGroupCount;

	int dfs(int cur, int limit) {
		boolean hasNotChild = cur == NOT_FOUND;
		if (hasNotChild) {
			return 0;
		}

		if (limit < populations[cur]) {
			dfsGroupCount = INF;
			return populations[cur];
		}

		int left = dfs(edges[cur][0], limit);
		int right = dfs(edges[cur][1], limit);

		if (populations[cur] + left + right <= limit) {
			return populations[cur] + left + right;
		}

		if (left == 0 || right == 0) {
			dfsGroupCount++;
			return populations[cur];
		}

		if (left + populations[cur] <= limit && right + populations[cur] <= limit) {
			dfsGroupCount++;
			return left < right ? left + populations[cur] : right + populations[cur];
		}

		if (left + populations[cur] <= limit) {
			dfsGroupCount++;
			return left + populations[cur];
		}

		if (right + populations[cur] <= limit) {
			dfsGroupCount++;
			return right + populations[cur];
		}

		dfsGroupCount += 2;

		return populations[cur];
	}

	public boolean isPossible(int populationCondition, int groupCondition) {
		dfsGroupCount = 0;
		dfs(root, populationCondition);
		return dfsGroupCount < groupCondition;
	}

	public int findRoot() {
		int n = populations.length;

		int[] parent = new int[n];
		Arrays.fill(parent, NOT_FOUND);

		for (int i = 0; i < n; i++) {
			if (edges[i][0] != -1) {
				parent[edges[i][0]] = i;
			}

			if (edges[i][1] != -1) {
				parent[edges[i][1]] = i;
			}
		}

		for (int i = 0; i < n; i++) {
			if (parent[i] == NOT_FOUND) {
				return i;
			}
		}

		throw new RuntimeException("not found root");
	}
}
