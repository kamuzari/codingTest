package BaekJoon.honeytip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MooTube {
	static class Node {
		private int v, cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	// 5천 * 5천..
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int queryCount = Integer.parseInt(st.nextToken());
		List<Node> adjacency[] = new List[n + 1];
		for (int i = 0; i < n + 1; i++) {
			adjacency[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(sc.nextLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjacency[a].add(new Node(b, cost));
			adjacency[b].add(new Node(a, cost));
		}
		StringBuilder answers = new StringBuilder();
		for (int i = 0; i < queryCount; i++) {
			st = new StringTokenizer(sc.nextLine());
			int graterThanValue = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int videoCount = 0;
			LinkedList<Integer> q = new LinkedList<>();
			boolean[] v = new boolean[n + 1];
			v[start] = true;
			q.offer(start);
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (Node next : adjacency[cur]) {
					if (!v[next.v] && next.cost >= graterThanValue) {
						v[next.v] = true;
						videoCount++;
						q.offer(next.v);
					}
				}
			}

			answers.append(videoCount).append("\n");
		}

		System.out.println(answers);

	}
}
