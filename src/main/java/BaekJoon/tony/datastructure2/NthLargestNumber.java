package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NthLargestNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int arr[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int solution = solution(n, arr);
		System.out.println(solution);

	}

	public static int solution(int n, int[][] arr) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				pq.offer(arr[i][j]);
			}
		}

		while (n-- > 1) {
			pq.poll();
		}

		return pq.peek();
	}
}
