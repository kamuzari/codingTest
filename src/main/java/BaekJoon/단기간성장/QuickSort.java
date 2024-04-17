package BaekJoon.단기간성장;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuickSort {
	static Scanner sc = new Scanner(System.in);

	/**
	 7
	 5 3 8 9 2 4 7
	 * @param args
	 */

	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}

		// quickSortByMiddlePivot(0, arr.length - 1, arr);
		quickSortByFirstPivot(0, arr.length - 1, arr);
		// quickSortByRightPivot(0, arr.length - 1, arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void quickSortByRightPivot(int s, int e, int[] arr) {
		if (s >= e)
			return;

		int pivotIndex = e;
		int l = s;
		int r = e - 1;

		while (l <= r) {
			while (l < e && arr[l] < arr[pivotIndex]) {
				l++;
			}

			while (r >= s && arr[r] > arr[pivotIndex]) {
				r--;
			}

			if (l < r) {
				swap(arr, l, r);
			} else {
				swap(arr, l, pivotIndex);
			}
		}

		quickSortByRightPivot(s, l - 1, arr);
		quickSortByRightPivot(l + 1, e, arr);
	}

	public static void quickSortByFirstPivot(int s, int e, int[] arr) {
		if (s >= e)
			return;

		int pivotIdx = s;
		int l = s + 1;
		int r = e;

		while (l <= r) {
			while (l <= e && arr[l] < arr[pivotIdx]) {
				l++;
			}

			while (r > s && arr[r] > arr[pivotIdx]) {
				r--;
			}

			if (l < r) {
				swap(arr, l, r);
			} else {
				swap(arr, r, pivotIdx);
			}
		}

		quickSortByFirstPivot(s, r - 1, arr);
		quickSortByFirstPivot(r + 1, e, arr);
	}

	public static void quickSortByMiddlePivot(int s, int e, int[] arr) {
		if (s >= e) {
			return;
		}

		int pivot = arr[(s + e) >> 1];
		int l = s;
		int r = e;

		while (l <= r) {
			while (arr[l] < pivot) {
				l++;
			}

			while (arr[r] > pivot) {
				r--;
			}

			if (l <= r) {
				swap(arr, l, r);
				l++;
				r--;
			}
		}

		quickSortByMiddlePivot(s, l - 1, arr);
		quickSortByMiddlePivot(l, e, arr);
	}

	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
