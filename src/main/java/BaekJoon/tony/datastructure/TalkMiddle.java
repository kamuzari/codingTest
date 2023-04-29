package BaekJoon.tony.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class TalkMiddle {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		StringBuilder answer = new StringBuilder();
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(reader.readLine());
			if (minQ.size() == maxQ.size()) {
				maxQ.offer(val);
			}else{
				minQ.offer(val);
			}

			if(!maxQ.isEmpty() && !minQ.isEmpty()){
				if(minQ.peek() < maxQ.peek()){
					Integer v1 = maxQ.poll();
					Integer v2 = minQ.poll();

					minQ.offer(v1);
					maxQ.offer(v2);
				}
			}

			answer.append(maxQ.peek()).append("\n");
		}

		System.out.println(answer);
	}
}
