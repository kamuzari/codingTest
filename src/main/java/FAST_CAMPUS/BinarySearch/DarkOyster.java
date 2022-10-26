package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DarkOyster {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());

		int[] lamps = new int[m];

		StringTokenizer st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < m; i++) {
			lamps[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 100_000;
		int l = 0;
		int r = 100_000;

		while (l <= r) {
			int height = (l + r) >> 1;

			if (isPossibleCovered(lamps, height, n)) {
				answer = Math.min(answer, height);
				r = height - 1;
			} else {
				l = height + 1;
			}
		}

		System.out.println(answer);

	}

	/**
	 * how: 어떻게 가시거리를 측정해야 할까?
	 *   - 왼쪽 가시거리가 overlapping 되는지 여부로 판단
	 *   - 예외가 존재하는데 길이가 5인데 가로수가 0에 하나이면 가시거리가 5까지 비쳐지는지도 마지막으로 체크해야 한다.
	 */
	private static boolean isPossibleCovered(int[] lamps, int height, int n) {
		int lastPoint = 0;

		for (int lamp : lamps) {
			int left = lamp - height;
			int right = lamp + height;

			if (lastPoint < left) {
				return false;
			}

			lastPoint = right;
		}

		return n <= lastPoint;
	}
}
