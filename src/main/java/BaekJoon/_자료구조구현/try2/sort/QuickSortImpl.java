package BaekJoon._자료구조구현.try2.sort;

import java.util.Arrays;

public class QuickSortImpl {
	public static void main(String[] args) {
		QuickSortImpl quickSort = new QuickSortImpl();
		int arr[] = {10, 2, 44, 3, 1};
		quickSort.quickSort(0, arr.length - 1, arr);

		System.out.println(Arrays.toString(arr));
	}

	public void quickSort(int start, int end, int[] arr) {

		if(start<end){
			// int pivot = getPivotByLeft(start, end, arr);
			int pivot = getPivotByRight(start, end, arr);
			quickSort(start, pivot - 1, arr);
			quickSort(pivot + 1, end, arr);
		}
	}

	private int getPivotByLeft(int start, int end, int[] arr) {
		int pivotIndex = start;
		int left = start + 1;
		int right = end;

		while (left <= right) {
			while (left <= end && arr[left] < arr[pivotIndex]) {
				left++;
			}

			while (right > start && arr[right] > arr[pivotIndex]) {
				right--;
			}

			if (left > right) {
				swap(arr, right, pivotIndex);
			} else {
				swap(arr, left, right);
			}
		}

		return right;
	}
	private int getPivotByRight(int start,int end,int[] arr){
		int pivotIndex = end;
		int left = start ;
		int right = end-1;

		while (left <= right) {
			while (left < end && arr[left] < arr[pivotIndex]) {
				left++;
			}

			while (right >= start && arr[right] > arr[pivotIndex]) {
				right--;
			}

			if (left > right) {
				swap(arr, left, pivotIndex);
			} else {
				swap(arr, left, right);
			}
		}

		return left;
	}

	private void swap(int[] arr, int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
}
