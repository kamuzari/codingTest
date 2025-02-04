package programmers.basic;

import java.util.PriorityQueue;

public class ConnectingIsland {
	int[] parent;

	class Node implements Comparable<Node> {
		int v1, v2;
		int cost;

		public Node(int[] cost) {
			this.v1 = cost[0];
			this.v2 = cost[1];
			this.cost = cost[2];
		}

		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}

	public int solution(int n, int[][] costs) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int[] cost : costs) {
			pq.add(new Node(cost));
		}

		int connectCount = 0;
		int totalCost = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			int a = find(node.v1);
			int b = find(node.v2);

			if (a != b) {
				union(a, b);
				connectCount++;
				totalCost += node.cost;
			}

			if (connectCount == n - 1) {
				break;
			}

		}

		return totalCost;
	}

	void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	int find(int a) {
		if (parent[a] == a) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}
}
