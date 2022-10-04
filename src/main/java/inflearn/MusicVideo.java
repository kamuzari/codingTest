package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MusicVideo {
	/**
	 * note: 수용공간을 탐색하여
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(reader.readLine());
		int[] dvds = new int[n];

		for (int i = 0; i < n; i++) {
			dvds[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(dvds);
		int answer = 0;
		int minCapacity = Arrays.stream(dvds).max().orElseGet(() -> 0);
		int maxCapacity = Arrays.stream(dvds).sum();

		while (minCapacity <= maxCapacity) {
			int promisingCapacity = (minCapacity + maxCapacity) >> 1;

			int predication = predicate(dvds, promisingCapacity);
			if (predication <= m) {
				answer = promisingCapacity;
				maxCapacity = promisingCapacity - 1;
			} else {
				minCapacity = promisingCapacity + 1;
			}
		}

		System.out.println(answer);
	}

	private static int predicate(int[] dvds, int promisingCapacity) {
		int group = 1;
		int sum = 0;
		for (int dvd : dvds) {
			if (sum + dvd > promisingCapacity) {
				group++;
				sum = dvd;
			} else {
				sum += dvd;
			}
		}

		return group;
	}
}

/**
6 5 8 5 6 8 7 6 6 7
5 5 6 6 6 6 7 7 8 8
 */
