package BaekJoon.tony.binarysearch;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CuttingTheCake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] answers = new int[n];

		int[] cuttingPoints = new int[m + 1];
		for (int i = 0; i < m; i++) {
			cuttingPoints[i] = Integer.parseInt(sc.nextLine());
		}
		cuttingPoints[m] = l;

		for (int i = 0; i < n; i++) {
			int cuttingCount = Integer.parseInt(sc.nextLine());
			int s = 0;
			int e = l;
			int result = -1;

			while (s <= e) {
				int mid = (s + e) >> 1;
				int interval = mid;

				int cnt = cuttingCount;
				int prev = 0;
				for (int j = 0; j <= m; j++) {
					int diff = cuttingPoints[j] - prev;
					if (interval <= diff) {
						prev = cuttingPoints[j];
						cnt--;
					}
				}

				if (cnt >= 0) {
					e = mid - 1;
				} else {
					s = mid + 1;
					result = Math.max(mid, result);
				}
			}

			answers[i] = result;
		}

		String answer = Arrays.stream(answers)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining("\n"));
		System.out.println(answer);
	}
}
