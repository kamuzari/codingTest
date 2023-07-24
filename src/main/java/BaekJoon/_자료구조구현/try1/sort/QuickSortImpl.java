package BaekJoon._자료구조구현.try1.sort;

public class QuickSortImpl implements CustomSortable {
	@Override
	public void sort(int[] arr) {
		quicksortByLeftPivot(arr, 0, arr.length - 1);
	}

	public void quicksortByLeftPivot(int[] arr, int start, int end) {
		// 2개 미만인 경우는 정렬 할 필요 없음.
		if (start >= end)
			return;

		int pivot = getPivotByLeft(arr, start, end);

		getPivotByLeft(arr, start, pivot - 1);
		getPivotByLeft(arr, pivot + 1, end);
	}

	private int getPivotByLeft(int[] arr, int start, int end) {
		int pivotIndex = start;
		int lowwerInedx = start + 1;
		int higherIndex = end;

		while (lowwerInedx <= higherIndex) {
			while (lowwerInedx <= end && arr[lowwerInedx] < arr[pivotIndex]) {
				// 피벗보다 큰값찾기
				lowwerInedx++;
			}

			while (higherIndex > start && arr[higherIndex] > arr[pivotIndex]) {
				// 피벗보다 작은값찾기
				higherIndex--;
			}

			if (lowwerInedx > higherIndex) {
				swap(arr, pivotIndex, higherIndex);
			} else {
				swap(arr, lowwerInedx, higherIndex);
			}

		}

		return higherIndex;
	}

	private int getPivotByRight(int[] arr, int start, int end) {
		int pivot = end;
		int lowerIndex = start;
		int higherIndex = end - 1;

		while (lowerIndex <= higherIndex) {

			while (lowerIndex < end && arr[lowerIndex] <= arr[pivot]) {
				lowerIndex++;
			}

			while (higherIndex >= start && arr[higherIndex] >= arr[pivot]) {
				higherIndex--;
			}

			if (lowerIndex > higherIndex) {
				swap(arr, pivot, lowerIndex);
			} else {
				swap(arr, lowerIndex, higherIndex);
			}
		}

		return lowerIndex;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void quicksortByMidiumPivot(int[] arr, int start, int end) {

	}

	public void quicksortByRightPivot(int[] arr, int start, int end) {

	}
}
