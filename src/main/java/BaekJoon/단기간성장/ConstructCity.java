package BaekJoon.단기간성장;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConstructCity {
	static Scanner sc = new Scanner(System.in);

	static class Bridge implements Comparable<Bridge> {
		private int cityId1;
		private int cityId2;

		private int cost;

		public Bridge(int cityId1, int cityId2, int cost) {
			this.cityId1 = cityId1;
			this.cityId2 = cityId2;
			this.cost = cost;
		}

		public int compareTo(Bridge o) {
			return cost - o.cost;
		}
	}

	static int[] parents;

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}

	static void union(int nodeId1, int nodeId2) {
		int root1 = find(nodeId1);
		int root2 = find(nodeId2);

		if (root1 < root2) {
			parents[root2] = root1;
		} else {
			parents[root1] = root2;
		}
	}

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		long originalTotalCost = 0L;
		PriorityQueue<Bridge> pq = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(sc.nextLine());
			int nodeId1 = Integer.parseInt(st.nextToken());
			int nodeId2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Bridge(nodeId1, nodeId2, cost));
			originalTotalCost += (long)cost;
		}

		int expectedBridgeCount = n - 1;
		int connectCount = 0;
		long totalCost = 0L;
		while (!pq.isEmpty()) {
			Bridge bridge = pq.poll();
			boolean isAlreadyConnect = find(bridge.cityId1) == find(bridge.cityId2);
			if (!isAlreadyConnect) {
				union(bridge.cityId1, bridge.cityId2);
				connectCount++;
				totalCost += (long)bridge.cost;
			}

			if (connectCount == expectedBridgeCount) {
				break;
			}
		}

		if (expectedBridgeCount == connectCount) {
			System.out.println(originalTotalCost - totalCost);
		} else {
			System.out.println(-1);
		}

	}
}
