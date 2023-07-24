package BaekJoon._자료구조구현.try1.sort;

public class MergeSortImpl implements CustomSortable {
	private final int CAPACITY = 1_000_000_000;
	private int[] lefts, rights;

	@Override
	public void sort(int[] arr) {
		lefts = new int[50_000_000];
		rights = new int[50_000_000];
		divide(arr, 0, arr.length);
	}

	void divide(int[] arr, int left, int right) {
		if (left + 1 < right) { // 범위가 2개 이상이라면
			int mid = (left + right) / 2;

			divide(arr, left, mid);
			divide(arr, mid, right);
			merge(arr, left, mid, right);
		}
	}

	private void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left;
		for (int i = 0; i < n1; i++) {
			lefts[i] = arr[left + i];
		}

		int n2 = right - mid;
		for (int i = 0; i < n2; i++) {
			rights[i] = arr[mid + i];
		}

		lefts[n1] = rights[n2] = Integer.MAX_VALUE;
		int leftIndex = 0, rightIndex = 0;

		for (int i = left; i < right; i++) {
			if (lefts[leftIndex] <= rights[rightIndex]) {
				arr[i] = lefts[leftIndex++];
			} else {
				arr[i] = rights[rightIndex++];
			}
		}

	}

}
