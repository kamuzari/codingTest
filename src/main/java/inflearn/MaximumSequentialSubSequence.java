package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSequentialSubSequence {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(reader.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int answer = 0;
		int zero = 0;

		while (end < n) {
			if (zero == limit && arr[end] == 0) {
				answer = Math.max(answer, end - start);
				zero = 0;
				end = ++start;
			}

			if (arr[end] == 0) {
				zero++;
				end++;
			} else {
				end++;
			}
		}

		System.out.println(answer);
	}
}
