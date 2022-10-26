package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfK {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int k = Integer.parseInt(reader.readLine());

		long answer=0;
		long l = 0;
		long r = Long.MAX_VALUE;

		while (l < r) {
			long mid = (l + r) >> 1;

			long numberLowerThanMid = 0;
			for (int i = 1; i <= n; i++) {
				numberLowerThanMid += Math.min(mid / i, n);
			}

			if (numberLowerThanMid >= k) {
				answer = mid;
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		System.out.println(answer);
	}
}
