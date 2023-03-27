package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class HoSeokTwoChicken {
	static final int INF = (int)1e9;
	static int n, m;
	static int[] picks = new int[2];
	private static int[][] edges;
	static int roundTripAnswer = INF;
	static int[] chickensAnswer;

	/**
	 * 모든 건물에서 접근성이 가장 좋은 치킨집 2곳을 선정하고 거리를 측정하라
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		edges = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(edges[i], INF);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			edges[v1][v2] = 1;
			edges[v2][v1] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
				}
			}
		}

		pick(0, 1);

		String chickenPositions = Arrays.stream(chickensAnswer)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));

		System.out.println(chickenPositions + " " + roundTripAnswer);
	}

	// 2개의 치킨집 뽑기
	public static void pick(int cnt, int start) {
		if (cnt == 2) {
			// 거리 총합
			Set<Integer> chickens = Arrays.stream(picks).boxed().collect(Collectors.toSet());
			Map<Integer, Integer> minDists = new HashMap<>(); // 치킨집 2곳 으로부터 최소 거리가 담겨있음.
			calculateDist(chickens, minDists);

			int roundTrip = minDists.values().stream().reduce(0, Integer::sum) * 2; // 거리별 왕복 비용 계산

			if (roundTrip < roundTripAnswer) {
				roundTripAnswer = roundTrip;
				chickensAnswer = picks.clone();
			}

			return;
		}

		for (int i = start; i <= n; i++) {
			picks[cnt] = i;
			pick(cnt + 1, i + 1);
		}
	}
	// 선정된 치킨집으로부터 최소 거리 판별
	private static void calculateDist(Set<Integer> chickens, Map<Integer, Integer> minDists) {
		for (int i = 0; i < picks.length; i++) {
			int chickenPosition = picks[i];

			for (int j = 1; j <= n; j++) {
				int destination = j;

				if (chickens.contains(destination)) // 현재 위치가 치킨집이라면 안됨
					continue;

				int dist = edges[chickenPosition][destination];

				if (!minDists.containsKey(destination)) {
					minDists.put(destination, dist);
				} else {
					if (minDists.get(destination) > dist) { // 더 짧은 거리면 교체
						minDists.put(destination, dist);
					}
				}
			}
		}
	}
}
