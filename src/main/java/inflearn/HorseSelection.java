package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HorseSelection {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int horse = Integer.parseInt(st.nextToken());
		int[] dists = new int[n];
		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			dists[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(dists);
		int left = 1;
		int right = dists[n - 1];
		int answer = 0;

		while (left <= right) {
			int betweenDistance = (left + right) >> 1;

			if (getHorse(dists, betweenDistance) >= horse) {
				answer = betweenDistance;
				left = betweenDistance + 1;
			} else {
				right = betweenDistance - 1;
			}
		}

		System.out.println(answer);
	}

	private static int getHorse(int[] dists, int promisingValue) {
		int settingHorse = 1;
		int endPoint = dists[0];

		for (int position : dists) {
			int betweenDistance = position - endPoint;
			if (betweenDistance >= promisingValue) {
				endPoint = position;
				settingHorse++;
			}
		}

		return settingHorse;

	}
}
