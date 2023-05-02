package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TravelLecture {
	static class Node implements Comparable<Node>{
		int profit,deadLine;

		public Node(int profit, int deadLine){
			this.profit=profit;
			this.deadLine= deadLine;
		}

		@Override
		public int compareTo(Node o){
			return o.profit - this.profit;
		}

		public String toString(){
			return "profit: "+profit+", deadLine: "+deadLine;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int dayOfMax=0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int profit=Integer.parseInt(st.nextToken());
			int deadLine=Integer.parseInt(st.nextToken());
			dayOfMax=Math.max(dayOfMax,deadLine);
			pq.offer(new Node(profit,deadLine));
		}


		int days[]=new int[dayOfMax+1];
		while(!pq.isEmpty()){
			Node cur=pq.poll();
			for(int i=cur.deadLine; i>0; i--){
				if(days[i]==0){
					days[i]=cur.profit;
					break;
				}
			}
		}

		int answer= Arrays.stream(days).sum();
		System.out.println(answer);
	}
}
