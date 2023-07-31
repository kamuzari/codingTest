package BaekJoon._자료구조구현.try2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HeapImplementation {
	/**
	 * note:
	 *   힙 자료구조는 트리의 한 종류중 완전이진트리로 우선순위를 위한 자료구조입니다.
	 *   부모노드는 항상 자식보다 우선순위를 갖는 구조로 이루어져 삽입 삭제시 log(n)이 보장됩니다.
	 */

	static class Heap {
		private static final int INIT_SIZE = 10;
		private Integer[] arr;
		private int pointer;

		public Heap() {
			this.arr = new Integer[100_001];
			this.pointer = 1;
		}

		public void add(int data) {
			if (pointer >= this.arr.length) {
				expandArray();
			}

			arr[pointer++] = data;

			if (pointer == 2) {
				return;
			}

			adjustPriorityByAdding();
		}

		public int pop() {
			if (pointer == 1) {
				throw new RuntimeException("not found data..");
			}

			/**
			 * 1. 루트 맨끝 노드와 교환한다.
			 * 2. 맨끝 노드데이터를 변수에 저장하고 맨끝 노드를 null로 초기화한다.
			 * 3. root 서부터 히피포이알고리즘을 적절한 위치로 조정한다.
			 */
			pointer -= 1;
			swap(1, pointer);
			int result = arr[pointer];
			arr[pointer] = null;

			if (pointer == 2) {
				return result;
			}

			adjustPriorityByPopping();

			return result;
		}

		public boolean isEmpty() {
			return this.pointer == 1;
		}

		private void adjustPriorityByPopping() {

			int current = 1;
			while (true) {

				int left = current * 2;
				int right = current * 2 + 1;
				if (left < pointer && right < pointer) {
					if (arr[left] < arr[right]) {
						swap(left, current);
						current = left;
					} else {
						swap(right, current);
						current = right;
					}
				} else if (left < pointer && arr[left] < arr[current]) {
					swap(left, current);
					current = left;
				} else if (right < pointer && arr[right] > arr[current]) {
					swap(right, current);
					current = right;
				} else {
					break;
				}
			}

		}

		private void adjustPriorityByAdding() {
			int current = this.pointer - 1;

			while (true) {
				if (current == 1) {
					break;
				}

				int parent = current / 2;

				if (arr[parent] > arr[current]) {
					swap(parent, current);
				} else {
					break;
				}

				current = parent;
			}
		}

		private void swap(int idx1, int idx2) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}

		private void expandArray() {
			int currentSize = this.arr.length;
			this.arr = Arrays.copyOf(arr, currentSize * 2);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		Heap heap = new Heap();
		StringBuilder answer = new StringBuilder();
		while (n-- > 0) {
			int input = Integer.parseInt(reader.readLine());

			if (input == 0) {
				if (heap.isEmpty()) {
					answer.append("0");
				} else {
					int poppedData = heap.pop();
					answer.append(poppedData);
				}
				answer.append("\n");
			} else {
				heap.add(input);
			}
		}
		System.out.println(answer);
	}

}
