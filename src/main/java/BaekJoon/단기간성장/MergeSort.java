package BaekJoon.단기간성장;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	static int left[];
	static int right[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}

		divide(0, arr.length - 1, arr);

		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void divide(int s, int e, int[] arr) {
		if (e - s < 1)
			return;
		int mid = (s + e) >> 1;
		divide(s, mid, arr);
		divide(mid + 1, e, arr);
		int[] temp = new int[e - s + 1];
		int tIdx = 0;
		int leftIdx = s;
		int rightIdx = mid + 1;

		while (leftIdx <= mid && rightIdx <= e) {
			if (arr[leftIdx] < arr[rightIdx]) {
				temp[tIdx++] = arr[leftIdx++];
			} else {
				temp[tIdx++] = arr[rightIdx++];
			}
		}

		while (leftIdx <= mid) {
			temp[tIdx++] = arr[leftIdx++];
		}

		while (rightIdx <= e) {
			temp[tIdx++] = arr[rightIdx++];
		}
		tIdx = 0;

		for (int i = s; i <= e; i++) {
			arr[i] = temp[tIdx++];
		}
	}
}
