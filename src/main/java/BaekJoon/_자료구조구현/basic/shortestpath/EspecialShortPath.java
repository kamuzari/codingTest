package BaekJoon._자료구조구현.basic.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EspecialShortPath {
	private static int INF = (int)1e9;

	static class Node implements Comparable<Node> {
		private int vertex;
		private int weight;

		public Node(int vertex, int edge) {
			this.vertex = vertex;
			this.weight = edge;
		}

		public int getVertex() {
			return vertex;
		}

		public int getEdge() {
			return weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		List<Node> list[] = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[v1].add(new Node(v2, weight));
			list[v2].add(new Node(v1, weight));
		}

		st = new StringTokenizer(reader.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		long answer1 = 0;

		answer1 += getShortestTable(1, v1, list);
		answer1 += getShortestTable(v1, v2, list);
		answer1 += getShortestTable(v2, n, list);

		long answer2 = 0;
		answer2 += getShortestTable(1, v2, list);
		answer2 += getShortestTable(v2, v1, list);
		answer2 += getShortestTable(v1, n, list);

		if (answer1 >= INF && answer2 >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(answer1, answer2));
		}

	}

	public static int getShortestTable(int source, int destination, List<Node> list[]) {
		int n = list.length;
		int[] dists = new int[n];
		Arrays.fill(dists, INF);
		dists[source] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(source, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dists[cur.vertex] < cur.weight)
				continue;

			for (Node next : list[cur.vertex]) {
				int candidateDist = dists[cur.vertex] + next.weight;
				if (candidateDist < dists[next.vertex]) {
					dists[next.vertex] = candidateDist;
					pq.offer(new Node(next.vertex, candidateDist));
				}
			}
		}

		return dists[destination];
	}
}

/*
5 4
1 4 1
1 3 1
3 2 1
2 5 1
3 4
*/
