package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreePillarAndBranch {

	private static int root;

	static class Node {
		private int v, edge;

		public Node(int v, int edge) {
			this.v = v;
			this.edge = edge;
		}
	}

	static List<Node> adj[];
	static Node pillar;
	static boolean[] v;
	static int maxBranch;

	public static void main(String[] args) throws IOException {
		/**
		 * 나무의 기둥의 길이와 긴 가지의 길이를 파악하라.
		 *
		 * 기둥 - 루트에서 기가 노드 까지 이다. (:= 자식 노드가 하나인것)
		 * 	- 루트가 기가노드일 수 도 있다.
		 * 가지 - 기가노드 부터 임의의 리프 노드 까지이다.
		 * 기둥이 없고 가지가 2개일떄.
		 * 3 1
		 * 1 2 5
		 * 1 3 5
		 * ansewr: 0,5
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		root = Integer.parseInt(st.nextToken());

		adj = new List[n + 1];
		for (int i = 1; i < n + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			adj[v1].add(new Node(v2, edge));
			adj[v2].add(new Node(v1, edge));
		}
		v = new boolean[n + 1];
		measurePillar(root, 0);
		getLongestBranch(pillar.v, 0);

		System.out.println(pillar.edge + " " + maxBranch);
	}

	public static void measurePillar(int parent, int dist) {
		v[parent] = true;
		pillar = new Node(parent, dist);

		if (adj[parent].size() > 2 || (parent==root && adj[parent].size()>1)) {
			return;
		}

		for (Node next : adj[parent]) {
			if (v[next.v])
				continue;

			measurePillar(next.v, dist + next.edge);
		}
	}

	public static void getLongestBranch(int parent, int dist) {
		maxBranch = Math.max(maxBranch, dist);
		v[parent] = true;

		for (Node next : adj[parent]) {
			if (v[next.v])
				continue;

			getLongestBranch(next.v, dist + next.edge);
		}
	}
}
