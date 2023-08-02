package BaekJoon._자료구조구현.try3.tree;

public class Heap {
	private Integer[] arr = new Integer[100_000_000];
	int size = 1;

	public Heap() {
	}

	public void add(int data) {
		arr[size++] = data;

		if (size == 2) {
			return;
		}

		heapifyUp(size);
	}

	private void heapifyUp(int size) {
		int current = size - 1;

		while (true) {
			if (current == 1)
				break;

			int parent = current / 2;

			if (arr[parent] > arr[current]) {
				swap(parent, current);
				current = parent;
			} else {
				break;
			}
		}
	}

	public void remove(int data) {
		if (size == 1) {
			throw new RuntimeException("not exist data..");
		}

		int result = arr[1];
		size--;
		swap(1, size);
		arr[size] = null;

		heapifyDown(1);
	}

	public void heapifyDown(int current) {
		int left = current * 2;
		int right = left + 1;

		int candidate = current;

		if (left < size && arr[left] < arr[candidate]) {
			candidate = left;
		}

		if (right < size && arr[right] < arr[candidate]) {
			candidate = right;
		}

		if (candidate != current) {
			swap(candidate, current);
			heapifyDown(candidate);
		}
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
