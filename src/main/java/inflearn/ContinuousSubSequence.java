package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSubSequence {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(reader.readLine());
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = 0;

		while (true) {
			if (end > n - 1)
				break;

			if (sum < target) {
				sum += arr[end++];
			} else if (sum > target) {
				sum -= arr[start++];
			}

			/**
			 * note : point 경계값 버그
			 */

			if (sum == target) {
				sum -= arr[start++];
				answer++;
			}
		}

		System.out.println(answer);
	}
	/**
	 *  bug : 반례
	 *  6 6
	 *  1 1 1 1 1 1
	 *  note : 값을 모두 더하고 나서 if문으로 다시 돌아와서 목표값이 맞음에도 불구하고 반복문을 탈출함..
	 */
}
