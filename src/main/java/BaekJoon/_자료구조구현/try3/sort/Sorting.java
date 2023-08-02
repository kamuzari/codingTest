package BaekJoon._자료구조구현.try3.sort;

import java.util.Arrays;

public class Sorting {
	public static void main(String[] args) {
		Sortable sortables = new QuickStrategy();
		int arr[] = {10, 2, 44, 3, 1};
		sortables.sort(arr);
		System.out.println(Arrays.toString(arr));

	}
}

interface Sortable {
	public void sort(int[] arr);
}

class MergeStrategy implements Sortable {
	static int L[] = new int[100_000_000];
	static int R[] = new int[100_000_000];

	@Override
	public void sort(int[] arr) {
		mergeSort(0, arr.length, arr);
	}

	private void mergeSort(int start, int end, int[] arr) {
		if (start + 1 < end) {
			int mid = (start + end) >> 1;

			mergeSort(start, mid, arr);
			mergeSort(mid, end, arr);
			compact(start, mid, end, arr);
		}
	}

	private void compact(int start, int mid, int end, int[] arr) {
		int n1 = mid - start;

		for (int i = 0; i < n1; i++) {
			L[i] = arr[start + i];
		}

		int n2 = end - mid;
		for (int i = 0; i < n2; i++) {
			R[i] = arr[mid + i];
		}

		L[n1] = R[n2] = (int)1e9;
		int left = 0;
		int right = 0;

		for (int i = start; i < end; i++) {
			if (L[left] < R[right]) {
				arr[i] = L[left++];
			} else {
				arr[i] = R[right++];
			}
		}
	}

}

class QuickStrategy implements Sortable {

	@Override
	public void sort(int[] arr) {
		partition(0, arr.length - 1, arr);
	}

	private void partition(int start, int end, int[] arr) {
		if (start < end) {
			int pivot = getPivotByLeft(start, end, arr);
			partition(start, pivot - 1, arr);
			partition(pivot + 1, end, arr);
		}
	}

	private int getPivotByLeft(int start, int end, int[] arr) {
		int pivot = start;
		int left = start + 1;
		int right = end;

		while (left <= right) {
			while (left <= end && arr[left] < arr[pivot]) {
				left++;
			}

			while (right > start && arr[right] > arr[pivot]) {
				right--;
			}

			if (left > right) {
				swap(right, pivot, arr);
			} else {
				swap(left, right, arr);
			}

		}
		return right;
	}

	private void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
