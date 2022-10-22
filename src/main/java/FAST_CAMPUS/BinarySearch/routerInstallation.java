package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class routerInstallation {
	/**
	 * note:
	 *  1. 16% fail
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int installCondition = Integer.parseInt(st.nextToken());

		int[] houses = new int[n];
		for (int i = 0; i < n; i++) {
			houses[i] = Integer.parseInt(reader.readLine());
		}

		Arrays.sort(houses);

		int answer = 0;
		int l = 0;
		int r = 1_000_000_000;

		while (l <= r) {
			int between = (l + r) >> 1;

			int installation = getInstallation(houses, between);

			if (installation >= installCondition) {
				answer = Math.max(answer, between);
				l = between + 1;
			} else if (installation < installCondition) {
				r = between - 1;
			}
		}

		System.out.println(answer);
	}

	private static int getInstallation(int[] houses, int between) {
		int installPosition = houses[0];
		int installation = 1;

		for (int i = 1; i < houses.length; i++) {
			int nextPosition = houses[i];
			if (nextPosition - installPosition >= between) {
				installation++;
				installPosition = nextPosition;
			}
		}

		return installation;
	}
}
