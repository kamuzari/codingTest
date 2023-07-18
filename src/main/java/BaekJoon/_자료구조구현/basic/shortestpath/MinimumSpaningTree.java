package BaekJoon._자료구조구현.basic.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MinimumSpaningTree {
	static int[] parents;

	static class Node implements Comparable<Node> {
		int v1, v2, weight;

		public Node(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		List<Node> list = new ArrayList<>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.add(new Node(v1, v2, weight));
		}

		Collections.sort(list);

		long answer = 0;
		int connect = 0;
		for (Node cur : list) {
			if (connect == n - 1) {
				break;
			}

			if (find(cur.v1) != find(cur.v2)) {
				union(cur.v1, cur.v2);
				answer += cur.weight;
				connect++;
			}
		}

		System.out.println(answer);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}

	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}
}
