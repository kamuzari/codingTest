package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TreeTotalLength {
	static final int INF = Integer.MAX_VALUE;
	static final int ROOT = 1;
	private static List<Node>[] adj;
	private static int n;

	static class Node implements Comparable<Node> {
		private int v, edge;

		public Node(int v, int edge) {
			this.v = v;
			this.edge = edge;
		}

		@Override
		public int compareTo(Node o) {
			return this.edge - o.edge;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());

		// 인접 리스트 초기화
		adj = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		//  인접 리스트 정보 입력
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());

			adj[v1].add(new Node(v2, edge));
			adj[v2].add(new Node(v1,edge));
		}

		Node farNode1 = dijkstra(ROOT);

		Node farNode2 = dijkstra(farNode1.v);

		System.out.println(farNode2.edge);
	}

	public static Node dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		int dists[] = new int[n + 1];
		Arrays.fill(dists, INF);
		dists[start] = 0;

		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dists[cur.v] < cur.edge) { // 거리가 짧은 순으로 조회하다가 이미 더 짧은 간선을 찾았다면 쳐내기 어차피 멀어질것이기에..
				continue;
			}

			for (Node next : adj[cur.v]) { // 인접한 정점으로 이동
				int cost = dists[cur.v] + next.edge; // 해당 정점으로 왔던 거리에서 다음 인접 정점으로 이동하는 비용이

				if (cost < dists[next.v]) { // 현재 기록된 비용보다 작다면 갱신하고 해당 정점과 비용을 우선순위 큐에 넣는다.
					dists[next.v] = cost;
					pq.offer(new Node(next.v, cost));
				}
			}
		}

		int v = -1;
		int maxDist = -1;

		for (int i = 1; i <= n; i++) {
			if (dists[i] > maxDist) {
				maxDist = dists[i];
				v = i;
			}
		}

		return new Node(v, maxDist);
	}
}
