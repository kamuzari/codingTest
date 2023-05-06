package BaekJoon.tony.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Lecture {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int[][] lectures = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());

			st.nextToken();
			lectures[i][0] = Integer.parseInt(st.nextToken());
			lectures[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, lectures));
	}

	static int solution(int n, int[][] lectures) {
		Arrays.sort(lectures, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}

			return a[1] - b[1];
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int[] lecture : lectures) {
			int start = lecture[0];
			int end = lecture[1];

			if (!pq.isEmpty() && pq.peek() <= start) {
				pq.poll();
			}

			pq.offer(end);
		}

		return pq.size();
	}
}
/**
4
1 1 2
2 1 4
3 2 6
4 4 5
 */