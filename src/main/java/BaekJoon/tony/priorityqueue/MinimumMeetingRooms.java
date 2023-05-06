package BaekJoon.tony.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 3
 1 5
 2 3
 3 4
 */
public class MinimumMeetingRooms {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int meetings[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, meetings));
	}

	static int solution(int n, int[][] meetings) {
		Arrays.sort(meetings,(a,b)-> a[0]-b[0]);
		PriorityQueue<Integer> pq=new PriorityQueue<>(); // 회의 끝나는 시간 오름차순
		int answer=0;

		for(int[] meeting: meetings){
			while(!pq.isEmpty() && pq.peek()<=meeting[0]){
				pq.poll();
			}

			pq.offer(meeting[1]);
			answer=Math.max(answer,pq.size());
		}

		return answer;
	}
}
