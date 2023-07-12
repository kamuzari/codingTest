package BaekJoon._자료구조구현;

import java.util.Arrays;
import java.util.Random;

public class HeapImpl {
	public static void main(String[] args) {
		Heap customHeap = new Heap(TYPE.MINIMUM);
		Random random = new Random();
		int[] datas = new int[] {1, 2, 3, 4, 5};
		int[] datas_reverse = new int[] {5, 4, 3, 2, 1};
		// Arrays.stream(datas).forEach(customHeap::add); // MAX_HEAP 에 삭제시 4,3,2,1
		Arrays.stream(datas_reverse).forEach(customHeap::add); // MIN_HEAP 에 순회시 1,2,4,5,3 삭제시 2,3,4,5
		customHeap.print();
		customHeap.remove();
		customHeap.print();
	}
}

class Heap {
	private static final int INIT_SIZE = 10;
	private TYPE type;
	private Integer[] datas;
	private int pointer;

	public Heap(TYPE type) {
		this.type=type;
		this.datas = new Integer[INIT_SIZE];
		this.pointer = 1;
	}

	public void add(Integer data) {
		if (pointer >= this.datas.length) {
			expand();
		}
		//1. 제일 끝 노드 추가
		datas[pointer++] = data;

		if (pointer == 2) {
			return;
		}
		//2. 위치 조정
		int curIdx = pointer - 1;

		while (true) {
			int parent = curIdx / 2;

			if (parent == 0) {
				break;
			}

			if (this.type == TYPE.MINIMUM) {
				if (datas[parent] >= datas[curIdx]) {
					swap(parent, curIdx);
					curIdx = parent;
				} else {
					break;
				}
			} else {
				if (datas[parent] <= datas[curIdx]) {
					swap(parent, curIdx);
					curIdx = parent;
				} else {
					break;
				}
			}

		}
	}

	// 루트 지우고 맨 끝 노드를 올려서 다시 조정한다.
	public Integer remove() {
		if (datas[1] == null) {
			throw new RuntimeException("존재하지 않습니다.");
		}

		Integer result = datas[1];
		datas[1] = datas[--pointer];
		datas[pointer] = null;
		int curIdx = 1;

		while (true) {
			int left = curIdx * 2;
			int right = left + 1;
			if (datas[left] == null) {
				break;
			}

			if (datas[right] == null) {
				if (this.type == TYPE.MINIMUM) {
					if (datas[left] <= datas[curIdx]) {
						swap(left, curIdx);
						curIdx = left;
					} else {
						break;
					}
				} else {
					if (datas[left] >= datas[curIdx]) {
						swap(left, curIdx);
						curIdx = left;
					} else {
						break;
					}
				}
			} else {
				// 두 차수가 존재한다면
				if (this.type == TYPE.MINIMUM) {
					int priorty = left;
					if (datas[left] > datas[right]) {
						priorty = right;
					}

					if (datas[priorty] < datas[curIdx]) {
						swap(priorty,curIdx);
						curIdx=priorty;
					}
				} else {
					int priorty = left;
					if (datas[left] < datas[right]) {
						priorty = right;
					}

					if (datas[priorty] > datas[curIdx]) {
						swap(priorty,curIdx);
						curIdx=priorty;
					}
				}

			}

		}

		return result;
	}

	public void print() {
		for (int i = 1; i < pointer; i++) {
			System.out.print(datas[i] + " ");
		}
		System.out.println();
	}

	private void expand() {
		this.datas = Arrays.copyOf(this.datas, this.datas.length * 2);
	}

	private void swap(int i, int j) {
		Integer temporary = datas[i];
		datas[i] = datas[j];
		datas[j] = temporary;
	}
}

enum TYPE {
	MINIMUM, MAXIMUM;
}
