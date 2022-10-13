package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class WonderLand {
	static int[] relations;
	static List<Node> roads = new ArrayList<>();

	static class Node {
		private int v1, v2;
		private int cost;

		public Node(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		relations = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			relations[i] = i;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(reader.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			roads.add(new Node(v1, v2, cost));
		}

		Comparator<Node> minimumCost = (a, b) -> a.cost - b.cost;

		Collections.sort(roads, minimumCost);

		int builtRoad = 0;
		int totalCost = 0;

		for (Node road : roads) {
			if (isEnd(builtRoad, v)) {
				break;
			}

			if (isPossibleConnect(road.v1, road.v2)) {
				union(road.v1, road.v2);

				totalCost += road.cost;
			}
		}

		System.out.println(totalCost);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			relations[b] = a;
		} else {
			relations[a] = b;
		}
	}

	public static int find(int v) {
		if (v == relations[v]) {
			return v;
		}

		return relations[v] = find(relations[v]);
	}

	public static boolean isPossibleConnect(int a, int b) {
		return find(a) != find(b);
	}

	public static boolean isEnd(int connectedEdge, int totalVertex) {
		return connectedEdge == totalVertex - 1;
	}
}
