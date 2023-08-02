package BaekJoon._자료구조구현.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heap {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Heap heap = new Heap(new Integer[100_001]);
		int n = Integer.parseInt(reader.readLine());

		StringBuilder answer = new StringBuilder();
		while (n-- > 0) {
			int cmd = Integer.parseInt(reader.readLine());

			if (cmd == 0) {
				try {
					answer.append(heap.pop()).append("\n");
				} catch (RuntimeException e) {
					answer.append("0").append("\n");
				}
			} else {
				int data = cmd;
				heap.add(data);
			}
		}
		System.out.println(answer);
	}

	int pointer = 1;
	Integer[] arr;

	public Heap(Integer[] heap) {
		this.arr = heap;
	}

	public void add(int data) {
		arr[pointer++] = data;

		if (pointer == 2) {
			return;
		}

		heapifyUp(pointer - 1);
	}

	public void heapifyUp(int index) {
		while (true) {
			if (index == 1) {
				break;
			}

			int parent = index / 2;

			if (arr[parent] > arr[index]) {
				swap(parent, index);
				index = parent;
			}else{
				break;
			}

		}
	}

	private void swap(int i, int j) {
		int temp = this.arr[i];
		this.arr[i] = this.arr[j];
		this.arr[j] = temp;
	}

	private int pop() {
		if (pointer == 1) {
			throw new RuntimeException("not found resouseces");
		}

		pointer--;
		Integer deletingData = arr[1];
		swap(1, pointer);
		arr[pointer] = null;

		heapifyDown(1);
		return deletingData;
	}

	public void heapifyDown(int index) {
		int candidate = index;
		int left = index * 2;
		int right = left + 1;

		boolean isInRangeByLeft = left < pointer;
		boolean isInRangeByRight = right < pointer;
		if (isInRangeByLeft && arr[left] < arr[candidate]) {
			candidate = left;
		}

		if (isInRangeByRight && arr[right] < arr[candidate]) {
			candidate = right;
		}

		if (candidate != index) {
			swap(index, candidate);
			heapifyDown(candidate);
		}
	}

}
