package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WeirdPub {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] alcohols = new int[n];

		for (int i = 0; i < n; i++) {
			alcohols[i] = Integer.parseInt(reader.readLine());
		}

		long answer = 0;
		long left = 0;
		long right = Long.MAX_VALUE;

		while (left <= right) {
			long amount = (left + right) >> 1;

			int division = divide(amount, alcohols);

			if (division >= k) {
				answer = amount;
				left = amount + 1;
			} else {
				right = amount - 1;
			}
		}

		System.out.println(answer);
	}

	private static int divide(long division, int[] alcohols) {
		int count = 0;
		int[] copies = alcohols.clone();

		for (int i = 0; i < copies.length; ) {
			int alchol = copies[i];

			if (alchol >= division) {
				copies[i] -= division;
				count++;
			} else {
				i++;
			}
		}

		return count;
	}
}
