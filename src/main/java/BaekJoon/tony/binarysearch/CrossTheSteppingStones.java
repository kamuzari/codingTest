package BaekJoon.tony.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CrossTheSteppingStones {
	/**
	 * todo:
	 *  - 왼쪽에서 오른쪽으로 가는데 한번에 점프할 수 있는가?
	 *  -
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long s = 0;
		long e = 5_000_000_000L;
		long answer = Long.MAX_VALUE;
		while (s <= e) {
			long mid = (s + e) >> 1;
			long requiredMinimumPower = mid;

			if (reachable(n, arr, requiredMinimumPower)) {
				answer = Math.min(answer, requiredMinimumPower);
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		System.out.println(answer);
	}

	private static boolean reachable(int n, int[] arr, long requiredPower) {
		int pivot = 0;

		while (pivot < n) {

			int nextIdx = -1;
			for (int j = pivot + 1; j < n; j++) {
				long result = calculate(pivot, j, arr);
				if (result <= requiredPower) {
					nextIdx = j;
					break;
				}
			}

			if (nextIdx == n - 1) {
				return true;
			}

			if (nextIdx == -1) {
				return false;
			}

			pivot = nextIdx;
		}

		return true;
	}

	static long calculate(int i, int j, int[] arr) {
		long answer = (long)(j - i) * (1L + Math.abs(arr[i] - arr[j]));

		return answer;
	}
}
