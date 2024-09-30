package BaekJoon.tony.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	private static List<Node>[] edges;
	static int n;

	static class Node implements Comparable<Node> {
		int v;

		long cost;

		public Node(int v, long cost) {
			this.v = v;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());

		int[] posit = new int[3];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int idx = 0;
		while (st.hasMoreTokens()) {
			posit[idx++] = Integer.parseInt(st.nextToken());
		}
		edges = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}

		int m = Integer.parseInt(sc.nextLine());
		while (m-- > 0) {
			st = new StringTokenizer(sc.nextLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			edges[a].add(new Node(b, l));
			edges[b].add(new Node(a, l));
		}

		long[] distA = getDist(posit[0]);
		long[] distB = getDist(posit[1]);
		long[] distC = getDist(posit[2]);

		long[] mins = new long[n + 1];
		Arrays.fill(mins, INF);
		Set<Integer> sets = Arrays.stream(posit).boxed().collect(Collectors.toSet());
		for (int i = 1; i <= n; i++) {
			if (sets.contains(i))
				continue;
			mins[i] = Math.min(mins[i], distA[i]);
			mins[i] = Math.min(mins[i], distB[i]);
			mins[i] = Math.min(mins[i], distC[i]);
		}

		long minDist = -1;
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (sets.contains(i))
				continue;
			if (minDist < mins[i]) {
				minDist = mins[i];
				answer = i;
			}
		}

		System.out.println(answer);
	}

	private static final long INF = Long.MAX_VALUE;

	static long[] getDist(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		long[] dists = new long[n + 1];
		Arrays.fill(dists, INF);
		dists[start] = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (dists[cur.v] < cur.cost) {
				continue;
			}

			if (dists[cur.v] == INF)
				continue;
			for (Node next : edges[cur.v]) {
				long newCost = dists[cur.v] + next.cost;

				if (dists[next.v] <= newCost) {
					continue;
				}

				dists[next.v] = newCost;
				q.offer(new Node(next.v, newCost));
			}
		}

		return dists;
	}
}
