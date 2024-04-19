package BaekJoon.단기간성장;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class SpeakMiddle {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}

		PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> b = new PriorityQueue<>();

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int candidate = arr[i];

			if (a.size() == 0) {
				a.add(candidate);
			} else if (b.size() == 0) {
				a.add(candidate);
				b.add(a.poll());
			} else {
				if (b.peek() <= candidate) {
					b.add(candidate);
					if (b.size() > a.size()) {
						a.add(b.poll());
					}
				} else {
					a.add(candidate);
					int isDiff = a.size() - b.size();
					if (isDiff >= 2) {
						b.add(a.poll());
					}
				}
			}

			// System.out.println(a + "  ---   " + b);
			answer.append(a.peek()).append(System.lineSeparator());
		}

		System.out.println(answer);
	}

}
