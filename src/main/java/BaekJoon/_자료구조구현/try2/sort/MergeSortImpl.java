package BaekJoon._자료구조구현.try2.sort;

import java.util.Arrays;

public class MergeSortImpl {
	static int L[] = new int[1_000_000];
	static int R[] = new int[1_000_000];

	public static void main(String[] args) {
		int arr[] = {10, 2, 44, 3, 1};
		MergeSortImpl mergeSort = new MergeSortImpl();
		mergeSort.divide(0, arr.length, arr);
		System.out.println(Arrays.toString(arr));
	}

	public void divide(int start, int end, int[] arr) {
		if (start + 1 < end) {
			int mid = (start + end) >> 1;
			divide(start, mid, arr);
			divide(mid, end, arr);
			merge(start, mid, end, arr);
		}
	}

	private void merge(int start, int mid, int end, int[] arr) {
		int n1 = mid - start;
		for (int i = 0; i < n1; i++) {
			L[i] = arr[start + i];
		}

		int n2 = end - mid;
		for (int i = 0; i < n2; i++) {
			R[i] = arr[mid + i];
		}

		L[n1] = R[n2] = (int)1e9;
		int left = 0, right = 0;

		for (int i =start; i < end; i++) {
			if (L[left] <= R[right]) {
				arr[i] = L[left++];
			} else {
				arr[i] = R[right++];
			}
		}
	}
}
