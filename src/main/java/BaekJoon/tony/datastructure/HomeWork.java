package BaekJoon.tony.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HomeWork {
	static class Node implements Comparable<Node> {
		int deadline, score;

		public Node(int deadline, int score) {
			this.deadline = deadline;
			this.score = score;
		}

		@Override
		public int compareTo(Node o) {
			return o.score-this.score;
		}
	}

	/**
	 * note: 하루에 하나의 과제만 수행할 수 있다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int maxDay = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			maxDay = Math.max(deadline, maxDay);
			int score = Integer.parseInt(st.nextToken());
			pq.offer(new Node(deadline, score));
		}

		int scoreOfDay[] = new int[maxDay + 1];
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (int i = cur.deadline; i >= 1; i--) {
				if (scoreOfDay[i] != 0) {
					continue;
				} else {
					scoreOfDay[i] = cur.score;
					break;
				}
			}
		}

		System.out.println(Arrays.stream(scoreOfDay).sum());
	}
}
