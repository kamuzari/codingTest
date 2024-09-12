package BaekJoon.tony.shotestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PowerPlantInstallation {
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	private static Plant[] plants;

	static void input() {
		st = new StringTokenizer(sc.nextLine());
	}

	static class Plant {
		int idx, y, x;

		public Plant(int idx, int y, int x) {
			this.idx = idx;
			this.y = y;
			this.x = x;
		}
	}

	static class Node implements Comparable<Node> {
		private int vertex;
		private double cost;

		public Node(int vertex, double cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(cost, o.cost);
		}
	}

	static List<Node>[] edges;

	public static void main(String[] args) {
		input();
		int plantCount = Integer.parseInt(st.nextToken());
		int wireCount = Integer.parseInt(st.nextToken());

		input();
		double limitedLength = Double.parseDouble(st.nextToken());

		plants = new Plant[plantCount + 1];
		for (int i = 0; i < plantCount; i++) {
			input();
			plants[i + 1] = new Plant(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		edges = new List[plantCount + 1];
		for (int i = 1; i < plantCount + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		boolean[][] isConnected = new boolean[plantCount + 1][plantCount + 1];
		for (int i = 0; i < wireCount; i++) {
			input();
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edges[from].add(new Node(to, 0.0));
			edges[to].add(new Node(from, 0.0));

			isConnected[from][to] = true;
			isConnected[to][from] = true;
		}

		for (int i = 1; i < plantCount + 1; i++) {
			Plant current = plants[i];
			for (int j = i + 1; j < plantCount + 1; j++) {
				Plant next = plants[j];
				int a = current.idx;
				int b = next.idx;
				if (isConnected[a][b] && isConnected[b][a]) {
					continue;
				}

				double cost = calculate(current, next);
				edges[a].add(new Node(b, cost));
				edges[b].add(new Node(a, cost));
			}
		}

		double distances[] = new double[plantCount + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[1] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0.0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (distances[cur.vertex] < cur.cost) {
				continue;
			}

			for (Node next : edges[cur.vertex]) {
				boolean isAlreadyConnected = isConnected[next.vertex][cur.vertex];
				if (isAlreadyConnected) {
					double newCost = cur.cost;
					if (distances[next.vertex] <= newCost) {
						continue;
					}

					distances[next.vertex] = newCost;
					pq.offer(new Node(next.vertex, cur.cost));
					continue;
				}

				boolean notValid = limitedLength < next.cost;
				if (notValid) {
					continue;
				}

				double newCost = distances[cur.vertex] + next.cost;
				boolean isNotShortest = distances[next.vertex] <= newCost;
				if (isNotShortest)
					continue;

				distances[next.vertex] = newCost;
				pq.offer(new Node(next.vertex, newCost));
			}
		}

		int answer = (int)(distances[plantCount] * 1000);
		System.out.println(answer);
	}

	static double calculate(Plant a, Plant b) {
		return Math.sqrt(Math.pow(Math.abs(a.y - b.y), 2) + Math.pow(Math.abs(a.x - b.x), 2));
	}

}
