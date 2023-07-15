package BaekJoon._자료구조구현.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MediumValueSpeak {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		StringBuilder answer = new StringBuilder();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(sc.nextLine());
			if (maxHeap.size() == minHeap.size()) {
				maxHeap.add(val);
			} else {
				minHeap.add(val);
			}
			boolean isNotAllEmpty = !maxHeap.isEmpty() && !minHeap.isEmpty();
			if (isNotAllEmpty) {
				if (maxHeap.peek() > minHeap.peek()) {
					Integer v1 = maxHeap.poll();
					Integer v2 = minHeap.poll();

					maxHeap.add(v2);
					minHeap.add(v1);
				}
			}
			answer.append(maxHeap.peek()).append("\n");
		}

		System.out.println(answer);
	}
}
