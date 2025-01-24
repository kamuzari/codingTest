package programmers.kakao;

import java.util.ArrayList;
import java.util.List;

public class DonutsAndBarGraph {
	private static final int POLL_SHAPE = 2;
	private static final int EIGHT_SHAPE = 3;
	private static final int DONUT_SHAPE = 1;
	private static final int CREATE_VERTEX = 0;

	private List<Integer>[] adjacency;
	private boolean[] isActive;
	private int[] in;
	private int[] out;

	public int[] solution(int[][] edges) {
		int size = calculateMaxSize(edges);
		initialize(size);

		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];

			activate(from, to);
			reconstruct(from, to);
			createDegree(from, to);
		}

		return getAnswer(size);
	}

	private int[] getAnswer(int size) {
		int[] answer = new int[4];
		int creatVertexId = findCreateVertex(size);
		answer[CREATE_VERTEX] = creatVertexId;
		int totalGraphCount = out[creatVertexId];
		removeHistory(creatVertexId);

		answer[POLL_SHAPE] = countPollShape(size);
		answer[EIGHT_SHAPE] = countEightShape(size);
		answer[DONUT_SHAPE] = calculateDonutShape(totalGraphCount, answer);

		return answer;
	}

	private int calculateDonutShape(int totalGraphCount, int[] answer) {
		return totalGraphCount - (answer[2] + answer[3]);
	}

	private int countEightShape(int size) {
		int count = 0;
		for (int i = 1; i < size + 1; i++) {
			if (in[i] == 2 && out[i] == 2) {
				count++;
			}
		}

		return count;
	}

	private int countPollShape(int size) {
		int count = 0;
		for (int i = 1; i < size + 1; i++) {
			if (!isActive[i])
				continue;

			if (out[i] == 0) {
				in[i] = out[i] = Integer.MAX_VALUE;
				count++;
			}
		}

		return count;
	}

	private void removeHistory(int vertex) {
		for (Integer next : adjacency[vertex]) {
			in[next]--;
		}
		adjacency[vertex].clear();
		out[vertex] = in[vertex] = Integer.MAX_VALUE;
	}

	private void activate(int from, int to) {
		isActive[from] = true;
		isActive[to] = true;
	}

	private void reconstruct(int from, int to) {
		adjacency[from].add(to);
	}

	private void createDegree(int from, int to) {
		in[to]++;
		out[from]++;
	}

	private int findCreateVertex(int size) {
		while (size-- > 1) {
			boolean isCreateVertex = in[size] == 0 && out[size] >= 2;
			if (isCreateVertex) {
				return size;
			}
		}

		throw new RuntimeException("fatal error");
	}

	private int calculateMaxSize(int[][] edges) {
		int maxNumber = -1;
		for (int[] edge : edges) {
			maxNumber = Math.max(maxNumber, Math.max(edge[0], edge[1]));
		}

		return maxNumber;
	}

	void initialize(int size) {
		adjacency = new List[size + 1];
		for (int i = 0; i < size + 1; i++) {
			adjacency[i] = new ArrayList<>();
		}

		in = new int[size + 1];
		out = new int[size + 1];
		isActive = new boolean[size + 1];
	}
}
