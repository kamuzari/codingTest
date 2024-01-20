package saffy.a형기출문제집;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GaryMandering {
	static int n;
	static int[] peoples;
	static List<Integer> adj[];
	static Set<Integer> districts;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		requestInput();

		divideDistrict(0, 1);
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	private static void requestInput() {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		peoples = new int[n + 1];

		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 1; i <= n; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());
		}

		adj = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		districts = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(sc.nextLine());
			int count = Integer.parseInt(st.nextToken());

			for (int j = 0; j < count; j++) {
				int next = Integer.parseInt(st.nextToken());
				adj[i].add(next);
			}
		}
	}

	static void divideDistrict(int cnt, int idx) {
		if (cnt == n) {
			return;
		}

		if (cnt >= 1) {
			calculate();
		}

		for (int district = idx; district <= n; district++) {
			districts.add(district);
			divideDistrict(cnt + 1, district + 1);
			districts.remove(district);
		}
	}

	static void calculate() {
		if (!isNear(districts)) {
			return;
		}

		Set<Integer> otherDistricts = IntStream.rangeClosed(1, n)
				.filter(district -> !districts.contains(district))
				.boxed()
				.collect(Collectors.toSet());

		if (!isNear(otherDistricts)) {
			return;
		}

		int aTotalPeople = districts.stream()
				.map(a -> peoples[a])
				.mapToInt(a -> a)
				.sum();

		int bTotalPeople = otherDistricts.stream()
				.map(a -> peoples[a])
				.mapToInt(a -> a)
				.sum();

		int difference = Math.abs(aTotalPeople - bTotalPeople);
		answer = Math.min(answer, difference);
	}

	private static boolean isNear(Set<Integer> districts) {
		boolean[] v = new boolean[n + 1];
		List<Integer> regions = districts.stream().collect(Collectors.toList());
		Integer district = regions.get(0);

		LinkedList<Integer> q = new LinkedList<>();
		v[district] = true;
		q.offer(district);

		int connectedCount = 1;
		while (!q.isEmpty()) {
			Integer cur = q.poll();
			for (Integer next : adj[cur]) {
				if (v[next])
					continue;
				if (!districts.contains(next))
					continue;

				v[next] = true;
				connectedCount++;
				q.offer(next);
			}
		}

		return connectedCount == districts.size();
	}
}
