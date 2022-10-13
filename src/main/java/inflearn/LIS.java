package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int[] numbers = new int[n];
		int lengths[] = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(lengths, 1);

		int answer = 1;

		for (int current = 0; current < n; current++) {

			for (int previous = 0; previous < current; previous++) {
				if (numbers[previous] < numbers[current]) {
					lengths[current] = Math.max(lengths[current], lengths[previous] + 1);

					answer = Math.max(lengths[current], answer);
				}
			}
		}

		System.out.println(answer);
	}
}
