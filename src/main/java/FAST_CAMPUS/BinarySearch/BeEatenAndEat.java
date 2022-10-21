package FAST_CAMPUS.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeEatenAndEat {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		for (int sequence = 0; sequence < testCase; sequence++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int a[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			int b[] = new int[m];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(a);
			Arrays.sort(b);
			int result = 0;

			for (int i = 0; i < m; i++) {
				int endIdx = searchByBinary(a, b[i]);
				int upper = n - endIdx;

				result += upper;
			}

			answer.append(result).append("\n");
		}

		System.out.println(answer);
	}

	private static int searchByBinary(int[] targets, int value) {
		int s = 0;
		int e = targets.length;

		while (s < e) {
			int mid = (s + e) >> 1;

			if (targets[mid] > value) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}

		return e;
	}
}
