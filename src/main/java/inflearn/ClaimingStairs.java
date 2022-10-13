package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClaimingStairs {
	private static final int MAX_STAIRS = 36;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		int[] stairs = new int[MAX_STAIRS];

		stairs[1] = 1;
		stairs[2] = 2;

		for (int i = 3; i <= n; i++) {
			stairs[i] = stairs[i - 2] + stairs[i - 1];
		}

		System.out.println(stairs[n]);
	}
}
