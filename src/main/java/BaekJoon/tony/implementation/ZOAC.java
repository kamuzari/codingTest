package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ZOAC {
	static class Part {

		int order;
		char ch;

		public Part(int order, char ch) {
			this.order = order;
			this.ch = ch;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		Comparator<Part> dictionaryOrders = (a, b) -> {
			if (a.ch == b.ch) {
				return a.order - b.order;
			}

			return Character.compare(a.ch, b.ch);
		};

		PriorityQueue<Part> nexts = new PriorityQueue<>(dictionaryOrders);
		int order = 0;
		for (char next : s.toCharArray()) {
			nexts.offer(new Part(order++, next));
		}

		String[] prints = new String[s.length()];
		StringBuilder answer = new StringBuilder();
		while (!nexts.isEmpty()) {
			Part poll = nexts.poll();
			prints[poll.order] = String.valueOf(poll.ch);

			for (String value : prints) {
				if (value != null && !value.isBlank()) {
					answer.append(value);
				}
			}

			answer.append(System.lineSeparator());
		}

		System.out.println(answer);
	}
}
