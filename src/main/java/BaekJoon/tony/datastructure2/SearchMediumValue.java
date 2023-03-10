package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SearchMediumValue {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int repeat = Integer.parseInt(reader.readLine());
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < repeat; i++) {

			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();

			int n = Integer.parseInt(reader.readLine());
			int totalCount = n / 2 + 1;
			answer.append(totalCount).append("\n");
			List<Integer> results = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(reader.readLine());

			for (int j = 0; j < n; j++) {
				if (j!=0 && j % 10 == 0) {
					st = new StringTokenizer(reader.readLine());
				}

				int val = Integer.parseInt(st.nextToken());

				if (maxHeap.size() == minHeap.size()) {
					maxHeap.offer(val);
				} else {
					minHeap.offer(val);
				}

				if (!minHeap.isEmpty()) {
					if (maxHeap.peek() > minHeap.peek()) {
						int t1 = maxHeap.poll();
						int t2 = minHeap.poll();

						maxHeap.offer(t2);
						minHeap.offer(t1);
					}
				}

				if (j % 2 == 0) {
					results.add(maxHeap.peek());
				}
			}

			for (int j = 0; j < results.size(); j++) {
				if (j!=0 && j % 10 == 0) {
					answer.append("\n").append(results.get(j)).append(" ");
				} else {
					answer.append(results.get(j) + " ");
				}
			}

			answer.append("\n");
		}

		System.out.println(answer);
	}
}
