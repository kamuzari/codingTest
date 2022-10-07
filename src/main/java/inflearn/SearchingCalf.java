package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SearchingCalf {
	private static final int MAX_DISTANCE = 100_001;
	private static int dx[] = {-1, 1, 5};

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int dists[] = new int[MAX_DISTANCE];
		LinkedList<Integer> q = new LinkedList<>();

		q.offer(start);
		dists[start] = 0;

		while (!q.isEmpty()) {
			Integer currentPosition = q.poll();

			if (currentPosition == target) {
				break;
			}

			for (int i = 0; i < 3; i++) {
				int newPosition = currentPosition + dx[i];

				if (isOutOfIndex(newPosition))
					continue;

				if (dists[newPosition] != 0)
					continue;

				q.offer(newPosition);
				dists[newPosition] = dists[currentPosition] + 1;
			}
		}

		System.out.println(dists[target]);
	}

	private static boolean isOutOfIndex(int nx) {
		return nx < 0 || nx >= MAX_DISTANCE;
	}
}
