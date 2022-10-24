package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SplitLanCable {

	private static long[] takings;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int k = Integer.parseInt(st.nextToken());
		int requirement = Integer.parseInt(st.nextToken());

		takings = new long[k];

		for (int i = 0; i < k; i++) {
			takings[i] = Long.parseLong(reader.readLine());
		}

		long answer = 0;
		long l = 0;
		long r = Long.MAX_VALUE;

		while (l <= r) {
			long split = (l + r) >> 1;

			long result = getSplit(split);

			if (requirement <= result) {
				answer = Math.max(split, answer);
				l = split + 1;
			} else {
				r = split - 1;
			}
		}

		System.out.println(answer);
	}

	private static long getSplit(long split) {
		int answer = 0;

		for (int i = 0; i < takings.length; i++) {
			answer += (takings[i] / split);
		}

		return answer;
	}
}
