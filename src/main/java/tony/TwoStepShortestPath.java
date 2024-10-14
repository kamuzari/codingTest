package tony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TwoStepShortestPath {

	static class Node implements Comparable<Node> {
		int vertex;
		long cost;

		public Node(int vertex, long cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(cost, o.cost);
		}
	}

	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());

		String s4 = st.nextToken();
		n = Integer.parseInt(s4);
		String s3 = st.nextToken();
		int m = Integer.parseInt(s3);
		int repeat = m;

		List<Node>[] edges = new List[n + 1];
		for (int i = 0; i < n + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(sc.nextLine());
			String s2 = st.nextToken();
			int from = Integer.parseInt(s2);
			String s1 = st.nextToken();
			int to = Integer.parseInt(s1);
			String s = st.nextToken();
			long cost = Long.parseLong(s);
			edges[from].add(new Node(to, cost));
		}

		st = new StringTokenizer(sc.nextLine());
		String s2 = st.nextToken();
		int x = Integer.parseInt(s2);
		String s1 = st.nextToken();
		int y = Integer.parseInt(s1);
		String s = st.nextToken();
		int z = Integer.parseInt(s);

		long[] distX = getDistance(x, edges);
		long[] distY = getDistance(y, edges);
		long ans1 = -1;
		if (distX[y] != INF && distY[z] != INF) {
			ans1 = distX[y] + distY[z];
		}

		takeADetour(edges, y);
		distX = getDistance(x, edges);
		long ans2 = -1;
		if (distX[z] != INF) {
			ans2 = distX[z];
		}

		System.out.println(ans1 + " " + ans2);
	}

	private static void takeADetour(List<Node>[] edges, int y) {
		for (int i = 1; i < n + 1; i++) {
			for (Node next : edges[i]) {
				if (next.vertex == y) {
					next.vertex = 0;
				}
			}
		}
	}

	static final long INF = Long.MAX_VALUE;

	private static long[] getDistance(int start, List<Node>[] edges) {
		long[] distances = new long[n + 1];
		Arrays.fill(distances, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distances[start] = 0L;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (distances[cur.vertex] < cur.cost)
				continue;

			for (Node next : edges[cur.vertex]) {
				long newCost = next.cost + distances[cur.vertex];

				if (distances[next.vertex] <= newCost)
					continue;
				distances[next.vertex] = newCost;

				pq.offer(new Node(next.vertex, newCost));
			}
		}

		return distances;
	}

}
