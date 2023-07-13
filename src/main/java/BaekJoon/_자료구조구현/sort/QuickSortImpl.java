package BaekJoon._자료구조구현.sort;

public class QuickSortImpl implements CustomSortable {
	@Override
	public void sort(int[] arr) {
		quicksortByLeftPivot(arr, 0, arr.length - 1);
	}


	public void quicksortByLeftPivot(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}

		int pivot = start;
		int low = start + 1;
		int high = end;

		// 피벗을 제외한 처음과 끝에서 포인터 두개를 가지고 이동
		// 왼쪽 시작 포인터는 피벗보다 큰 것을 선택
		// 오른쪽 시작 포인터는 피벗보다 작은 것을 선택
		while (low <= high) {
			while (low <= end && arr[low] <= arr[pivot]) {
				low++;
			}

			while (high > start && arr[high] >= arr[pivot]) {
				high--;
			}

			if (low > high) {
				swap(arr, pivot, high);
			} else {
				swap(arr, low, high);
			}
		}

		quicksortByLeftPivot(arr, start, high - 1);
		quicksortByLeftPivot(arr, high + 1, end);
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
