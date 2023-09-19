package BaekJoon.tony.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 승법이네 {

	static class Node implements Comparable<Node> {
		int v;
		long cost;

		public Node(int v, long cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cost < o.cost) {
				return -1;
			} else if (this.cost == o.cost) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = toInt(st.nextToken());
		int m = toInt(st.nextToken());
		int k = toInt(st.nextToken());

		List<Node> list[] = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		// 단방향이니 거꾸로 넣어줘야 함. 도착지 부터 시작할거여서
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int v1 = toInt(st.nextToken());
			int v2 = toInt(st.nextToken());
			long cost = toLong(st.nextToken());

			list[v2].add(new Node(v1, cost));
		}


		long[] dists = new long[n + 1];
		Arrays.fill(dists, Long.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < k; i++) {
			int destination = toInt(st.nextToken());
			dists[destination] = 0;
			pq.offer(new Node(destination, 0));
		}

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dists[cur.v] < cur.cost)
				continue;

			for (Node next : list[cur.v]) {
				long totalCost = dists[cur.v] + next.cost;

				if (dists[next.v] > totalCost) {
					dists[next.v] = totalCost;
					pq.offer(new Node(next.v, totalCost));
				}
			}
		}
		long answerV=0L;
		long answerCost=0L;
		for (int i = 1; i <=n ; i++) {
			if(dists[i]>answerCost){
				answerV=i;
				answerCost=dists[i];
			}
		}

		System.out.println(answerV);
		System.out.println(answerCost);
	}

	public static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static int toLong(String s) {
		return Integer.parseInt(s);
	}
}
