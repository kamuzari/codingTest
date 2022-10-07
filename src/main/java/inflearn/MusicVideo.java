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

		int left = Arrays.stream(dvds).max().orElseGet(() -> 0);
		int right = Arrays.stream(dvds).sum();
		int answer = 0;

		while (left <= right) {
			int promising = (left + right) >> 1;

			if (getGroup(dvds, promising) <= m) {
				answer = promising;
				right = promising - 1;
			} else {
				left = promising + 1;
			}
		}

		System.out.println(answer);

	}

	private static int getGroup(int[] dvds, int promising) {
		int group = 1;
		int sum = 0;

		for (int dvd : dvds) {
			if (sum + dvd <= promising) {
				sum += dvd;
			} else {
				group++;
				sum = dvd;
			}
		}

		return group;
	}
}


