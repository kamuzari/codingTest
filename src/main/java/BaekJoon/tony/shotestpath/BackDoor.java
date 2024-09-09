package BaekJoon.tony.shotestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BackDoor {
	static class Node implements Comparable<Node> {
		int to;
		long cost;

		public Node(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int vertexCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());

		Set<Integer> visibleIds = new HashSet<>();
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < vertexCount; i++) {
			boolean isVisible = Integer.parseInt(st.nextToken()) == 1;
			if (!isVisible) {
				continue;
			}

			visibleIds.add(i);
		}

		List<Node>[] edges = new List[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(reader.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges[from].add(new Node(to, cost));
			edges[to].add(new Node(from, cost));
		}

		long[] dists = new long[vertexCount];
		Arrays.fill(dists, Long.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int lastVertexId = vertexCount - 1;
		pq.offer(new Node(0, 0));
		dists[0] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dists[cur.to] < cur.cost) {
				continue;
			}
			
			for (Node next : edges[cur.to]) {
				long newDistance = dists[cur.to] + next.cost;

				if (dists[next.to] <= newDistance) {
					continue;
				}

				if (next.to != lastVertexId && visibleIds.contains(next.to)) {
					continue;
				}

				dists[next.to] = newDistance;
				pq.offer(new Node(next.to, newDistance));
			}
		}

		long answer = dists[lastVertexId];
		boolean isInitial = answer == Long.MAX_VALUE;
		if (isInitial) {
			answer = -1;

		}
		System.out.println(answer);
	}
}
