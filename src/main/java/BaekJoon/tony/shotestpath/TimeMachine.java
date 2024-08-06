package BaekJoon.tony.shotestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class TimeMachine {
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	static class Path {
		private int next;
		private long weight;

		public Path(int next, long weight) {
			this.next = next;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return new StringJoiner(", ", Path.class.getSimpleName() + "[", "]")
				.add("next=" + next)
				.add("weight=" + weight)
				.toString();
		}
	}

	/**
	 * 발만포드 알고리즘 시간 복잡도 o(정점의 개수 * 간선의 개수)
	 *
	 */
	static long[] dists;
	private static final int INF = (int)1e9;

	public static void main(String[] args) {
		st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Path>[] paths = new List[n + 1];

		dists = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			paths[i] = new ArrayList<>();
			dists[i] = INF;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(sc.nextLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			paths[from].add(new Path(to, weight));
		}

		boolean inf = isInf(n, paths);
		if (inf) {
			System.out.println("-1");
		} else {
			long[] copied = Arrays.copyOfRange(dists, 2, dists.length);
			Arrays.stream(copied).map(answer -> {
				if (answer == INF) {
					return -1;
				} else {
					return answer;
				}
			}).forEach(System.out::println);
		}
	}

	private static boolean isInf(int n, List<Path>[] paths) {
		dists[1] = 0;
		boolean isUpdate = false;
		System.out.println("init >> dist >>" + Arrays.toString(dists));
		for (int i = 1; i <= n; i++) {
			isUpdate = false;
			System.out.println(String.format("i -> %d", i));
			for (int j = 1; j <= n; j++) {
				System.out.println(String.format("	j -> %d", j));
				for (Path path : paths[j]) {
					System.out.println(String.format("     arr[ %d ]  ===> %s", j, path));
					if (dists[j] == INF) {
						break;
					}

					if (dists[path.next] > dists[j] + path.weight) {
						dists[path.next] = dists[j] + path.weight;
						isUpdate = true;
					}
				}

				System.out.println("dist->" + Arrays.toString(dists));
			}

			if (!isUpdate) {
				break;
			}
		}
		// 어차피 -값이 끼면 계속 업데이트 되니 v*e 만큰 돌고 마지막으로 한번더 돌다가 또 갱신되면 음수 사이클 확정이다.
		if (isUpdate) {
			for (int i = 1; i <= n; i++) {
				for (Path path : paths[i]) {
					if (dists[i] == INF) {
						break;
					}

					if (dists[path.next] > dists[i] + path.weight) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
