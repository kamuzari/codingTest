package BaekJoon._자료구조구현.try1.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Sortable> sortables = List.of(new SortByMerge(), new SortByQuick());

		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}

		Strategy strategy = Strategy.QUICK;
		sortables.stream()
			.filter(sortable -> sortable.getType().equals(strategy))
			.forEach(sortable -> sortable.sort(arr, SortType.ASCENDING));

		Arrays.stream(arr).forEach(System.out::println);
	}

}

enum SortType {
	ASCENDING, DESCENDING;
}

enum Strategy {
	MERGE, QUICK;
}

interface Sortable {
	int[] sort(int[] arr, SortType status);

	Strategy getType();
}

class SortByMerge implements Sortable {

	private int left[];
	private int right[];

	@Override
	public int[] sort(int[] arr, SortType status) {
		int n = arr.length;
		left = new int[n / 2 + 2];
		right = new int[n / 2 + 2];

		divide(arr, 0, n, status);
		return arr;
	}

	@Override
	public Strategy getType() {
		return Strategy.MERGE;
	}

	private void divide(int[] arr, int start, int end, SortType status) {
		if (start + 1 >= end)
			return;

		int mid = (start + end) >> 1;

		divide(arr, start, mid, status);
		divide(arr, mid, end, status);
		merge(arr, start, mid, end, status);
	}

	private void merge(int[] arr, int start, int mid, int end, SortType status) {
		int n1 = mid - start;
		for (int i = 0; i < n1; i++) {
			left[i] = arr[start + i];
		}

		int n2 = end - mid;
		for (int i = 0; i < n2; i++) {
			right[i] = arr[mid + i];
		}

		left[n1] = right[n2] = Integer.MAX_VALUE;

		int leftIndex = 0;
		int rightIndex = 0;

		if (status == SortType.ASCENDING) {
			for (int i = start; i < end; i++) {
				if (left[leftIndex] <= right[rightIndex]) {
					arr[i] = left[leftIndex++];
				} else {
					arr[i] = right[rightIndex++];
				}
			}
		} else {
			for (int i = start; i < end; i++) {
				if (left[leftIndex] >= right[rightIndex]) {
					arr[i] = left[leftIndex++];
				} else {
					arr[i] = right[rightIndex++];
				}
			}
		}

	}

}

class SortByQuick implements Sortable {

	@Override
	public int[] sort(int[] arr, SortType status) {
		partition(arr, 0, arr.length - 1, status);
		return arr;
	}

	private void partition(int[] arr, int start, int end, SortType status) {
		if (start >= end) {
			return;
		}

		// int pivot = getPivotByLeft(arr, start, end);
		int pivot = getPivotByRight(arr, start, end);

		partition(arr, start, pivot - 1, status);
		partition(arr, pivot + 1, end, status);
	}

	private int getPivotByLeft(int[] arr, int start, int end) {
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
				swap(arr, right, pivot);
			} else {
				swap(arr, left, right);
			}
		}
		return right;
	}

	private int getPivotByRight(int[] arr, int start, int end) {
		int pivot = end;
		int left = start;
		int right = end - 1;

		while (left <= right) {
			while (left < end && arr[left] < arr[pivot]) {
				left++;
			}

			while (right >= start && arr[right] > arr[pivot]) {
				right--;
			}

			if (left > right) {
				swap(arr, left, pivot);
			} else {
				swap(arr, left, right);
			}
		}

		return left;
	}

	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	@Override
	public Strategy getType() {
		return Strategy.QUICK;
	}
}
