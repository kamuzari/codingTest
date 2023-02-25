package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;

public class TranslateNumber {
	static final int LIMIT = 1_000_001;

	public int solution(int x, int y, int n) {
		int[] d = new int[] {2, 3, n};
		int dist[] = new int[LIMIT];
		Arrays.fill(dist, LIMIT);
		dist[x] = 0;

		LinkedList<Integer> q = new LinkedList<>();
		q.offer(x);

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == y) {
				return dist[cur];
			}

			for (int i = 0; i < 3; i++) {
				int next = 0;
				if (i == 2) {
					next = d[i] + cur;
				} else {
					next = d[i] * cur;
				}

				if (next >= LIMIT || next > y)
					continue;
				if (dist[next] <= dist[cur] + 1)
					continue;

				dist[next] = dist[cur] + 1;
				q.offer(next);
			}
		}

		return -1;
	}
}
