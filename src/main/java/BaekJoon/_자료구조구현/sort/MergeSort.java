package BaekJoon._자료구조구현.sort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		int[] input1 = {5, 4, 3, 2, 1};
		// sort.divide(input1, 0, 5);


		CustomSortable sortable=new MergeSortImpl();

		sortable.sort(input1);
		System.out.println(Arrays.toString(input1));
	}

	static final int CAPACITY = 1_000_000;
	static final int INF = (int)1e9;
	static int[] L = new int[CAPACITY], R = new int[CAPACITY];
	static int cnt = 0;

	public void divide(int arr[], int first, int end) {
		if (first + 1 < end) {
			int mid = first + end >> 1;
			divide(arr, first, mid);
			divide(arr, mid, end);
			merge(arr, first, mid, end);
		}
	}

	public void merge(int[] arr, int first, int mid, int end) {
		int n1 = mid - first;
		for (int i = 0; i < n1; i++) {
			L[i] = arr[first + i];
		}

		int n2 = end - mid;
		for (int i = 0; i < n2; i++) {
			R[i] = arr[mid + i];
		}

		L[n1] = R[n2] = INF; // 맨끝임을 표시하기 위한 방법
		int leftIndex = 0, rightIndex = 0;

		for (int k = first; k < end; k++) {
			cnt++;
			if (L[leftIndex] <= R[rightIndex]) {
				arr[k] = L[leftIndex++];
			} else {
				arr[k] = R[rightIndex++];
			}
		}

	}

}
