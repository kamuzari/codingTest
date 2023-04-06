package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class DeliciousFoodDoYoung {
	static class Element {
		int sour, sweet; // 신맛, 단맛

		public Element(int sour, int sweet) {
			this.sour = sour;
			this.sweet = sweet;
		}

	}

	static int diff = Integer.MAX_VALUE; // 신맛, 단맛의 차이

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Element> elements = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());

			int sour = Integer.parseInt(st.nextToken());
			int sweet = Integer.parseInt(st.nextToken());

			elements.add(new Element(sour, sweet));
		}

		pick(0, 0, elements, new Stack<>());

		System.out.println(diff);
	}

	public static void pick(int cnt, int idx, List<Element> elements, Stack<Element> pickedElements) {
		if (cnt > elements.size()) {
			return;
		}

		if (!pickedElements.isEmpty()) {
			Integer totalSour = pickedElements.stream().map(element -> element.sour).reduce(1, (a, b) -> a * b);
			Integer totalSweet = pickedElements.stream().map(element -> element.sweet).reduce(0, Integer::sum);

			int newDiff = Math.abs(totalSour - totalSweet);
			diff = Math.min(diff, newDiff);

		}

		for (int i = idx; i < elements.size(); i++) {
			pickedElements.push(elements.get(i));
			pick(cnt + 1, i + 1, elements, pickedElements);
			pickedElements.pop();
		}

	}
}
