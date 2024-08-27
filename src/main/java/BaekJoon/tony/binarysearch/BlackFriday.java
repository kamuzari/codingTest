package BaekJoon.tony.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BlackFriday {

	static int n, c;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] == c) {
				System.out.println(1);
				return;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] + arr[j] == c) {
					System.out.println(1);
					return;
				}
			}
		}

		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int nextStart = j + 1;
				int need = c - (arr[j] + arr[i]);

				if (search(arr, need, nextStart)) {
					System.out.println(1);
					return;
				}
			}
		}

		System.out.println(0);
	}

	private static boolean search(int[] arr, int target, int start) {
		int s = start;
		int e = arr.length - 1;
		while (s <= e) {
			int mid = (s + e) >> 1;

			if (target < arr[mid]) {
				e = mid - 1;
			} else if (target == arr[mid]) {
				return true;
			} else {
				s = mid + 1;
			}
		}

		return false;
	}

}
