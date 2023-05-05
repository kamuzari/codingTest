package BaekJoon.tony.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FileCombine3 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(reader.readLine());
		StringBuilder answer = new StringBuilder();
		while (testCase-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			int files[] = new int[n];

			StringTokenizer st = new StringTokenizer(reader.readLine());

			for (int i = 0; i < n; i++) {
				files[i] = Integer.parseInt(st.nextToken());
			}

			answer.append(solution(n, files)+"\n");
		}
		System.out.println(answer);
	}

	private static long solution(int n, int[] files) {
		PriorityQueue<Long> pq=new PriorityQueue<>();

		for(int paper: files){
			pq.offer((long)paper);
		}
		long sum=0;
		while(pq.size()>1){
			long a=pq.poll();
			long b=pq.poll();
			sum+=(a+b);

			pq.offer(a+b);
		}

		return sum;
	}
}
