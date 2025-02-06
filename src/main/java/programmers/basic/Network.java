package programmers.basic;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Network {
	int[] parents;

	public int solution(int n, int[][] computers) {
		int answer = 0;
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 0) {
					continue;
				}

				union(i, j);
			}
		}

		IntStream.range(0, n).forEach(this::find);

		return Arrays.stream(parents).boxed()
			.collect(Collectors.toSet())
			.size();
	}

	void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parents[b] = a;
		} else if (a > b) {
			parents[a] = b;
		}
	}

	int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}
}
