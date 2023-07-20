package BaekJoon._자료구조구현.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EnteranceJudge {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int judgeTimes[] = new int[n];
		for (int i = 0; i < n; i++) {
			judgeTimes[i] = Integer.parseInt(reader.readLine());
		}

		Arrays.sort(judgeTimes);

		long answer = getMinimumProcess(n, m, judgeTimes);
		System.out.println(answer);
	}

	private static long getMinimumProcess(int n, int m, int[] judgeTimes) {
		long minimumTime = Long.MAX_VALUE;

		long start = 0;
		long end = Long.MAX_VALUE - 1;

		while (start <= end) {
			long mid = (start + end) >> 1;

			long limitTime = mid;
			long passPassenger = getPassPassenger(n, judgeTimes, limitTime, m);

			if (passPassenger >= m) {
				end = mid - 1;
				minimumTime = Math.min(minimumTime, mid);
			} else {
				start = mid + 1;
			}
		}

		return minimumTime;
	}

	private static long getPassPassenger(int n, int[] judgeTimes, long limitTime, int requirement) {
		long passPassenger = 0;

		for (int i = 0; i < n; i++) {
			long passenger = limitTime / judgeTimes[i];
			passPassenger += passenger;

			if (passPassenger >= requirement) {
				break;
			}
		}

		return passPassenger;
	}
}
