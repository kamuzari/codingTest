package tony.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WolfAndSheep {
	static final int SHEEP = 0;
	static final int PARENT = 0;
	static final int CHILD = 1;

	static int maxCnt = 0;
	static Map<Integer, List<Integer>> adjList;

	public int solution(int[] info, int[][] edges) {
		adjList = new HashMap<>();
		for (int[] e : edges) {
			if (!adjList.containsKey(e[PARENT])) {
				adjList.put(e[PARENT], new ArrayList<>());
			}
			adjList.get(e[PARENT]).add(e[CHILD]);
		}
		List<Integer> list = new ArrayList<>();
		list.add(SHEEP); // root 는 무조건 양!
		dfs(0, 0, 0, list, info);
		return maxCnt;
	}

	public void dfs(int current, int sheep, int wolf, List<Integer> list, int[] info) {
		if (info[current] == SHEEP) {
			sheep++;
		} else {
			wolf++;
		}

		if (sheep <= wolf) {
			return;
		}

		// 이게 모하는 작업이죠?
		maxCnt = Math.max(maxCnt, sheep);
		List<Integer> nextNodes = new ArrayList<>(list);
		if (adjList.containsKey(current)) {
			nextNodes.addAll(adjList.get(current));
		}
		Integer currentNode = Integer.valueOf(current);
		nextNodes.remove(currentNode);

		for (Integer next : nextNodes) {
			dfs(next, sheep, wolf, nextNodes, info);
		}
	}
}
