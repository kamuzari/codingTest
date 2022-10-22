package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CuttingTree {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int leastCondition = Integer.parseInt(st.nextToken());

		int[] trees = new int[n];
		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);

		long l = 0;
		long r = 2_000_000_000;
		long answer = 0;

		while (l <= r) {
			long cuttingLength = (l + r) >> 1;
			long taking = getPossibleTreeLength(cuttingLength, trees);

			if (taking >= leastCondition) {
				answer = Math.max(answer, cuttingLength);
				l = cuttingLength + 1;
			} else {
				r = cuttingLength - 1;
			}
		}

		System.out.println(answer);
	}

	private static long getPossibleTreeLength(long cuttingLength, int[] trees) {
		return Arrays.stream(trees)
			.filter(tree -> tree > cuttingLength)
			.mapToLong(tree -> tree - cuttingLength)
			.sum();
	}
}
