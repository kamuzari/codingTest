package saffy.B형기출문제집;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeoulSubway2Line {
	static int n;
	static List<Integer> edges[];
	static int[] distanceFromCycleLine;

	// 1 - 3 - 4 - 2

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		edges = new List[n + 1];
		distanceFromCycleLine = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			edges[v1].add(v2);
			edges[v2].add(v1);
		}

		searchCycle();
		List<Integer> nonCycleStations = IntStream.rangeClosed(1, n)
				.filter(id -> !cycleStations.contains(id))
				.boxed()
				.collect(Collectors.toList());

		for (Integer nonCycleStation : nonCycleStations) {
			distanceFromCycleLine[nonCycleStation] = getDistance(nonCycleStation);
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(distanceFromCycleLine[i] + " ");
		}
	}

	static class Node {
		private int v;
		private int distance;

		public Node(int v, int distance) {
			this.v = v;
			this.distance = distance;
		}
	}
	private static int getDistance(Integer nonCycleStation) {
		LinkedList<Node> q = new LinkedList<>();
		boolean[] v = new boolean[n + 1];
		q.offer(new Node(nonCycleStation, 0));
		v[nonCycleStation] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cycleStations.contains(cur.v)) {
				return cur.distance;
			}

			for (Integer next : edges[cur.v]) {
				if (v[next])
					continue;
				v[next] = true;
				q.offer(new Node(next, cur.distance + 1));
			}
		}

		return -1;
	}

	// 순환선
	// 어떤 점이 순환선인지 알수 없다.
	// 그러면 하나의 순환선만 찾으면 알 수 있는거 아닌가?
	static boolean isFoundCycleStations = false;
	static boolean[] isVisited;
	static Set<Integer> cycleStations;

	private static void searchCycle() {
		isVisited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			isVisited[i] = true;
			findCycle(i, i, 0);
			isVisited[i] = false;
		}
	}

	private static void findCycle(int start, int current, int depth) {
		if (isFoundCycleStations) {
			return;
		}

		if (depth >= 2 && start == current) {
			cycleStations = IntStream.rangeClosed(1, n)
					.filter(id -> isVisited[id])
					.boxed()
					.collect(Collectors.toSet());
			isFoundCycleStations = true;
			return;
		}


		for (Integer next : edges[current]) {
			if (isVisited[start] && next == start && depth>=2) {
				findCycle(start, next, depth);
			}

			if (isVisited[next]) {
				continue;
			}

			isVisited[next] = true;
			findCycle(start, next, depth + 1);
			isVisited[next] = false;
		}

	}
}
